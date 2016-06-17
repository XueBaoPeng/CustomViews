package com.example.xbp.customviews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xbp.customviews.R;
import com.example.xbp.customviews.activity.DeleteListViewActivity;
import com.example.xbp.customviews.activity.TestActivity;
import com.example.xbp.customviews.adapter.FirstRecycelAdapter;
import com.example.xbp.customviews.bean.ItemBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xbp on 2016/6/17.
 */
public class FirstPageFragment extends Fragment implements FirstRecycelAdapter.ItemClickListener {


    private View rootView;

    @Bind(R.id.first_page_recyclerView)
    RecyclerView firstPageRecycleView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    private LinearLayoutManager linearLayoutManager;
    private FirstRecycelAdapter firstRecycelAdapter;
    private ArrayList<ItemBean> firstItemBeans;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(rootView==null){
        rootView=inflater.inflate(R.layout.fragment_first_page,container,false);
            ButterKnife.bind(this,rootView);

        }
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    private void initView() {
        firstItemBeans=new ArrayList<>();
        firstItemBeans.add(new ItemBean("计数器","一个简单的计数器"));
        firstItemBeans.add(new ItemBean("DeleteListView","一个可以删除的listView"));
        firstRecycelAdapter=new FirstRecycelAdapter(firstItemBeans);
        linearLayoutManager=new LinearLayoutManager(getActivity());
        firstRecycelAdapter.setItemClickListener(this);
        firstPageRecycleView.setLayoutManager(linearLayoutManager);
        firstPageRecycleView.setAdapter(firstRecycelAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstPageRecycleView.smoothScrollToPosition(0);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    @Override
    public void OnItemClick(View view, int positon) {
        Intent intent;
        switch (positon){
            case 0:
                intent=new Intent(getActivity().getApplicationContext(), TestActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent=new Intent(getActivity().getApplicationContext(), DeleteListViewActivity.class);
                startActivity(intent);
                break;
            default:break;
        }
    }
}
