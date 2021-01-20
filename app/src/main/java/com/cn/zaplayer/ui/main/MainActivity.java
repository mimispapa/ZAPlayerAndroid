package com.cn.zaplayer.ui.main;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.cn.zaplayer.R;
import com.cn.zaplayer.ZaApplication;
import com.cn.zaplayer.di.module.MainModule;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {
    @Inject
    List<String> nameList;

    MainPresenter presenter;


    private TextView tabTV1,tabTV2, tabTV3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDagger();

        initViews();
        initListeners();
    }

    private void initDagger() {
//        ZaApplication.getApplication()
//                .getApplicationComponent()
//                .provideActivityComponent(new MainModule(this))
//                .inject(this);
        ZaApplication.getApplication()
                .getApplicationComponent()
                .getCommonActivityComponent()
                .getMainComponent(new MainModule())
                .inject(this);

    }


    private void initViews(){
        tabTV1 = findViewById(R.id.tab_tv1);
        tabTV2 = findViewById(R.id.tab_tv2);
        tabTV3 = findViewById(R.id.tab_tv3);

        tabTV1.setText(nameList.get(0));
        tabTV2.setText(nameList.get(1));
        tabTV3.setText(nameList.get(2));

//        presenter.init();
    }

    private void initListeners() {
        tabTV1.setOnClickListener(v -> {
            presenter.switchFragment(0);
        });

        tabTV2.setOnClickListener(v -> {
            presenter.switchFragment(1);
        });

        tabTV3.setOnClickListener(v -> {
            presenter.switchFragment(2);

        });
    }

    @Override
    public void onChangeTab(int index) {
        if (index == 0){
            tabTV1.setTextColor(Color.parseColor("#3a7ba3"));
            tabTV2.setTextColor(Color.parseColor("#70788c"));
            tabTV3.setTextColor(Color.parseColor("#70788c"));

            textFold(tabTV1, true);
            textFold(tabTV2, false);
            textFold(tabTV3, false);
        }else  if (index == 1){
            tabTV1.setTextColor(Color.parseColor("#70788c"));
            tabTV2.setTextColor(Color.parseColor("#3a7ba3"));
            tabTV3.setTextColor(Color.parseColor("#70788c"));
            textFold(tabTV1, false);
            textFold(tabTV2, true);
            textFold(tabTV3, false);
        }else  if (index == 2){
            tabTV1.setTextColor(Color.parseColor("#70788c"));
            tabTV2.setTextColor(Color.parseColor("#70788c"));
            tabTV3.setTextColor(Color.parseColor("#3a7ba3"));
            textFold(tabTV1, false);
            textFold(tabTV2, false);
            textFold(tabTV3, true);
        }

    }

    private void textFold(TextView textView, boolean bold){
        textView.getPaint().setFakeBoldText(bold);
    }

    @Override
    public Context getContext() {
        return this;
    }
}