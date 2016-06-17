package com.example.xbp.customviews.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.xbp.customviews.R;
import com.example.xbp.customviews.view.DeleteListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xbp on 2016/6/17.
 */
public class DeleteListViewActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.delete_listview)
    DeleteListView deleteListView;
    private MyAdapter adaper;
    private List<String> contentList=new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_listview);
        ButterKnife.bind(this);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white_text));
        toolbar.setTitle("删除的ListView");
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        initList();
    }

    private void initList() {
         for(int i=0;i<20;i++){
             contentList.add("Content--->"+i);
         }
        deleteListView.setOnDeleteListener(new DeleteListView.OnDeleteListener() {
            @Override
            public void onDelete(int index) {
                contentList.remove(index);
                adaper.notifyDataSetChanged();
            }
        });
        adaper=new MyAdapter(this,0,contentList);
        deleteListView.setAdapter(adaper);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    class  MyAdapter extends ArrayAdapter<String>{

        public MyAdapter(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if(convertView==null){
                view= LayoutInflater.from(getContext()).inflate(R.layout.delete_listview_item,null);
            }else{
                view=convertView;
            }
            TextView textView= (TextView) view.findViewById(R.id.text_view);
            textView.setText(getItem(position));
            return view;
        }
    }
}
