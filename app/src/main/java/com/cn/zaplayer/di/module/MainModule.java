package com.cn.zaplayer.di.module;


import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public  class MainModule{

    @Provides
    public List<String> provideNameList(){
        List<String> list = new ArrayList<>();
        list.add("首页");
        list.add("收藏");
        list.add("我");
        return list;
    }

}
