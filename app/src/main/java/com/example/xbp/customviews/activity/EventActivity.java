package com.example.xbp.customviews.activity;

import android.app.usage.UsageEvents;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xbp.customviews.R;
import com.example.xbp.customviews.bean.FirstEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xbp on 2016/6/23.
 */
public class EventActivity extends BaseActivity {

    @Bind(R.id.btn_try)
    Button button;
    @Bind(R.id.tv)
    TextView textView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EventSendActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onEventMainThread(FirstEvent event){
        String msg="onEventMainThread"+event.getmMsg();
        textView.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_LONG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
