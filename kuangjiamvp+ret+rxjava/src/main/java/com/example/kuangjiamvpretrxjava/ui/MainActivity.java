package com.example.kuangjiamvpretrxjava.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.kuangjiamvpretrxjava.Bean.ShiLei;
import com.example.kuangjiamvpretrxjava.R;
import com.example.kuangjiamvpretrxjava.prestener.CeShi;
import com.example.kuangjiamvpretrxjava.prestener.Kongzhiqi;
import com.example.kuangjiamvpretrxjava.prestener.UiPerson;
import com.example.kuangjiamvpretrxjava.view.ViewI;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ViewI{
    @Inject
    UiPerson uiPerson;
    @Inject
    CeShi ceShi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerUiComponent.builder()
                .kongzhiqi(new Kongzhiqi(this))
                .build()
                .inject(this);

//        Kongzhiqi kongzhiqi = new Kongzhiqi(this);
//        kongzhiqi.ss(this);
        uiPerson.ss(this);
        intd();
        String a = ceShi.a();
        Log.e("TAG",a);
    }

    private void intd() {
//        Observable.just("images/logo.png") // 输入类型 String
//                .map(new Func1<String, Bitmap>() {
//                    @Override
//                    public Bitmap call(String filePath) { // 参数类型 String
//                        return getBitmapFromPath(filePath); // 返回类型 Bitmap
//                    }
//                })
//                .subscribe(new Action1<Bitmap>() {
//                    @Override
//                    public void call(Bitmap bitmap) { // 参数类型 Bitmap
//                        showBitmap(bitmap);
//                    }
//                });
//                .create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//
//                subscriber.onNext("a");
//            }
//        })

//一下是实现先加载后实现展示图片
//        Observable.create(new OnSubscribe<Drawable>() {
//            @Override
//            public void call(Subscriber<? super Drawable> subscriber) {
//                Drawable drawable = getTheme().getDrawable(drawableRes));
//                subscriber.onNext(drawable);
//                subscriber.onCompleted();
//            }
//        }).subscribe(new Observer<Drawable>() {
//            @Override
//            public void onNext(Drawable drawable) {
//                imageView.setImageDrawable(drawable);
//            }
//
//            @Override
//            public void onCompleted() {
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public void aaa(ShiLei shiLei) {
        Toast.makeText(this, shiLei.getData().getBigImg().get(1).getTitle(), Toast.LENGTH_SHORT).show();
    }
}
