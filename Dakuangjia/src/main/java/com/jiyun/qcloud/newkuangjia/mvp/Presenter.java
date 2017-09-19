package com.jiyun.qcloud.newkuangjia.mvp;

import android.util.Log;

import com.jiyun.qcloud.newkuangjia.api.IApi;
import com.jiyun.qcloud.newkuangjia.api.IApii;
import com.jiyun.qcloud.newkuangjia.mvp.model.Card;
import com.jiyun.qcloud.newkuangjia.mvp.model.Ceshi;
import com.jiyun.qcloud.newkuangjia.mvp.model.Dieerlei;
import com.jiyun.qcloud.newkuangjia.mvp.model.Info;
import com.jiyun.qcloud.newkuangjia.util.Util;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chj on 2017/8/30.
 */

public class Presenter {
    private IView mView;
    private static Info mInfo;
    private static Ceshi ceshi1;
    private static Dieerlei dieerlei1;
    @Inject
    IApi mIApi;
    @Inject
    IApii mIApii;

    @Inject
    public Presenter(){

    }


    public void setmView(IView mView){
        this.mView=mView;
    }

    public void getInfo(){
        if (ceshi1 == null) {
            mView.showProgress();
            Observable<Ceshi> observable = mIApi.getCeshi();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SelfDefineSubscriber<Ceshi>() {
                        @Override
                        public void onNext(Ceshi ceshi) {
                            Log.e("TTTTT","wwwwwwwww");
                            ceshi1 = ceshi;
                            mView.onUpData1(ceshi1);
//                            mView.hideProgress();
                        }
                    });
        }else{
//            mView.hideProgress();
            mView.onUpData1(ceshi1);
        }
    }
    public void getInfo2(){
        if (ceshi1 == null) {
            mView.showProgress();
            Observable<Dieerlei> observable = mIApii.getDierci();
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SelfDefineSubscriber<Dieerlei>() {
                        @Override
                        public void onNext(Dieerlei dieerlei) {
                            Log.e("TTTTT","wwwwwwwww");
                            dieerlei1 = dieerlei;
                            mView.onDierci(dieerlei1);
//                            mView.hideProgress();
                        }
                    });
        }else{
//            mView.hideProgress();
            mView.onDierci(dieerlei1);
        }
    }
/////////////////////////////////////这里是重复的代码
public void getCardSet(String set) {
    mView.showProgress();

    Observable<List<Card>> observable = mIApi.getCardSet(set, getLocal());
    observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new SelfDefineSubscriber<List<Card>>() {
                @Override
                public void onNext(List<Card> cards) {
                    mView.onUpdate(cards);
                    mView.hideProgress();

                }
            });
}

    public void getCardByClass(String classes) {
        mView.showProgress();

        Observable<List<Card>> observable = mIApi.getCardsByClass(classes, getLocal());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {
                        mView.onUpdate(cards);
                        mView.hideProgress();

                    }
                });
    }

    public void getCardByFaction(String faction) {
        mView.showProgress();

        Observable<List<Card>> observable = mIApi.getCardByFaction(faction, getLocal());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {
                        mView.onUpdate(cards);
                        mView.hideProgress();

                    }
                });
    }

    public void getCardByQuality(String quality) {
        mView.showProgress();

        Observable<List<Card>> observable = mIApi.getCardByQuality(quality, getLocal());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {
                        mView.onUpdate(cards);
                        mView.hideProgress();

                    }
                });
    }

    public void getCardByRace(String Race) {
        mView.showProgress();

        Observable<List<Card>> observable = mIApi.getCardByRace(Race, getLocal());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {
                        mView.onUpdate(cards);
                        mView.hideProgress();

                    }
                });
    }

    public void getCardByType(String type) {
        mView.showProgress();

        Observable<List<Card>> observable = mIApi.getCardByType(type, getLocal());
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SelfDefineSubscriber<List<Card>>() {
                    @Override
                    public void onNext(List<Card> cards) {
                        mView.onUpdate(cards);
                        mView.hideProgress();

                    }
                });
    }

    //系统语言信息获取
    private String getLocal() {
        if (mInfo != null && mInfo.locales != null) {
            String local = Util.getCurrentLauguage();
            for (String s : mInfo.locales) {
                if (s.contains(local)) {
                    return s;
                }
            }
        }

        return "enUS";
    }



    //自定义的subscribe
    class SelfDefineSubscriber<T> extends Subscriber<T>{

        @Override
        public void onCompleted() {
            mView.onComplete();
        }

        @Override
        public void onError(Throwable e) {
            System.out.println("出现错误"+e);
            mView.onError(e.getMessage());

       }

        @Override
        public void onNext(T t) {
            Log.e("TTTTT","wwwwwwwww");
        }
    }
}
