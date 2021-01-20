package com.cn.zaplayer.ui.main.index;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cn.zaplayer.R;
import com.cn.zaplayer.ZaApplication;
import com.cn.zaplayer.base.BaseFragment;
import com.cn.zaplayer.entity.VideoListBean;

import javax.inject.Inject;

public class IndexFragment extends BaseFragment implements IndexPresenter.View {
    private RecyclerView recyclerView;


    IndexPresenter presenter;

    @Override
    public int getLayout() {
        return R.layout.fragment_index;
    }

    @Override
    public void initDagger() {
        super.initDagger();
//        DaggerIndexComponent.builder()
//                .netComponent(ZaApplication.getApplication().getNetComponent())
//                .indexModule(new IndexModule(this, getContext()))
//                .build()
//                .inject(this);
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        recyclerView = rootView.findViewById(R.id.rv_data_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    @Override
    public void initData() {
        super.initData();
        presenter.loadRemote();
    }

    @Override
    public void onGetData(VideoListBean videoListBean) {

    }
}
