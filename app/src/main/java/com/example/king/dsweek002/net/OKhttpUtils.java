package com.example.king.dsweek002.net;

import android.os.Handler;
import android.text.TextUtils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OKhttpUtils {

    private static OKhttpUtils instance;
    private final OkHttpClient okHttpClient;
    private final Handler handler;

    private OKhttpUtils() {
        handler = new Handler();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    public static OKhttpUtils getInstance(){
        if (instance == null) {
            synchronized (OKhttpUtils.class){
                if (instance == null) {
                    instance = new OKhttpUtils();
                }
            }
        }
        return instance;
    }

    /**
     * GET请求
     * @param param
     * @param api
     * @param oKhttpUtilsCallBack
     */
    public void toGet(Map<String,String> param, String api, final OKhttpUtilsCallBack oKhttpUtilsCallBack){
        StringBuilder b = new StringBuilder();
        if (param!=null&&param.size()>0){
            for (Map.Entry<String, String> p : param.entrySet()) {
                b.append(p.getKey()).append("=").append(p.getValue()).append("&");
            }
        }

        Request request = new Request.Builder()
                .get()
                .url(api+"?"+b.toString())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        oKhttpUtilsCallBack.failure("网络错误!!");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();
                if (!TextUtils.isEmpty(res)){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            oKhttpUtilsCallBack.success(res);
                        }
                    });
                }
            }
        });
    }

    /**
     * toPost请求
     * @param param
     * @param api
     * @param oKhttpUtilsCallBack
     */
    public void toPost(Map<String,String> param, String api, final OKhttpUtilsCallBack oKhttpUtilsCallBack){

        FormBody.Builder builder = new FormBody.Builder();
        if (param != null){
            for (Map.Entry<String, String> p : param.entrySet()) {
                builder.add(p.getKey(),p.getValue());
            }
        }

        Request request = new Request.Builder()
                .post(builder.build())
                .url(api)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        oKhttpUtilsCallBack.failure("网络错误!!");
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String res = response.body().string();
                if (!TextUtils.isEmpty(res)){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            oKhttpUtilsCallBack.success(res);
                        }
                    });

                }
            }
        });
    }

    /**
     * 取消所有请求，好处：节省开销：内存开销，cpu的开销（线程开销）
     */
    public void cancelAllTask(){
        if (okHttpClient != null){
            okHttpClient.dispatcher().cancelAll();
        }
    }
}
