package com.cn.zaplayer.di.module;

import com.cn.zaplayer.config.UrlConfig;
import com.cn.zaplayer.entity.BaseUrlEntity;
import com.cn.zaplayer.network.RetrofitUtil;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetModule {
    @Singleton
    @Provides
    public RetrofitUtil provideRetrofitUtil(){
        return new RetrofitUtil();
    }


    @Singleton
    @Provides
    public List<BaseUrlEntity> urlEntityList(){
        return UrlConfig.urlList();
    }

}
