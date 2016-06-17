package com.example.xbp.customviews.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.xbp.customviews.R;

/**
 * Created by xbp on 2016/6/17.
 *带有删除功能的listview
 * 这里在DeleteListView的构造方法中创建了一个GestureDetector的实例用于监听手势，然后给MyListView注册了touch监听事件。
 * 然后在onTouch()方法中进行判断，如果删除按钮已经显示了，就将它移除掉，如果删除按钮没有显示，就使用GestureDetector来处理当前手势。
 当手指按下时，会调用OnGestureListener的onDown()方法，在这里通过pointToPosition()方法来判断出当前选中的是ListView的哪一行。当手指快速滑动时，
 会调用onFling()方法，在这里会去加载delete_button.xml这个布局，然后将删除按钮添加到当前选中的那一行item上。
 注意，我们还给删除按钮添加了一个点击事件，当点击了删除按钮时就会回调onDeleteListener的onDelete()方法，在回调方法中应该去处理具体的删除操作。
 */
public class DeleteListView extends ListView implements View.OnTouchListener,GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;//手势监听类
    private OnDeleteListener listener;
    private View deleteButton;//删除的按钮
    private ViewGroup itemLayout;
    private int selectedItem;
    private boolean isDeleteShown;

    public DeleteListView(Context context) {
        this(context,null);
    }

    public DeleteListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DeleteListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        gestureDetector=new GestureDetector(getContext(),this);
        setOnTouchListener(this);
    }


    public void setOnDeleteListener(OnDeleteListener l){
        listener=l;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        if(!isDeleteShown){
            selectedItem=pointToPosition((int)e.getX(),(int)e.getY());
        }
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if(!isDeleteShown&&Math.abs(distanceX)>Math.abs(distanceY)){
            deleteButton= LayoutInflater.from(getContext()).inflate(R.layout.delete_button,null);
            deleteButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemLayout.removeView(deleteButton);
                    deleteButton=null;
                    isDeleteShown=false;
                    listener.onDelete(selectedItem);
                }
            });

            itemLayout= (ViewGroup) getChildAt(selectedItem-getFirstVisiblePosition());
            RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            itemLayout.addView(deleteButton,params);
            isDeleteShown=true;
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    //触摸监听
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(isDeleteShown){
            itemLayout.removeView(deleteButton);
            deleteButton=null;
            isDeleteShown=false;
            return false;
        }else {
            //将触摸事件交给手势监听处理
            return gestureDetector.onTouchEvent(event);
        }
    }

    public interface OnDeleteListener{
        void onDelete(int index);
    }

}
