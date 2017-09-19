package com.example.zidingyiview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by KING on 2017/9/11 14:22
 * 邮箱:992767879@qq.com
 */

public class ViewZdingyi extends View {
    /**
     * 第一步：声明画笔
     */
    private Paint mPaint_X;//X坐标轴画笔
    private Paint mPaint_Y;//Y坐标轴画笔
    private Paint mPaint_InsideLine;//内部虚线P
    private Paint mPaint_Text;//字体画笔
    private Paint mPaint_Rec;//矩形画笔

    //数据
    private int[] data ;
    //视图的宽高
    private int width;
    private int height;


    //坐标轴数据
    private String[] mText_Y ;

    private String[] mText_X = new String[]{"0","1","2","3","4","5","6","7"};//默认X轴坐标

    public ViewZdingyi(Context context) {
        super(context);
        init(context,null);
    }

    public ViewZdingyi(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     * 更新XY轴坐标
     */
    public void upDateTextForX(String[] text_X)
    {
        mText_X = text_X;
        this.postInvalidate();  //更新视图
    }

    /**
     * 更新数据
     */
    public void upData(int [] data)
    {
        this.data = data;
        this.postInvalidate();  //更新视图
        mText_Y = getText_Y(data);
    }
    /**
     * 初始化画笔
     */
    private void init(Context context, AttributeSet attrs) {
        mPaint_X = new Paint();
        mPaint_InsideLine = new Paint();
        mPaint_Text = new Paint();
        mPaint_Rec = new Paint();
        mPaint_Y = new Paint();

        //设置横坐线标的颜色
        mPaint_X.setColor(Color.DKGRAY);
        //设置画笔的宽度
        mPaint_X.setStrokeWidth(3);
        //设置纵坐标线的颜色
        mPaint_Y.setColor(Color.GRAY);
        //设置虚线的颜色
        mPaint_InsideLine.setColor(Color.LTGRAY);
        //这是抗拒齿的意思，是线条的样式去（去除）
        mPaint_InsideLine.setAntiAlias(true);
        //这是自定义文字的大小
        mPaint_Text.setTextSize(25);
        //这是设置对齐的意思，文字与谁对齐
        mPaint_Text.setTextAlign(Paint.Align.CENTER);
        //这是设置我们所画的圆柱的颜色
        mPaint_Rec.setColor(Color.GRAY);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //这是获取这个控件的宽度
        width = getWidth();
        //这是获取这个控件的高度
        height = getHeight();
        //Y轴每个数据的间距
        int leftHeight_Every = (height-50)/4;
        //X轴每个数据的间距
        int downWeight_Every = (width-50)/mText_X.length;

        //画XY坐标轴，这个方法是画线的意思
        canvas.drawLine(0, height - 50, width, height - 50, mPaint_X);

        canvas.drawLine(50, height - 50, 50, 0, mPaint_Y);

        //画内部灰线
        for(int i= 1;i < 5;i++){
            canvas.drawLine(50, height - 50 - (i * leftHeight_Every), width - 50, height - 50 - (i * leftHeight_Every), mPaint_InsideLine);
        }
        //画X轴坐标
        for(int i =1;i<mText_X.length+1;i++){
            canvas.drawText(mText_X[i - 1], 50 + downWeight_Every * (i - 1), height - 20, mPaint_Text);
        }

        if(this.data != null && this.data.length >0){
            //画Y轴坐标
            for(int i =1;i<mText_Y.length+1;i++){
                canvas.drawText(mText_Y[i-1],50,leftHeight_Every*(i-1)+10,mPaint_Text);
            }
            //画矩形
            for(int i =1;i<data.length+1;i++){
                //Y轴首个数值，这是设置最大值的意思
                int data_Y_One = Integer.parseInt(mText_Y[3]);
                //这是相对于最大值所要在图 中占的比例
                double data_Yx = (double)data[i-1]/data_Y_One;
                //这是画圆弧的画笔画矩形？？？？？？？？？？？
                RectF rect = new RectF();
                //
                rect.left  = 50+ downWeight_Every * i  - 20;
                rect.right = 50+ downWeight_Every * i  + 20;
                rect.top = (height-50-(int)(data_Yx*leftHeight_Every));
                rect.bottom = height-50 ;
                canvas.drawRoundRect(rect, 5, 5,mPaint_Rec);
                canvas.drawText(data[i - 1] + "步", 50 + downWeight_Every * i, (height - 50 - (int) (data_Yx * leftHeight_Every)) - 15, mPaint_Text);
            }
        }
    }



    /**
     * 获取一组数据的最大值
     */
    public static int getMax(int[] arr) {
        int max = arr[0];
        for(int x=1;x<arr.length;x++)
        {
            if(arr[x]>max)
                max = arr[x];
        }
        return max;
    }

    /**
     * 功能：根据传入的数据动态的改变Y轴的坐标
     * 返回：取首数字的前两位并除以2，后面变成0。作为Y轴的基坐标
     */
    public static String[] getText_Y(int[] data){
        String[] text_Y;
        int textY = 0;
            //获取最大的数组数
        String numMax = getMax(data)+"";
        //把最大的数，字符串，转化成char数组
        char[] charArray = numMax.toCharArray();
        //获取这个数组里面的长度
        int dataLength = charArray.length;//数据长度 eg：5684：4位
        String twoNumString = "";
        if(dataLength >= 2){
            for (int i = 0; i < 2; i++) {
                twoNumString += charArray[i];
            }
            int twoNum =Integer.parseInt(twoNumString);
            //这句不懂
            textY = (int) Math.ceil(twoNum/3);
            //将数据前两位后加上“0” 用于返回前两位的整数
            if(dataLength - 2 == 1){
                textY *= 10;
            }else if(dataLength -2 == 2){
                textY *= 100;
            }else if(dataLength -2 == 3){
                textY *= 1000;
            }else if(dataLength -2 == 4){
                textY *= 10000;
            }else if(dataLength -2 == 5){
                textY *= 100000;
            }
            text_Y = new String[]{"", textY * 3 + "", textY * 2 + "", textY + ""};

        }else{
            text_Y = new String[]{"", 15+"",10+"",5+""};
        }
        return text_Y;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //1.获取specMode
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        //获取view的size
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.EXACTLY || widthSpecMode == MeasureSpec.AT_MOST) {
            width = widthSpecSize;
        } else {
            width = 0;
        }
        if (heightSpecMode == MeasureSpec.AT_MOST || heightSpecMode == MeasureSpec.UNSPECIFIED) {
            height = dipToPx(200);
        } else {
            height = heightSpecSize;
        }
        setMeasuredDimension(width, height);
    }

    private int dipToPx(int dip) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }
}