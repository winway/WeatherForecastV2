package com.example.weather_forecast.bean;

import java.util.List;

/**
 * @PackageName: com.example.weather_forecast.bean
 * @ClassName: WeatherInfo
 * @Author: winwa
 * @Date: 2023/1/17 21:19
 * @Description:
 **/
public class WeatherInfoBean {

    /**
     * reason : 查询成功!
     * result : {"city":"西安","realtime":{"temperature":"2","humidity":"89","info":"多云","wid":"01","direct":"东北风","power":"2级","aqi":"46"},"future":[{"date":"2023-02-14","temperature":"-1/8℃","weather":"晴转多云","wid":{"day":"00","night":"01"},"direct":"持续无风向"},{"date":"2023-02-15","temperature":"0/6℃","weather":"多云","wid":{"day":"01","night":"01"},"direct":"持续无风向"},{"date":"2023-02-16","temperature":"1/9℃","weather":"多云","wid":{"day":"01","night":"01"},"direct":"持续无风向"},{"date":"2023-02-17","temperature":"4/13℃","weather":"多云转阴","wid":{"day":"01","night":"02"},"direct":"持续无风向"},{"date":"2023-02-18","temperature":"4/10℃","weather":"多云","wid":{"day":"01","night":"01"},"direct":"持续无风向"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * city : 西安
         * realtime : {"temperature":"2","humidity":"89","info":"多云","wid":"01","direct":"东北风","power":"2级","aqi":"46"}
         * future : [{"date":"2023-02-14","temperature":"-1/8℃","weather":"晴转多云","wid":{"day":"00","night":"01"},"direct":"持续无风向"},{"date":"2023-02-15","temperature":"0/6℃","weather":"多云","wid":{"day":"01","night":"01"},"direct":"持续无风向"},{"date":"2023-02-16","temperature":"1/9℃","weather":"多云","wid":{"day":"01","night":"01"},"direct":"持续无风向"},{"date":"2023-02-17","temperature":"4/13℃","weather":"多云转阴","wid":{"day":"01","night":"02"},"direct":"持续无风向"},{"date":"2023-02-18","temperature":"4/10℃","weather":"多云","wid":{"day":"01","night":"01"},"direct":"持续无风向"}]
         */

        private String city;
        private RealtimeBean realtime;
        private List<FutureBean> future;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeBean realtime) {
            this.realtime = realtime;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture(List<FutureBean> future) {
            this.future = future;
        }

        public static class RealtimeBean {
            /**
             * temperature : 2
             * humidity : 89
             * info : 多云
             * wid : 01
             * direct : 东北风
             * power : 2级
             * aqi : 46
             */

            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
            private String aqi;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getWid() {
                return wid;
            }

            public void setWid(String wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }
        }

        public static class FutureBean {
            /**
             * date : 2023-02-14
             * temperature : -1/8℃
             * weather : 晴转多云
             * wid : {"day":"00","night":"01"}
             * direct : 持续无风向
             */

            private String date;
            private String temperature;
            private String weather;
            private WidBean wid;
            private String direct;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WidBean getWid() {
                return wid;
            }

            public void setWid(WidBean wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public static class WidBean {
                /**
                 * day : 00
                 * night : 01
                 */

                private String day;
                private String night;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public String getNight() {
                    return night;
                }

                public void setNight(String night) {
                    this.night = night;
                }
            }
        }
    }
}
