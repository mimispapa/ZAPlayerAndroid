package com.cn.zaplayer.di.component;

import com.cn.zaplayer.ui.main.MainActivity;
import com.cn.zaplayer.di.module.MainModule;
import com.cn.zaplayer.di.scope.UserScope;

import dagger.Component;

@UserScope
@Component(modules = {MainModule.class}, dependencies = {NetComponent.class})
public interface MainComponent  {
    void inject(MainActivity activity);
}
