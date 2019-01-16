package com.tlandhmy.bueatifullife.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.tlandhmy.bueatifullife.R;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements XRecyclerView.LoadingListener {

    @BindView(R.id.home_rv)
    XRecyclerView homeRv;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //FragmentHomeBinding fragmentHomeBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        homeRv.setLayoutManager(staggeredGridLayoutManager);
        homeRv.setRefreshProgressStyle(ProgressStyle.BallClipRotate); //设置下拉刷新的样式
        homeRv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate); //设置上拉加载更多的样式
        homeRv.setLoadingListener(this);
        homeRv.setAdapter(new HomeFgAdapter());
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.home_sv)
    public void onViewClicked() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }


    public class HomeFgAdapter extends RecyclerView.Adapter<HomeFgAdapter.HomeFgAdapter_ViewHolder> {


        @NonNull
        @Override
        public HomeFgAdapter_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new HomeFgAdapter_ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home_item,viewGroup,false));
        }

        @Override
        public void onBindViewHolder(@NonNull HomeFgAdapter_ViewHolder viewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class HomeFgAdapter_ViewHolder extends RecyclerView.ViewHolder {

            public HomeFgAdapter_ViewHolder(@NonNull View itemView) {
                super(itemView);

            }
        }

    }


}
