package com.example.xbp.customviews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.xbp.customviews.R;
import com.example.xbp.customviews.Url.Urls;
import com.example.xbp.customviews.bean.Category_News_Event;
import com.gigamole.library.navigationtabstrip.NavigationTabStrip;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;

/**
 * Created by xbp on 2016/6/29.
 */
public class TabFragment extends Fragment {

    public static final String TAG="TagFragment";
    private View rootView;
    private  NavigationTabStrip mTopNativgationTabStrip;
    private ViewPager mViewPager;
    private TextView title;
    private Object data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,   ViewGroup container,   Bundle savedInstanceState) {

        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_tab,container,false);

        }
        initView(rootView);
        getData();
        return rootView;
    }

    private void initView(View rootView) {
        mTopNativgationTabStrip= (NavigationTabStrip) rootView.findViewById(R.id.tabstripTop);
        mViewPager= (ViewPager) rootView.findViewById(R.id.tabViewPager);
        title= (TextView) rootView.findViewById(R.id.title);
    }

    public Object getData() {
        HttpRequest.get(Urls.CATEGORY_EVENT,new BaseHttpRequestCallback<Category_News_Event>(){
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            protected void onSuccess(Category_News_Event category_news_event) {
                super.onSuccess(category_news_event);
                title.setText(category_news_event.getTngou().toString());
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                title.setText(msg);
            }
        });


        return null;
    }
}
