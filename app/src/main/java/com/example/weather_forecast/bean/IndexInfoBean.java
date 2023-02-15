package com.example.weather_forecast.bean;

/**
 * @PackageName: com.example.weather_forecast.bean
 * @ClassName: IndexInfoBean
 * @Author: winwa
 * @Date: 2023/2/14 8:20
 * @Description:
 **/
public class IndexInfoBean {

    /**
     * reason : 查询成功!
     * result : {"city":"西安","life":{"kongtiao":{"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"},"guomin":{"v":"极不易发","des":"天气条件极不易诱发过敏，可放心外出，享受生活。"},"shushidu":{"v":"较舒适","des":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。"},"chuanyi":{"v":"较冷","des":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"diaoyu":{"v":"较适宜","des":"较适合垂钓，但天气稍凉，会对垂钓产生一定的影响。"},"ganmao":{"v":"较易发","des":"昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。"},"ziwaixian":{"v":"弱","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},"xiche":{"v":"不宜","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"yundong":{"v":"较适宜","des":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"},"daisan":{"v":"不带伞","des":"天气较好，您在出门的时候无须带雨伞。"}}}
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
         * life : {"kongtiao":{"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"},"guomin":{"v":"极不易发","des":"天气条件极不易诱发过敏，可放心外出，享受生活。"},"shushidu":{"v":"较舒适","des":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。"},"chuanyi":{"v":"较冷","des":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"diaoyu":{"v":"较适宜","des":"较适合垂钓，但天气稍凉，会对垂钓产生一定的影响。"},"ganmao":{"v":"较易发","des":"昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。"},"ziwaixian":{"v":"弱","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},"xiche":{"v":"不宜","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"yundong":{"v":"较适宜","des":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"},"daisan":{"v":"不带伞","des":"天气较好，您在出门的时候无须带雨伞。"}}
         */

        private String city;
        private LifeBean life;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public LifeBean getLife() {
            return life;
        }

        public void setLife(LifeBean life) {
            this.life = life;
        }

        public static class LifeBean {
            /**
             * kongtiao : {"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"}
             * guomin : {"v":"极不易发","des":"天气条件极不易诱发过敏，可放心外出，享受生活。"}
             * shushidu : {"v":"较舒适","des":"白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。"}
             * chuanyi : {"v":"较冷","des":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
             * diaoyu : {"v":"较适宜","des":"较适合垂钓，但天气稍凉，会对垂钓产生一定的影响。"}
             * ganmao : {"v":"较易发","des":"昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。"}
             * ziwaixian : {"v":"弱","des":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"}
             * xiche : {"v":"不宜","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"}
             * yundong : {"v":"较适宜","des":"天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。"}
             * daisan : {"v":"不带伞","des":"天气较好，您在出门的时候无须带雨伞。"}
             */

            private KongtiaoBean kongtiao;
            private GuominBean guomin;
            private ShushiduBean shushidu;
            private ChuanyiBean chuanyi;
            private DiaoyuBean diaoyu;
            private GanmaoBean ganmao;
            private ZiwaixianBean ziwaixian;
            private XicheBean xiche;
            private YundongBean yundong;
            private DaisanBean daisan;

            public KongtiaoBean getKongtiao() {
                return kongtiao;
            }

            public void setKongtiao(KongtiaoBean kongtiao) {
                this.kongtiao = kongtiao;
            }

            public GuominBean getGuomin() {
                return guomin;
            }

            public void setGuomin(GuominBean guomin) {
                this.guomin = guomin;
            }

            public ShushiduBean getShushidu() {
                return shushidu;
            }

            public void setShushidu(ShushiduBean shushidu) {
                this.shushidu = shushidu;
            }

            public ChuanyiBean getChuanyi() {
                return chuanyi;
            }

            public void setChuanyi(ChuanyiBean chuanyi) {
                this.chuanyi = chuanyi;
            }

            public DiaoyuBean getDiaoyu() {
                return diaoyu;
            }

            public void setDiaoyu(DiaoyuBean diaoyu) {
                this.diaoyu = diaoyu;
            }

            public GanmaoBean getGanmao() {
                return ganmao;
            }

            public void setGanmao(GanmaoBean ganmao) {
                this.ganmao = ganmao;
            }

            public ZiwaixianBean getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(ZiwaixianBean ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public XicheBean getXiche() {
                return xiche;
            }

            public void setXiche(XicheBean xiche) {
                this.xiche = xiche;
            }

            public YundongBean getYundong() {
                return yundong;
            }

            public void setYundong(YundongBean yundong) {
                this.yundong = yundong;
            }

            public DaisanBean getDaisan() {
                return daisan;
            }

            public void setDaisan(DaisanBean daisan) {
                this.daisan = daisan;
            }

            public static class KongtiaoBean {
                /**
                 * v : 较少开启
                 * des : 您将感到很舒适，一般不需要开启空调。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class GuominBean {
                /**
                 * v : 极不易发
                 * des : 天气条件极不易诱发过敏，可放心外出，享受生活。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ShushiduBean {
                /**
                 * v : 较舒适
                 * des : 白天虽然天气晴好，但早晚会感觉偏凉，午后舒适、宜人。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ChuanyiBean {
                /**
                 * v : 较冷
                 * des : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class DiaoyuBean {
                /**
                 * v : 较适宜
                 * des : 较适合垂钓，但天气稍凉，会对垂钓产生一定的影响。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class GanmaoBean {
                /**
                 * v : 较易发
                 * des : 昼夜温差较大，较易发生感冒，请适当增减衣服。体质较弱的朋友请注意防护。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ZiwaixianBean {
                /**
                 * v : 弱
                 * des : 紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class XicheBean {
                /**
                 * v : 不宜
                 * des : 不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class YundongBean {
                /**
                 * v : 较适宜
                 * des : 天气较好，无雨水困扰，较适宜进行各种运动，但因气温较低，在户外运动请注意增减衣物。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class DaisanBean {
                /**
                 * v : 不带伞
                 * des : 天气较好，您在出门的时候无须带雨伞。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }
    }
}
