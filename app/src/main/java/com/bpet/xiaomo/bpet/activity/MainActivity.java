package com.bpet.xiaomo.bpet.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.bpet.xiaomo.bpet.R;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.luseen.luseenbottomnavigation.BottomNavigation.OnBottomNavigationItemClickListener;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    // fragment管理类
    private FragmentManager fragmentManager;

    // 三个fragment
    private Fragment tabBabyFragment, tabFriendFragment,tabAttentionFragment, tabSettingFragment;
    private LinearLayout tabBabyLayout, tabFriendLayout, tabAttentionLayout, tabSettingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);


        fragmentManager = getSupportFragmentManager();


        int[] image = {R.drawable.ic_favorite_black_24dp,R.drawable.ic_group_black_24dp,
                R.drawable.ic_star_half_black_24dp, R.drawable.ic_build_black_24dp};
        int[] color = {ContextCompat.getColor(this, R.color.firstColor), ContextCompat.getColor(this, R.color.secondColor),
                ContextCompat.getColor(this, R.color.thirdColor), ContextCompat.getColor(this, R.color.fourthColor)};

        if (bottomNavigationView != null) {
            bottomNavigationView.isWithText(false);
            // bottomNavigationView.activateTabletMode();
            bottomNavigationView.isColoredBackground(true);
            bottomNavigationView.setTextActiveSize(getResources().getDimension(R.dimen.text_active));
            bottomNavigationView.setTextInactiveSize(getResources().getDimension(R.dimen.text_inactive));
            bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.firstColor));
            //bottomNavigationView.setFont(Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Noh_normal.ttf"));
        }

        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem
                ("萌宠", color[0], image[0]);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem
                ("", color[1], image[1]);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem
                ("关注", color[2], image[2]);
        /*BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem
                ("设置", color[3], image[3]);*/


        bottomNavigationView.addTab(bottomNavigationItem);
        bottomNavigationView.addTab(bottomNavigationItem1);
        bottomNavigationView.addTab(bottomNavigationItem2);
        //bottomNavigationView.addTab(bottomNavigationItem3);

        bottomNavigationView.setOnBottomNavigationItemClickListener(new OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                //MyLog.i("index="+index+"--text="+textView.getText());
                switch (index) {
                    case 0://"萌宠"
                        if(tabBabyFragment == null){
                            tabBabyFragment = new TabBabyFragment();
                        }
                        replaceFragment(tabBabyFragment);
                        break;
                    case 1://"朋友"
                        if(tabFriendFragment == null){
                            tabFriendFragment = new TabFriendFragment();
                        }
                        replaceFragment(tabFriendFragment);
                        break;
                    case 2://"关注"
                        if(tabAttentionFragment == null){
                            tabAttentionFragment = new TabAttentionFragment();
                        }
                        replaceFragment(tabAttentionFragment);
                        break;
                    case 3://"设置"
                        if(tabSettingFragment == null){
                            tabSettingFragment = new TabSettingFragment();
                        }
                        replaceFragment(tabSettingFragment);
                        break;
                }
            }
        });
        init();
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomNavigationView.selectTab(2);
            }
        });*/
    }
    /**
     * 初始化控件
     */
    private void init(){
        tabBabyLayout = (LinearLayout)findViewById(R.id.fragment_baby);
        tabFriendLayout = (LinearLayout)findViewById(R.id.fragment_friend);
        tabAttentionLayout = (LinearLayout)findViewById(R.id.fragment_attention);
       /* LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, bottomNavigationView.getHeight());*/
        //tabAttentionLayout.setPadding(0, 0, 0, bottomNavigationView.getHeight());
        tabSettingLayout = (LinearLayout)findViewById(R.id.fragment_setting);
        setDefaultFragment();
    }

    /**
     * 设置默认显示的fragment
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        tabBabyFragment = new TabBabyFragment();
        transaction.replace(R.id.content_layout, tabBabyFragment);
        transaction.commit();
    }

    /**
     * 切换fragment
     * @param newFragment
     */
    private void replaceFragment(Fragment newFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (!newFragment.isAdded()) {
            transaction.replace(R.id.content_layout, newFragment);
            transaction.commit();
        } else {
            transaction.show(newFragment);
        }
    }
}

