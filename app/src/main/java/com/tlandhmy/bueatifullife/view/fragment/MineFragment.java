package com.tlandhmy.bueatifullife.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlandhmy.bueatifullife.R;
import com.tlandhmy.bueatifullife.view.activity.LoginActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;

    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        unbinder = ButterKnife.bind(this, view);
        ArrayList<String> titleDatas = new ArrayList<>();
        titleDatas.add("笔记");
        titleDatas.add("收藏");
        titleDatas.add("关注");

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_Mine_Note());
        fragmentList.add(new Fragment_Mine_Collect());
        fragmentList.add(new Fragment_Mine_Concern());
        MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter(getChildFragmentManager(), titleDatas, fragmentList);
        viewpager.setAdapter(myViewPageAdapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabsFromPagerAdapter(myViewPageAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.touxiang)
    public void onViewClicked() {
        Intent intent=new Intent(getActivity(),LoginActivity.class);
        startActivity(intent);
    }

    public class MyViewPageAdapter extends FragmentPagerAdapter {
        private ArrayList<String> titleList;
        private ArrayList<Fragment> fragmentList;

        MyViewPageAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment> fragmentList) {
            super(fm);
            this.titleList = titleList;
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }

    }
}
