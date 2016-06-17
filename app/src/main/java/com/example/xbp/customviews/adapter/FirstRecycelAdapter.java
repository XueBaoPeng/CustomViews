package com.example.xbp.customviews.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xbp.customviews.R;
import com.example.xbp.customviews.bean.ItemBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xbp on 2016/6/17.
 */
public class FirstRecycelAdapter extends RecyclerView.Adapter<FirstRecycelAdapter.FirstHolder> {

    private ArrayList<ItemBean> firstPageBeanList;
    private LinearLayout.LayoutParams localLayoutPareams;
    private ItemClickListener itemClickListener;


    public FirstRecycelAdapter(ArrayList<ItemBean> firstPageBeanList) {
        this.firstPageBeanList = firstPageBeanList;

    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }
    @Override
    public FirstHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_first_page_item,parent,false);
        return new FirstHolder(view);
    }

    @Override
    public void onBindViewHolder(final FirstHolder holder, final int position) {
        final  ItemBean itemBean=firstPageBeanList.get(position);
        holder.item_Title.setText(itemBean.getTitle());
        holder.item_description.setText(itemBean.getDescription());
        holder.itemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemClickListener!=null){
                    itemClickListener.OnItemClick(holder.itemRoot,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return firstPageBeanList.size();
    }

    static  class FirstHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.item_title)
        TextView item_Title;
        @Bind(R.id.item_description)
        TextView item_description;
        @Bind(R.id.item_root)
        RelativeLayout itemRoot;
        public FirstHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
    public interface ItemClickListener{
        public void OnItemClick(View view,int positon);
    }
}
