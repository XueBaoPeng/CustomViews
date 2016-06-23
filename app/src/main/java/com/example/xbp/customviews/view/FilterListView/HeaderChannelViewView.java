package com.example.xbp.customviews.view.FilterListView;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;

import com.example.xbp.customviews.R;
import com.example.xbp.customviews.adapter.HeaderChannelAdapter;
import com.example.xbp.customviews.model.ChannelEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xbp on 2016/6/23.
 */
public class HeaderChannelViewView extends HeaderViewInterface<List<ChannelEntity>> {

    @Bind(R.id.gv_channel)
    FileGridView gvChannel;

    public HeaderChannelViewView(Activity context) {
        super(context);
    }

    @Override
    protected void getView(List<ChannelEntity> channelEntities, ListView listView) {
        View view=mInflate.inflate(R.layout.header_channel_layout,null);
        ButterKnife.bind(this, view);
        dealWithTheView(channelEntities);
        listView.addHeaderView(view);

    }

    private void dealWithTheView(List<ChannelEntity>list){
        int size=list.size();

        if(size<4){
            gvChannel.setNumColumns(size);
        }else if(size==6){
            gvChannel.setNumColumns(3);
        }else if (size==8){
            gvChannel.setNumColumns(4);
        }else {
            gvChannel.setNumColumns(4);
        }
        HeaderChannelAdapter headerChannelAdapter=new HeaderChannelAdapter(list,mContext);
        gvChannel.setAdapter(headerChannelAdapter);
    }
}
