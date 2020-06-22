package com.wangqingyi.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtil {
    public static void sendOkHtttpRequest(String address, okhttp3.Callback callback){
        //创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        //创建一个Request请求
        Request request = new Request
                .Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }

}
