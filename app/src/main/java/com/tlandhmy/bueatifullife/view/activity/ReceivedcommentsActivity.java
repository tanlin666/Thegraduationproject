package com.tlandhmy.bueatifullife.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tlandhmy.bueatifullife.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReceivedcommentsActivity extends AppCompatActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.wonthepraise_rv)
    RecyclerView wonthepraiseRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //因为此布局和获赞和收藏相同，所以直接用的它的布局
        setContentView(R.layout.activity_wonthepraise);
        ButterKnife.bind(this);
        titleTv.setText("收到的评论和@");
        wonthepraiseRv.setLayoutManager(new LinearLayoutManager(this));
        wonthepraiseRv.setAdapter(new ReceivedCommentsAdapter());
        //设置增加或删除条目的动画
        wonthepraiseRv.setItemAnimator(new DefaultItemAnimator());
        wonthepraiseRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @OnClick(R.id.back_iv)
    public void onViewClicked() {
        finish();
    }

    public class ReceivedCommentsAdapter extends RecyclerView.Adapter<ReceivedCommentsAdapter.ReceivedCommentsViewholder>{

        @NonNull
        @Override
        public ReceivedCommentsViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            //因为此布局和获赞和收藏相同，所以直接用的它的子布局
            return new ReceivedCommentsViewholder(LayoutInflater.from(ReceivedcommentsActivity.this).inflate(R.layout.wonthepraise_item,viewGroup,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ReceivedCommentsViewholder receivedCommentsViewholder, int i) {
            receivedCommentsViewholder.commentsTv.setText("评论了您的内容，点击查看");
            if (i>5){
                receivedCommentsViewholder.commentsTv.setText("@了您，点击查看");
            }
        }

        @Override
        public int getItemCount() {
            return 11;
        }

        public class ReceivedCommentsViewholder extends RecyclerView.ViewHolder{
            @BindView(R.id.comments_tv)
            TextView commentsTv;
            public ReceivedCommentsViewholder(@NonNull View itemView) {
                super(itemView);
                ButterKnife.bind(this,itemView);
            }
        }
    }
}
