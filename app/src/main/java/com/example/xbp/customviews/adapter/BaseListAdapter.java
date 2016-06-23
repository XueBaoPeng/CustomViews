package com.example.xbp.customviews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.xbp.customviews.manager.ImageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xbp on 2016/6/23.
 */
public abstract class BaseListAdapter<E> extends BaseAdapter {

    private List<E> mList=new ArrayList<E>();
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected ImageManager mImageManager;

    public BaseListAdapter(Context mContext) {
        this.mContext = mContext;
        mInflater=LayoutInflater.from(mContext);
        mImageManager=new ImageManager(mContext);
    }

    public BaseListAdapter(List<E> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
        this.mImageManager=new ImageManager(mContext);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public E getItem(int position) {
        return  (E)mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public void clearAll(){
        mList.clear();
    }
    public List<E> getData(){
        return mList;
    }
    public void removeEntity(E e){
        mList.remove(e);
    }
    public void addAll(List<E> lists){
        if(lists==null||lists.size()==0){
            return;
        }
        mList.addAll(lists);
    }

}
