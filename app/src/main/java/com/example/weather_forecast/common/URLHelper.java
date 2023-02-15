package com.example.weather_forecast.common;

/**
 * @PackageName: com.example.weather_forecast.utils
 * @ClassName: URLHelper
 * @Author: winwa
 * @Date: 2023/1/18 21:21
 * @Description:
 **/
public class URLHelper {
    private static final String KEY = "3cef7226d9ae810d67346c890867e3c0";

    public static String getWeatherUrl(String cityName) {
        return "http://apis.juhe.cn/simpleWeather/query?city=" + cityName + "&key=" + KEY;
    }

    public static String getIndexUrl(String cityName) {
        return "http://apis.juhe.cn/simpleWeather/life?city=" + cityName + "&key=" + KEY;
    }
}
