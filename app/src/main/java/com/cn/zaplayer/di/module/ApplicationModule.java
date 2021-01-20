package com.cn.zaplayer.di.module;

import android.content.Context;

import com.cn.zaplayer.ZaApplication;
import com.cn.zaplayer.di.scope.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private ZaApplication application;

    public ApplicationModule(ZaApplication application) {
        this.application = application;
    }


    @Provides
    @Singleton
    ZaApplication provideApplication(){
        return this.application;
    }

}
