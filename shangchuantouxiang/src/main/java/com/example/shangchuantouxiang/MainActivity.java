package com.example.shangchuantouxiang;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int PHOTO_REQUEST_GALLERY = 2;
    private static final int PHOTO_REQUEST_CUT = 3;
    private Button xuanze;
    private Button shangchuang;
    private ImageView iv;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        xuanze = (Button) findViewById(R.id.xuanze);
        shangchuang = (Button) findViewById(R.id.shangchuang);

        xuanze.setOnClickListener(this);
        shangchuang.setOnClickListener(this);
        iv = (ImageView) findViewById(R.id.iv);
        iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.xuanze:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
                startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
                break;
            case R.id.shangchuang:
                if (!file.getName().equals("")) {
                    SCpicture();
                }
                break;
        }
    }

    //从图库返回时的回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                crop(uri);
            }
        } else if (requestCode == PHOTO_REQUEST_CUT) {
            if (data != null) {
                //获取到裁剪之后的照片
                Bitmap bitmap = data.getParcelableExtra("data");
                iv.setImageBitmap(bitmap);

                //将裁剪之后的照片保存到本地并获取到他的地址
                file = saveBitmapFile(bitmap);
            }
        }
    }

    //调用系统的裁剪方法对从图库获取到的图片进行裁剪
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    //将获取到的bitmap类型的图片装换成file
    public File saveBitmapFile(Bitmap bitmap) {
        File file = new File("/sdcard/wxl.jpg");//将要保存图片的路径
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private void SCpicture() {


        OkHttpClient mOkHttpClient = new OkHttpClient.Builder().build();

        MultipartBody.Builder mbody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        mbody.addFormDataPart("image", file.getName(), RequestBody.create(null, file));
        RequestBody requestBody = mbody.build();

        Request request = new Request.Builder()
                .url("http://123.206.14.104:8080/FileUploadDemo/FileUploadServlet")
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                Entity shangchuang = gson.fromJson(string, Entity.class);
                final Entity2 shangchuang2 = gson.fromJson(shangchuang.getData(), Entity2.class);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, shangchuang2.getResult(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
