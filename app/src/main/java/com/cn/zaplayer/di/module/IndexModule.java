package com.cn.zaplayer.di.module;

import android.content.Context;

import com.cn.zaplayer.di.scope.UserScope;
import com.cn.zaplayer.ui.main.index.IndexPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class IndexModule {
    private IndexPresenter.View view;
    private Context context;

    public IndexModule(IndexPresenter.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }

    @Provides
    public IndexPresenter.View provideView(){
        return this.view;
    }
}
