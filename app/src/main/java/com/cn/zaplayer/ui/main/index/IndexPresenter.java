package com.cn.zaplayer.ui.main.index;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import com.cn.zaplayer.entity.VideoListBean;
import com.cn.zaplayer.network.RetrofitUtil;
import com.cn.zaplayer.util.RequestUtil;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class IndexPresenter {
    private View mView;
    private RetrofitUtil mRetrofitUtil;
    private Context mContext;

//    @Inject
    public IndexPresenter(View view, RetrofitUtil retrofitUtil, Context context) {
        mView = view;
        mRetrofitUtil = retrofitUtil;
        mContext = context;
    }


    @SuppressLint("CheckResult")
    public void loadRemote(){
        Map<String, Object> params = RequestUtil.videoListParams();
        params.put("pg", 1);

        mRetrofitUtil.createApi("https://www.mhapi123.com/inc/api.php/")
                .request("",params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(string -> {
                    VideoListBean videoListBean = RequestUtil.parseToJson(string, VideoListBean.class);

                    Iterator<VideoListBean.Video> iterator = videoListBean.getListBean().getVideos().iterator();
                    while (iterator.hasNext()){
                        VideoListBean.Video bean = iterator.next();
                        Log.e("TAG", "video:" + bean.getLast() + "---" + bean.getPic());
                    }

                    mView.onGetData(videoListBean);

                }, throwable -> {
                    Log.e("TAG", "error:" + throwable.getLocalizedMessage());

                });

    }

    public interface View {
        void onGetData(VideoListBean videoListBean);
    }
}
