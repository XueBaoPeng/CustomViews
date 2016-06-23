package com.example.xbp.customviews.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xbp.customviews.R;
import com.example.xbp.customviews.model.ChannelEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xbp on 2016/6/23.
 */
public class HeaderChannelAdapter extends BaseListAdapter<ChannelEntity> {


    public HeaderChannelAdapter(List<ChannelEntity> mList, Context mContext) {
        super(mList, mContext);
    }

    public HeaderChannelAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.item_channel,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        ChannelEntity entity=getItem(position);
        viewHolder.tv_title.setText(entity.getTitle());
        mImageManager.loadCircleImage(entity.getImage_url(),viewHolder.ivImage);
        if(TextUtils.isEmpty(entity.getTips())){
            viewHolder.tvTips.setVisibility(View.INVISIBLE);
        }else {
            viewHolder.tvTips.setVisibility(View.VISIBLE);
            viewHolder.tvTips.setText(entity.getTips());
        }
        return convertView;
    }

    static class ViewHolder{
        @Bind(R.id.iv_image)
        ImageView ivImage;
        @Bind(R.id.tv_title)
        TextView tv_title;
        @Bind(R.id.tv_tips)
        TextView tvTips;
        ViewHolder(View view){
            ButterKnife.bind(this,view);
        }
    }
}
