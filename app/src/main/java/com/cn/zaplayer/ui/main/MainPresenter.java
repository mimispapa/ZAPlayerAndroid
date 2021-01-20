package com.cn.zaplayer.ui.main;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cn.zaplayer.R;
import com.cn.zaplayer.base.IMvpPresenter;
import com.cn.zaplayer.base.IMvpView;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter extends IMvpPresenter<MainPresenter.View> {
    private FragmentActivity mFragmentActivity;
    private List<Fragment> mFragmentList;
    private Fragment currentFragment;

//    @Inject
    public MainPresenter(View view) {
        super(view);
    }


    public void init() {
        switchFragment(0);
    }

    public void switchFragment(int index){
        FragmentManager supportFragmentManager = mFragmentActivity.getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        Fragment newFragment = mFragmentList.get(index);

        if (newFragment.isAdded()) {
            if (currentFragment == null) {
                transaction.show(newFragment);
            } else {
                transaction.hide(currentFragment)
                        .show(currentFragment);
            }
        } else {
            if (currentFragment == null) {
                transaction.add(R.id.root_container, newFragment);
            } else {
                transaction.hide(currentFragment)
                        .add(R.id.root_container, newFragment);
            }
        }

        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
        currentFragment = newFragment;

        getView().onChangeTab(index);
    }

    public interface View extends IMvpView {
        void onChangeTab(int index);
    }
}
