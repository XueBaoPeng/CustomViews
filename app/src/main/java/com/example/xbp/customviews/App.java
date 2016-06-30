package com.example.xbp.customviews;

import android.app.Application;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;


/**
 * Created by xbp on 2016/6/30.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpFinalConfiguration.Builder builder= new OkHttpFinalConfiguration.Builder();
        OkHttpFinal.getInstance().init(builder.build());
    }


}
