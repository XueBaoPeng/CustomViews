package com.example.xbp.customviews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xbp.customviews.R;

import butterknife.ButterKnife;

/**
 * Created by xbp on 2016/6/17.
 */
public class FirstPageFragment extends Fragment {


    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(rootView==null){
        rootView=inflater.inflate(R.layout.fragment_first_page,container,false);
            ButterKnife.bind(this,rootView);

        }
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }
}
