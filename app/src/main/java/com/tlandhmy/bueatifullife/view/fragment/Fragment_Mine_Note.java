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
public class Fragment_Mine_Note extends Fragment {


    @BindView(R.id.recl_note)
    RecyclerView reclNote;
    Unbinder unbinder;

    public Fragment_Mine_Note() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__mine__note, container, false);
        unbinder = ButterKnife.bind(this, view);
        reclNote.setLayoutManager(new LinearLayoutManager(getActivity()));
        reclNote.setAdapter(new MinenoteAdapter());
        //设置增加或删除条目的动画
        reclNote.setItemAnimator(new DefaultItemAnimator());
        reclNote.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class MinenoteAdapter extends RecyclerView.Adapter<MinenoteAdapter.MinenoteViewholder>{

        @NonNull
        @Override
        public MinenoteViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new MinenoteViewholder(LayoutInflater.from(getActivity()).inflate(R.layout.mine_note_item,viewGroup,false)) ;
        }

        @Override
        public void onBindViewHolder(@NonNull MinenoteViewholder minenoteViewholder, int i) {

        }

        @Override
        public int getItemCount() {
            return 2;
        }

        private class MinenoteViewholder extends RecyclerView.ViewHolder{
            public MinenoteViewholder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
