package com.cn.zaplayer.di.component;

import com.cn.zaplayer.di.module.ApplicationModule;
import com.cn.zaplayer.di.module.NetModule;
import com.cn.zaplayer.di.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {
    CommonActivityComponent getCommonActivityComponent();
}
