package com.cn.zaplayer.network;

import android.util.Log;

import com.cn.zaplayer.network.api.ApiService;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private OkHttpClient okHttpClient;
    private GsonConverterFactory gsonConverterFactory;
    private RxJava2CallAdapterFactory rxJava2CallAdapterFactory;

    private OkHttpClient provideOkHttpClient() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor())
                    .retryOnConnectionFailure(false)
                    .build();
        }

        return okHttpClient;
    }


    public ApiService createApi(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(provideOkHttpClient())
                .addConverterFactory(provideGsonConverterFactory())
                .addCallAdapterFactory(provideRxJava2CallAdapterFactory())
                .build();

        return retrofit.create(ApiService.class);
    }


    private GsonConverterFactory provideGsonConverterFactory(){
        if (gsonConverterFactory == null){
            gsonConverterFactory = GsonConverterFactory.create();
        }

        return gsonConverterFactory;
    }

    private RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory(){
        if (rxJava2CallAdapterFactory == null){
            rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create();
        }

        return rxJava2CallAdapterFactory;
    }

    /**
     * logger 拦截器
     *
     * @return HttpLoggingInterceptor
     */
    private static HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return loggingInterceptor;
    }

    private static class HttpLogger implements HttpLoggingInterceptor.Logger {

        @Override
        public void log(String message) {
            Log.e("HttpLog", message);
        }
    }

}
