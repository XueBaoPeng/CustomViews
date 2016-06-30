package com.example.xbp.customviews.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.widget.ImageView;

import com.example.xbp.customviews.R;
import com.example.xbp.customviews.fragment.FirstPageFragment;
import com.example.xbp.customviews.fragment.TabFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @Bind(R.id.setting_icon)
    ImageView setttingIcon;

    private SparseArray<Fragment> fragments;
    private SparseArray<Integer> colors;
    @Bind(R.id.toolBar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white_text));
        fragments=new SparseArray<>();
        colors=new SparseArray<>();

        fragments.put(R.id.bottomBarItem1, new FirstPageFragment());
        fragments.put(R.id.bottomBarItem2, new TabFragment());
        fragments.put(R.id.bottomBarItem3,new FirstPageFragment());
        fragments.put(R.id.bottomBarItem4,new FirstPageFragment());
        colors.put(R.id.bottomBarItem1, ContextCompat.getColor(this, R.color.tab_color_1));
        colors.put(R.id.bottomBarItem2, ContextCompat.getColor(this, R.color.tab_color_2));
        colors.put(R.id.bottomBarItem3, ContextCompat.getColor(this, R.color.tab_color_3));
        colors.put(R.id.bottomBarItem4, ContextCompat.getColor(this, R.color.tab_color_4));
        BottomBar mBottomBar=BottomBar.attach(this,savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.button_menu, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(int menuItemId) {
                Fragment tragetFragment=fragments.get(menuItemId);
                setFragment(tragetFragment);
                toolbar.setBackgroundColor(colors.get(menuItemId));
                setTranslucenttatus(colors.get(menuItemId));
            }

            @Override
            public void onMenuTabReSelected(int menuItemId) {

            }
        });

        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.tab_color_1));
        mBottomBar.mapColorForTab(1,ContextCompat.getColor(this,R.color.tab_color_2));
        mBottomBar.mapColorForTab(2,ContextCompat.getColor(this,R.color.tab_color_3));
        mBottomBar.mapColorForTab(3,ContextCompat.getColor(this,R.color.tab_color_4));
    }

    private void setFragment(Fragment fragment){
        if(fragments==null){
            return;
        }

        FragmentManager fragmentManager=this.getSupportFragmentManager();
         FragmentTransaction transaction=fragmentManager.beginTransaction();
        if(fragment.isAdded()&&fragment.isVisible()){
            return;
        }
        if(fragment.isAdded()){
            transaction.show(fragment);
        }else {
            transaction.replace(R.id.content,fragment);
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
