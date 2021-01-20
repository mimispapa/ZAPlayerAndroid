package com.cn.zaplayer.di.component;

import com.cn.zaplayer.di.module.MainModule;
import com.cn.zaplayer.di.scope.UserScope;
import com.cn.zaplayer.ui.main.MainActivity;

import dagger.Subcomponent;

@UserScope
@Subcomponent(modules = {MainModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
