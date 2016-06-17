package com.example.xbp.customviews.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.xbp.customviews.util.FontDisplayUtil;

/**
 * Created by xbp on 2016/6/17.
 * 自定义的最简单的一个计数器
 */
public class CounterView extends View implements View.OnClickListener {

    private Paint mPaint;
    private int  mCount;
    private Rect mBounds;
    private Context mContext;


    public CounterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        mBounds=new Rect();
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);//绘制矩形
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextSize(FontDisplayUtil.px2dip(mContext,100));
        String text=String.valueOf(mCount);
        mPaint.getTextBounds(text,0,text.length(),mBounds);//获取text的矩阵并赋值
        float textWidth=mBounds.width();
        float textHeigh=mBounds.height();
        canvas.drawText(text,getWidth()/2-textWidth/2,getHeight()/2+textHeigh/2,mPaint);
    }

    @Override
    public void onClick(View v) {
        mCount++;
        //从新绘制view
        invalidate();



    }
}
