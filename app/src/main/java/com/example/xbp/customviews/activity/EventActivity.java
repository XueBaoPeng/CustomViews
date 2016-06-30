package com.example.xbp.customviews.activity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.xbp.customviews.R;


import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xbp on 2016/6/23.
 */
public class EventActivity extends BaseActivity {

    @Bind(R.id.button)
    Button button;
    @Bind(R.id.imageView)
    ImageView mImageView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ButterKnife.bind(this);
        initButton();
        initImageView();
    }

    private void initImageView() {
        mImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("ImageView ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("ImageView ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("ImageView ACTION_UP");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    //因为ImageView默认是不可点击的,所以如果屏蔽掉以下的代码,则只有
        //ImageView的ACTION_DOWN没有ACTION_MOVE和ACTION_UP
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("ImageView Clicked");
            }
        });
    }

    private void initButton() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clicked");
            }
        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("Button Action_Down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("Button Action_Move");
                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("Button Action_UP");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

}
