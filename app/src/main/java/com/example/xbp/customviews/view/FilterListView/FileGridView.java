package com.example.xbp.customviews.view.FilterListView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by xbp on 2016/6/21.
 * 不可滑动的gridView
 */
public class FileGridView extends GridView {
    public FileGridView(Context context) {
        super(context);
    }

    public FileGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FileGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
