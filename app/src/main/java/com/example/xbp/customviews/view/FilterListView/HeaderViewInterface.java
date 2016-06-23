package com.example.xbp.customviews.view.FilterListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.ListView;

import java.util.List;

/**
 * Created by xbp on 2016/6/21.
 */
public abstract class HeaderViewInterface<T> {
    protected Activity mContext;
    protected LayoutInflater mInflate;
    protected T mEntity;

    public HeaderViewInterface(Activity context){
        this.mContext=context;
        mInflate=LayoutInflater.from(mContext);
    }

    public boolean fillView(T t,ListView listView){
        if(t==null){
            return false;
        }
        if((t instanceof List)&&((List)(t)).size()==0){
            return false;
        }
        this.mEntity=t;
       getView(t,listView);
        return true;
    }
    protected abstract void getView(T t,ListView listView);


}
