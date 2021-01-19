package com.cn.zaplayer;

import androidx.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cn.zaplayer.config.UrlConfig;
import com.cn.zaplayer.di.component.DaggerNetComponent;
import com.cn.zaplayer.di.component.NetComponent;
import com.cn.zaplayer.di.module.NetModule;
import com.facebook.drawee.backends.pipeline.Fresco;

public class ZaApplication extends MultiDexApplication {
    private  static ZaApplication INSTANCE = null;
    public  static ZaApplication  getApplication(){
        return INSTANCE;
    }
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);

        UrlConfig.load(this);
        initDagger();
        INSTANCE = this;

        Fresco.initialize(this);
    }

    private void initDagger(){
        netComponent = DaggerNetComponent.builder()
                .netModule(new NetModule())
                .build();

    }

    public NetComponent getNetComponent(){
        return netComponent;
    }

}
