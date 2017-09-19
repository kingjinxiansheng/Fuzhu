package com.jiyun.qcloud.newkuangjia;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.jiyun.qcloud.newkuangjia.mvp.model.Ceshi;
import com.jiyun.qcloud.newkuangjia.mvp.model.Dieerlei;
import com.jiyun.qcloud.newkuangjia.mvp.model.Info;
import com.jiyun.qcloud.newkuangjia.ui.activitys.BaseActivity;
import com.jiyun.qcloud.newkuangjia.ui.fragments.ListFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity{


//    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
//        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mViewPager);

        mPresenter.getInfo();
        mPresenter.getInfo2();
    }

    @Override
    public void onUpData1(Ceshi info) {
        super.onUpData1(info);
        String t = info.getVideo().get(0).getT();
        Log.e("TAG---------",t);
    }

    @Override
    public void onDierci(Dieerlei dieerlei) {
        super.onDierci(dieerlei);
        String title = dieerlei.getInteractive().get(0).getTitle();
        Log.e("TAG22---------",title);
    }
    //    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//        ArrayList<ListFragment> list = new ArrayList<>(6);
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//            for (int i = 0; i < 6; i++) {
//                int type = ListFragment.KEY_CLASSES;
//                switch (i) {
//                    case 0:
//                        type = ListFragment.KEY_CLASSES;
//                        break;
//                    case 1:
//                        type = ListFragment.KEY_SETS;
//                        break;
//                    case 2:
//                        type = ListFragment.KEY_TYPES;
//                        break;
//                    case 3:
//                        type = ListFragment.KEY_FACTIONS;
//                        break;
//                    case 4:
//                        type = ListFragment.KEY_QUALITIES;
//                        break;
//                    case 5:
//                        type = ListFragment.KEY_RACES;
//                        break;
//                }
//                ListFragment fragment = new ListFragment();
//                Bundle data = new Bundle();
//                data.putInt(ListFragment.MENU_KEY, type);
//                fragment.setArguments(data);
//                list.add(fragment);
//            }
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return list.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return 6;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "AAAAAAAAA";
//            }
//            return null;
//        }
//
//        public void onUpdate(Info info) {
//            for (int i = 0; i < 6; i++) {
//                ListFragment f = list.get(i);
//                switch (i) {
//                    case 0:
//                        f.setData(info.classes);
//                        break;
//                    case 1:
//                        f.setData(info.sets);
//                        break;
//                    case 2:
//                        f.setData(info.types);
//                        break;
//                    case 3:
//                        f.setData(info.factions);
//                        break;
//                    case 4:
//                        f.setData(info.qualities);
//                        break;
//                    case 5:
//                        f.setData(info.races);
//                        break;
//                }
//            }
//        }
//    }

    @Override
    public void onUpData(Info info) {
        super.onUpData(info);
//        mSectionsPagerAdapter.onUpdate(info);
    }

    ///////////////////////////



}
