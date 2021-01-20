package com.cn.zaplayer.di.component;

import com.cn.zaplayer.di.module.MainModule;
import com.cn.zaplayer.di.scope.ActivityScope;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent
public interface CommonActivityComponent {
    MainComponent getMainComponent(MainModule mainModule);
}
