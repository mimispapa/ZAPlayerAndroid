package com.cn.zaplayer;

import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cn.zaplayer.config.UrlConfig;
import com.cn.zaplayer.di.component.ApplicationComponent;
import com.cn.zaplayer.di.component.DaggerApplicationComponent;
import com.cn.zaplayer.di.module.ApplicationModule;
import com.cn.zaplayer.di.module.NetModule;
import com.facebook.drawee.backends.pipeline.Fresco;

public class ZaApplication extends MultiDexApplication {
    private  static ZaApplication INSTANCE = null;
    public  static ZaApplication  getApplication(){
        return INSTANCE;
    }

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initCommon();
        initDagger();
    }

    private void initCommon(){
        Fresco.initialize(this);
        if (BuildConfig.DEBUG){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        UrlConfig.load(this);

    }

    private void initDagger(){
        applicationComponent = DaggerApplicationComponent.builder()
                .netModule(new NetModule())
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
