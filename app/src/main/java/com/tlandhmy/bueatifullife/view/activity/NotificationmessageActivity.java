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

public class NotificationmessageActivity extends AppCompatActivity {

    @BindView(R.id.title_tv)
    TextView titleTv;
    @BindView(R.id.wonthepraise_rv)
    RecyclerView wonthepraiseRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //因为此布局和获赞和收藏相同，所以直接用的它的子布局
        setContentView(R.layout.activity_wonthepraise);
        ButterKnife.bind(this);
        titleTv.setText("系统通知");
        wonthepraiseRv.setLayoutManager(new LinearLayoutManager(this));
        wonthepraiseRv.setAdapter(new NotificationAdapter());
        //设置增加或删除条目的动画
        wonthepraiseRv.setItemAnimator(new DefaultItemAnimator());
        wonthepraiseRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @OnClick(R.id.back_iv)
    public void onViewClicked() {
        finish();
    }

    public class  NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewholder>{
        @NonNull
        @Override
        public NotificationViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new NotificationViewholder(LayoutInflater.from(NotificationmessageActivity.this).inflate(R.layout.notificationmessage_item,viewGroup,false)) ;
        }

        @Override
        public void onBindViewHolder(@NonNull NotificationViewholder notificationViewholder, int i) {

        }

        @Override
        public int getItemCount() {
            return 2;
        }

        private class NotificationViewholder extends RecyclerView.ViewHolder{
           public NotificationViewholder(@NonNull View itemView) {
               super(itemView);
           }
       }
    }
}
