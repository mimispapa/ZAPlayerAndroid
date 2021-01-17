package com.cn.zaplayer.di.component;

import com.cn.zaplayer.di.module.NetModule;
import com.cn.zaplayer.network.RetrofitUtil;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {NetModule.class})
@Singleton
public interface NetComponent {
    RetrofitUtil getRetrofitUtil();
}
