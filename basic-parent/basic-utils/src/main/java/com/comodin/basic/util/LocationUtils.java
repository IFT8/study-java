package com.comodin.basic.util;

import org.apache.log4j.Logger;

public class LocationUtils {
    private static final Logger log = Logger.getLogger(LocationUtils.class);

    private static double R = 6378.137;   //地球半径

    /**
     * 通过经纬度获取距离(单位：米)
     *
     * @return 米
     */
    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        lat1 = lat1 * (Math.PI / 180);
        lng1 = lng1 * (Math.PI / 180);
        lat2 = lat2 * (Math.PI / 180);
        lng2 = lng2 * (Math.PI / 180);
        //两点间距离 km，如果想要米的话，结果*1000 就可以了
        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lng1 - lng2)) * R;
        double result = d * 1000;
        log.info(String.format("lat1:%s lng1:%s -- lat2:%s lng2:%s distance:%s", lat1, lng1, lat2, lng2, result));
        return result;
    }

    //private static double rad(double d) {
    //    return d * (Math.PI / 180.0);
    //}
    //
    ///**
    // * 通过经纬度获取距离(单位：米)
    // *
    // * @param lat1
    // * @param lng1
    // * @param lat2
    // * @param lng2
    // *
    // * @return
    // */
    //public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
    //    double radLat1 = rad(lat1);
    //    double radLat2 = rad(lat2);
    //    double a = radLat1 - radLat2;
    //    double b = rad(lng1) - rad(lng2);
    //    double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
    //    s = s * R;
    //    s = Math.round(s * 10000d) / 10000d;
    //    s = s * 1000;
    //    return s;
    //}
}  