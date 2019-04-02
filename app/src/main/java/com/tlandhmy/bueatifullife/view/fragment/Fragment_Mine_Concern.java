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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Mine_Concern extends Fragment {


    @BindView(R.id.recl_concern)
    RecyclerView reclConcern;
    Unbinder unbinder;

    public Fragment_Mine_Concern() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__mine__concern, container, false);
        unbinder = ButterKnife.bind(this, view);
        reclConcern.setLayoutManager(new LinearLayoutManager(getActivity()));
        reclConcern.setAdapter(new MineConcernAdapter());
        //设置增加或删除条目的动画
        reclConcern.setItemAnimator(new DefaultItemAnimator());
        reclConcern.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class MineConcernAdapter extends RecyclerView.Adapter<MineConcernAdapter.MineConcernViewholder> {

        @NonNull
        @Override
        public MineConcernViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MineConcernViewholder(LayoutInflater.from(getActivity()).inflate(R.layout.mine_concern_item, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MineConcernViewholder mineConcernViewholder, int i) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }

        private class MineConcernViewholder extends RecyclerView.ViewHolder {
            public MineConcernViewholder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
