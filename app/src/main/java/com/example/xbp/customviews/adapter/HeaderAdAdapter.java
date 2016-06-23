package com.example.xbp.customviews.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * 广告条的适配器
 * Created by xbp on 2016/6/21.
 */
public class HeaderAdAdapter extends PagerAdapter {

    private Context mContext;
    private List<ImageView>ivList;//ImageView的集合
    private int count=1;//广告的数量

    public HeaderAdAdapter(Context mContext, List<ImageView> ivList) {
        super();
        this.mContext = mContext;
        this.ivList = ivList;
        if(ivList!=null&&ivList.size()>0){
            count=ivList.size();
        }
    }

    @Override
    public int getCount() {
        if(count==1){
            return 1;
        }else {
            return Integer.MAX_VALUE;
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int newPosition=position%count;
        // 先移除在添加，更新图片在container中的位置（把iv放至container末尾）
        ImageView iv=ivList.get(newPosition);
        container.removeView(iv);
        container.addView(iv);
        return iv;
    }
}
