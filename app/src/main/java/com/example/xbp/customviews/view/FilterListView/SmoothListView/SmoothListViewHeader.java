package com.example.xbp.customviews.view.FilterListView.SmoothListView;

import android.content.Context;
import android.media.tv.TvContract;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.xbp.customviews.R;

/**
 * Created by xbp on 2016/6/20.
 */
public class SmoothListViewHeader extends LinearLayout {
    private LinearLayout mContainer;
    private ImageView mArrowImageView;
    private ProgressBar mProgressBar;
    private TextView mHintTextView;

    private int mState=START_NORMAL;



    private Animation mRotateUpAnim;
    private Animation mRotateDownAnim;

    private final int ROTATE_ANIM_DURATION=180;

    public final static int START_NORMAL=0;
    public final static int START_READY=1;
    public final static int START_REFRESHING=2;



    public SmoothListViewHeader(Context context) {
        super(context);
        initView(context);
    }

    public SmoothListViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        //初始情况，设置下拉刷新view的高度为0;
        LayoutParams lp=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
        mContainer= (LinearLayout) LayoutInflater.from(context).inflate(R.layout.smoothlistview_header,null);
        addView(mContainer,lp);
        setGravity(Gravity.BOTTOM);
        mArrowImageView= (ImageView) findViewById(R.id.smoothlistview_header_arrow);
        mHintTextView= (TextView) findViewById(R.id.smoothlistview_header_hint_textview);
        mProgressBar= (ProgressBar) findViewById(R.id.smoothlistview_header_progressbar);

        mRotateUpAnim=new RotateAnimation(0.0f,-180.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim=new RotateAnimation(-180.0f,0.0f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
    }

    public void setState(int state){
        if (state==mState)return;

        if (state==START_REFRESHING){
            //显示进度
            mArrowImageView.clearAnimation();
            mArrowImageView.setVisibility(View.INVISIBLE);
            mProgressBar.setVisibility(View.VISIBLE);
        }else {
            mArrowImageView.setVisibility(VISIBLE);
            mProgressBar.setVisibility(INVISIBLE);
        }

        switch (state){
            case START_NORMAL:
                if(mState==START_READY){
                    mArrowImageView.startAnimation(mRotateDownAnim);
                }
                if (mState==START_REFRESHING){
                    mArrowImageView.clearAnimation();
                }
                mHintTextView.setText(R.string.smoothlistview_footer_hint_normal);
                break;
            case START_READY:
                if (mState!=START_READY){
                    mArrowImageView.clearAnimation();
                    mArrowImageView.startAnimation(mRotateUpAnim);
                    mHintTextView.setText(R.string.smoothlistview_footer_hint_ready);
                }
                break;
            case START_REFRESHING:
                mHintTextView.setText(R.string.smoothlistview_header_hint_loading);
                break;
                default:
        }
        mState=state;
    }

    public void setViesiableHeight(int height){
        if(height<0)
            height=0;
        LayoutParams lp= (LayoutParams) mContainer.getLayoutParams();
        lp.height=height;
        mContainer.setLayoutParams(lp);
    }

    public int getVisiableHeight(){
        return mContainer.getHeight();
    }
}
