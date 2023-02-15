package com.example.weather_forecast.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @PackageName: com.example.weather_forecast.utils
 * @ClassName: HttpUtils
 * @Author: winwa
 * @Date: 2023/2/15 8:01
 * @Description:
 **/
public class HttpUtils {

    public static String getString(String url) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            InputStream inputStream = connection.getInputStream();

            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = inputStream.read(buf)) != -1) {
                byteArrayOutputStream.write(buf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream.toString();
    }
}
