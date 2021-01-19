package com.cn.zaplayer.di.component;

import com.cn.zaplayer.di.module.IndexModule;
import com.cn.zaplayer.di.scope.UserScope;
import com.cn.zaplayer.ui.main.index.IndexFragment;

import dagger.Component;

@UserScope
@Component(modules = {IndexModule.class}, dependencies = {NetComponent.class})
public interface IndexComponent {
    void inject(IndexFragment fragment);
}
