package com.jiyun.qcloud.newkuangjia.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

import com.jiyun.qcloud.newkuangjia.MainApp;
import com.jiyun.qcloud.newkuangjia.mvp.IView;
import com.jiyun.qcloud.newkuangjia.mvp.Presenter;
import com.jiyun.qcloud.newkuangjia.mvp.model.BaseCard;
import com.jiyun.qcloud.newkuangjia.mvp.model.Card;
import com.jiyun.qcloud.newkuangjia.mvp.model.Ceshi;
import com.jiyun.qcloud.newkuangjia.mvp.model.Dieerlei;
import com.jiyun.qcloud.newkuangjia.mvp.model.Info;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

/**

        */
public class BaseFragment extends Fragment implements IView {

    public static final String MENU_KEY = "MENU_KEY";
    public static final String ARGU_KEY = "ARGU_KEY";
    public static final int KEY_CLASSES = 0;
    public static final int KEY_SETS = 1;
    public static final int KEY_TYPES = 2;
    public static final int KEY_FACTIONS = 3;
    public static final int KEY_QUALITIES = 4;
    public static final int KEY_RACES = 5;
    protected int menuType = KEY_CLASSES;
    protected String argu;


    @Inject
    protected Presenter mPresenter;
    @Inject
    protected Picasso picasso;
    protected RecyclerView mMainRecycler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainApp) getActivity().getApplication()).getmAppComponent().inject(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            menuType = arguments.getInt(MENU_KEY);
            argu = arguments.getString(ARGU_KEY);

        }
        mPresenter.setmView(this);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onUpdate(BaseCard card) {

    }

    @Override
    public void onUpdate(List<Card> card) {

    }

    @Override
    public void onUpData(Info info) {

    }

    @Override
    public void onUpData1(Ceshi info) {

    }

    @Override
    public void onDierci(Dieerlei dieerlei) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
