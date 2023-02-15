package com.example.weather_forecast;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.weather_forecast.bean.IndexInfoBean;
import com.example.weather_forecast.bean.WeatherInfoBean;
import com.example.weather_forecast.common.BaseFragment;
import com.example.weather_forecast.common.URLHelper;
import com.example.weather_forecast.db.DBManager;
import com.example.weather_forecast.utils.HttpUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "WeatherFragment";
    private static final String ARG_CITY = "city";
    private static final int MSG_INDEX_DATA = 1;

    private ScrollView mWeatherSv;

    private TextView mTempTv;
    private TextView mCityTv;
    private TextView mCondTv;
    private TextView mDateTv;
    private TextView mWindTv;
    private TextView mTempRangeTv;
    private ImageView mPicTv;

    private LinearLayout mFutureLl;

    private TextView mIndexDressTv;
    private TextView mIndexCarTv;
    private TextView mIndexColdTv;
    private TextView mIndexSportTv;
    private TextView mIndexRayTv;
    private TextView mAirCondTv;

    private String city;
    private IndexInfoBean mIndexInfoBean;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == MSG_INDEX_DATA) {
                String result = (String) msg.obj;
                mIndexInfoBean = new Gson().fromJson(result, IndexInfoBean.class);
            }
        }
    };

    public static WeatherFragment newInstance(String city) {
        Bundle args = new Bundle();
        args.putString(ARG_CITY, city);
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        initView(view);

        setBg();

        Bundle bundle = getArguments();
        city = bundle.getString(ARG_CITY);

        String url = URLHelper.getWeatherUrl(city);
        Log.i(TAG, "onCreateView: " + url);
        loadData(url);

        loadIndexData();

        return view;
    }

    private void loadIndexData() {
        String url = URLHelper.getIndexUrl(city);
        Log.i(TAG, "loadIndexData: " + url);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = HttpUtils.getString(url);
                Message message = mHandler.obtainMessage();
                message.what = MSG_INDEX_DATA;
                message.obj = result;
                mHandler.sendMessage(message);
            }
        }).start();
    }

    private void setBg() {
        SharedPreferences preferences = getActivity().getSharedPreferences("bg", Context.MODE_PRIVATE);
        int id = preferences.getInt("bg", 0);
        if (id == 0) {
            mWeatherSv.setBackgroundResource(R.mipmap.bg);
        } else if (id == 1) {
            mWeatherSv.setBackgroundResource(R.mipmap.bg2);
        } else if (id == 2) {
            mWeatherSv.setBackgroundResource(R.mipmap.bg3);
        }
    }

    @Override
    public void onSuccess(String result) {
        super.onSuccess(result);
        parseData(result);
        int nRows = DBManager.updateContentByCity(city, result);
        if (nRows <= 0) {
            Log.i(TAG, "onSuccess: add " + city);
            DBManager.addCity(city, result);
        }
    }

    private void parseData(String result) {
        WeatherInfoBean weatherInfoBean = new Gson().fromJson(result, WeatherInfoBean.class);
        if (weatherInfoBean.getError_code() != 0) {
            Log.i(TAG, "parseData: " + weatherInfoBean.getReason());
            return;
        }
        WeatherInfoBean.ResultBean resultsBean = weatherInfoBean.getResult();
        WeatherInfoBean.ResultBean.FutureBean todayWeatherBean = resultsBean.getFuture().get(0);
        WeatherInfoBean.ResultBean.RealtimeBean realtimeBean = resultsBean.getRealtime();

        mTempTv.setText(realtimeBean.getTemperature() + "℃");
        mCityTv.setText(resultsBean.getCity());
        mCondTv.setText(realtimeBean.getInfo());
        mDateTv.setText(todayWeatherBean.getDate());
        mWindTv.setText(realtimeBean.getDirect() + "" + realtimeBean.getPower());
        mTempRangeTv.setText(todayWeatherBean.getTemperature());

        List<WeatherInfoBean.ResultBean.FutureBean> futureWeatherList = resultsBean.getFuture();
        futureWeatherList.remove(0);
        for (int i = 0; i < futureWeatherList.size(); i++) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_weather_future, null);
            view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            mFutureLl.addView(view);
            TextView fDateTv = view.findViewById(R.id.item_future_date_tv);
            TextView fCondTv = view.findViewById(R.id.item_future_condition_tv);
            TextView fWindTv = view.findViewById(R.id.item_future_wind_tv);
            TextView fTempTv = view.findViewById(R.id.item_future_temp_tv);
            ImageView fPicIv = view.findViewById(R.id.item_future_pic_iv);

            WeatherInfoBean.ResultBean.FutureBean weatherDataBean = futureWeatherList.get(i);
            fDateTv.setText(weatherDataBean.getDate());
            fCondTv.setText(weatherDataBean.getWeather());
            fWindTv.setText(weatherDataBean.getDirect());
            fTempTv.setText(weatherDataBean.getTemperature());
        }
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        super.onError(ex, isOnCallback);
        String result = DBManager.queryContentByCity(city);
        if (!TextUtils.isEmpty(result)) {
            parseData(result);
        }
    }

    private void initView(View view) {
        mWeatherSv = view.findViewById(R.id.weather_sv);

        mTempTv = view.findViewById(R.id.weather_temp_tv);
        mCityTv = view.findViewById(R.id.weather_city_tv);
        mCondTv = view.findViewById(R.id.weather_condition_tv);
        mDateTv = view.findViewById(R.id.weather_date_tv);
        mWindTv = view.findViewById(R.id.weather_wind_tv);
        mTempRangeTv = view.findViewById(R.id.weather_temprange_tv);
        mPicTv = view.findViewById(R.id.weather_pic_tv);

        mFutureLl = view.findViewById(R.id.weather_future_ll);

        mIndexDressTv = view.findViewById(R.id.weather_index_dress_tv);
        mIndexCarTv = view.findViewById(R.id.weather_index_car_tv);
        mIndexColdTv = view.findViewById(R.id.weather_index_cold_tv);
        mIndexSportTv = view.findViewById(R.id.weather_index_sport_tv);
        mIndexRayTv = view.findViewById(R.id.weather_index_ray_tv);
        mAirCondTv = view.findViewById(R.id.weather_index_air_cond_tv);

        mIndexDressTv.setOnClickListener(this);
        mIndexCarTv.setOnClickListener(this);
        mIndexColdTv.setOnClickListener(this);
        mIndexSportTv.setOnClickListener(this);
        mIndexRayTv.setOnClickListener(this);
        mAirCondTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        IndexInfoBean.ResultBean.LifeBean lifeBean = mIndexInfoBean.getResult().getLife();

        String title = "";
        String message = "暂无数据";
        switch (view.getId()) {
            case R.id.weather_index_dress_tv:
                title = "穿衣指数";
                message = lifeBean.getChuanyi().getV() + "\n" + lifeBean.getChuanyi().getDes();
                break;
            case R.id.weather_index_car_tv:
                title = "洗车指数";
                message = lifeBean.getXiche().getV() + "\n" + lifeBean.getXiche().getDes();
                break;
            case R.id.weather_index_cold_tv:
                title = "感冒指数";
                message = lifeBean.getGanmao().getV() + "\n" + lifeBean.getGanmao().getDes();
                break;
            case R.id.weather_index_sport_tv:
                title = "运动指数";
                message = lifeBean.getYundong().getV() + "\n" + lifeBean.getYundong().getDes();
                break;
            case R.id.weather_index_ray_tv:
                title = "紫外线指数";
                message = lifeBean.getZiwaixian().getV() + "\n" + lifeBean.getZiwaixian().getDes();
                break;
            case R.id.weather_index_air_cond_tv:
                title = "空调指数";
                message = lifeBean.getKongtiao().getV() + "\n" + lifeBean.getKongtiao().getDes();
                break;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("确定", null);
        builder.show();
    }
}