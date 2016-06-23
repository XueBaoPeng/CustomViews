package com.example.xbp.customviews.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.xbp.customviews.R;
import com.example.xbp.customviews.bean.FirstEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xbp on 2016/6/23.
 */
public class EventSendActivity extends BaseActivity {

    @Bind(R.id.btn_first_event)
    Button btn_first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_tend);
        ButterKnife.bind(this);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
            }
        });
    }
}
