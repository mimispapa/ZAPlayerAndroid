package com.cn.zaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.cn.zaplayer.di.component.DaggerMainComponent;
import com.cn.zaplayer.di.module.MainModule;
import com.cn.zaplayer.network.RetrofitUtil;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    RetrofitUtil retrofitUtil;

    @Inject
    List<String> nameList;

    @Inject
    List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent
                .builder()
                .netComponent(ZaApplication.getApplication().getNetComponent())
                .mainModule(new MainModule())
                .build()
                .inject(this);


    }
}