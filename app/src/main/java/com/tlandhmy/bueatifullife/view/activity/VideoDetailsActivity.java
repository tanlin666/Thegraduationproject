package com.tlandhmy.bueatifullife.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlandhmy.bueatifullife.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoDetailsActivity extends AppCompatActivity {

    @BindView(R.id.videocomment_rv)
    RecyclerView videocommentRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_details);
        ButterKnife.bind(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//设置布局管理器
        videocommentRv.setLayoutManager(layoutManager);
//设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
//设置Adapter
        videocommentRv.setAdapter(new CommentAdapter());
//设置增加或删除条目的动画
        videocommentRv.setItemAnimator(new DefaultItemAnimator());
        videocommentRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewholder> {

        @NonNull
        @Override
        public CommentViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new CommentViewholder(LayoutInflater.from(VideoDetailsActivity.this).inflate(R.layout.video_comment_item, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull CommentViewholder commentViewholder, int i) { }

        @Override
        public int getItemCount() {
            return 10;
        }

        class CommentViewholder extends RecyclerView.ViewHolder {
            public CommentViewholder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }


}
