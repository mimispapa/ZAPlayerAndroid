package com.cn.zaplayer.di.module;

import androidx.fragment.app.Fragment;

import com.cn.zaplayer.ui.main.CollectFragment;
import com.cn.zaplayer.ui.main.IndexFragment;
import com.cn.zaplayer.ui.main.MeFragment;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    public List<String> provideNameList(){
        List<String> list = new ArrayList<>();
        list.add("首页");
        list.add("收藏");
        list.add("我");
        return list;
    }


    @Provides
    public List<Fragment> provideFragmentList(){
        List<Fragment> list = new ArrayList<>();
        list.add(new IndexFragment());
        list.add(new CollectFragment());
        list.add(new MeFragment());
        return list;
    }


}
