package com.cn.zaplayer.ui.main;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cn.zaplayer.R;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter {
    private View mView;
    private FragmentActivity mFragmentActivity;
    private List<Fragment> mFragmentList;
    private Fragment currentFragment;

    @Inject
    public MainPresenter(View mView, FragmentActivity mFragmentActivity, List<Fragment> fragmentList) {
        this.mView = mView;
        this.mFragmentActivity = mFragmentActivity;
        this.mFragmentList = fragmentList;
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

        mView.onChangeTab(index);
    }

    public interface View {
        void onChangeTab(int index);
    }
}
