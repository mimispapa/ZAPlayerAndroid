package com.cn.zaplayer.base;

public abstract class IMvpPresenter<V extends IMvpView> {
    private V view;
    public  V getView(){
        return this.view;
    }

    public IMvpPresenter(V view){
        this.view = view;
    }
}
