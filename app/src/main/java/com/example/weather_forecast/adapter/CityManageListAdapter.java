package com.example.weather_forecast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weather_forecast.R;
import com.example.weather_forecast.bean.WeatherInfoBean;
import com.example.weather_forecast.db.CityBean;
import com.google.gson.Gson;

import java.util.List;

/**
 * @PackageName: com.example.weather_forecast.adapter
 * @ClassName: CityManageListAdapter
 * @Author: winwa
 * @Date: 2023/1/23 7:02
 * @Description:
 **/
public class CityManageListAdapter extends BaseAdapter {
    private Context mContext;
    private List<CityBean> mData;

    public CityManageListAdapter(Context context, List<CityBean> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_listview_city_manage, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        CityBean cityBean = mData.get(i);
        holder.mCityTV.setText(cityBean.getCity());
        WeatherInfoBean weatherInfoBean = new Gson().fromJson(cityBean.getContent(), WeatherInfoBean.class);

        WeatherInfoBean.ResultBean resultsBean = weatherInfoBean.getResult();
        WeatherInfoBean.ResultBean.FutureBean todayWeatherBean = resultsBean.getFuture().get(0);
        WeatherInfoBean.ResultBean.RealtimeBean realtimeBean = resultsBean.getRealtime();

        holder.mTempTV.setText(realtimeBean.getTemperature() + "℃");
        holder.mCondTV.setText(realtimeBean.getInfo());
        holder.mWindTV.setText(realtimeBean.getDirect() + "" + realtimeBean.getPower());
        holder.mTempRangeTV.setText(todayWeatherBean.getTemperature());

        return view;
    }

    class ViewHolder {
        TextView mCityTV;
        TextView mTempTV;
        TextView mCondTV;
        TextView mWindTV;
        TextView mTempRangeTV;

        public ViewHolder(View view) {
            mCityTV = view.findViewById(R.id.lvitem_city_tv);
            mTempTV = view.findViewById(R.id.lvitem_temp_tv);
            mCondTV = view.findViewById(R.id.lvitem_cond_tv);
            mWindTV = view.findViewById(R.id.lvitem_wind_cv);
            mTempRangeTV = view.findViewById(R.id.lvitem_temprange_cv);
        }
    }
}
