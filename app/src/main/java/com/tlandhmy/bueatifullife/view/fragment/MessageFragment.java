package com.tlandhmy.bueatifullife.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlandhmy.bueatifullife.R;
import com.tlandhmy.bueatifullife.view.activity.NewfucosActivity;
import com.tlandhmy.bueatifullife.view.activity.NotificationmessageActivity;
import com.tlandhmy.bueatifullife.view.activity.ReceivedcommentsActivity;
import com.tlandhmy.bueatifullife.view.activity.WonthepraiseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {


    Unbinder unbinder;

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.wonthepraise_tv, R.id.receivedcom_tv,R.id.ll_newfucos,R.id.ll_notification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wonthepraise_tv:
                Intent intent=new Intent(getActivity(), WonthepraiseActivity.class);
                startActivity(intent);
                break;
            case R.id.receivedcom_tv:
                Intent intent1=new Intent(getActivity(), ReceivedcommentsActivity.class);
                startActivity(intent1);
                break;
            case R.id.ll_newfucos:
                Intent intent2=new Intent(getActivity(), NewfucosActivity.class);
                startActivity(intent2);
                break;
            case R.id.ll_notification:
                Intent intent3=new Intent(getActivity(), NotificationmessageActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
