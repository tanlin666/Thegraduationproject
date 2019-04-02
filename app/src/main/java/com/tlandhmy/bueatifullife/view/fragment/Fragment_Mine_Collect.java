package com.tlandhmy.bueatifullife.view.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlandhmy.bueatifullife.R;
import com.tlandhmy.bueatifullife.view.activity.WonthepraiseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Mine_Collect extends Fragment {


    @BindView(R.id.recl_mine_collect)
    RecyclerView reclMineCollect;
    Unbinder unbinder;

    public Fragment_Mine_Collect() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__mine__collect, container, false);
        unbinder = ButterKnife.bind(this, view);
        reclMineCollect.setLayoutManager(new LinearLayoutManager(getActivity()));
        reclMineCollect.setAdapter(new MineCollectAdapter());
        //设置增加或删除条目的动画
        reclMineCollect.setItemAnimator(new DefaultItemAnimator());
        reclMineCollect.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class MineCollectAdapter extends RecyclerView.Adapter<MineCollectAdapter.MineCollectViewholder>{

        @NonNull
        @Override
        public MineCollectViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MineCollectViewholder(LayoutInflater.from(getActivity()).inflate(R.layout.minecollect_item,viewGroup,false));
        }

        @Override
        public void onBindViewHolder(@NonNull MineCollectViewholder mineCollectViewholder, int i) {

        }

        @Override
        public int getItemCount() {
            return 3;
        }

        private class MineCollectViewholder extends RecyclerView.ViewHolder{
            public MineCollectViewholder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
