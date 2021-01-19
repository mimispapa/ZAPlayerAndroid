package com.cn.zaplayer.di.module;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.cn.zaplayer.di.scope.UserScope;
import com.cn.zaplayer.ui.main.CollectFragment;
import com.cn.zaplayer.ui.main.MainPresenter;
import com.cn.zaplayer.ui.main.index.IndexFragment;
import com.cn.zaplayer.ui.main.MeFragment;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private MainPresenter.View mView;
    private FragmentActivity mActivity;

    public MainModule(MainPresenter.View mView, FragmentActivity activity) {
        this.mView = mView;
        this.mActivity = activity;
    }

    @Provides
    public FragmentActivity provideFragmentActivity(){
        return this.mActivity;
    }

    @Provides
    public MainPresenter.View provideView(){
        return this.mView;
    }

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
