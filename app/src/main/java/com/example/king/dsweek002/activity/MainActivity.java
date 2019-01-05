package com.example.king.dsweek002.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.king.dsweek002.R;
import com.example.king.dsweek002.fragment.ClsFragment;
import com.example.king.dsweek002.fragment.NoneFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    pager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    pager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    pager.setCurrentItem(2);
                    return true;
                case R.id.navigation_shopping:
                    pager.setCurrentItem(3);
                    return true;
                case R.id.navigation_my:
                    pager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };
    private BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        pager = findViewById(R.id.pager);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                switch (i){
                    case 0:;
                        return new NoneFragment();
                    case 1:
                        return new ClsFragment();
                    case 2:
                        return new NoneFragment();
                    case 3:
                        return new NoneFragment();
                    case 4:
                        return new NoneFragment();

                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        navigation.setSelectedItemId(R.id.navigation_home);
                        break;
                    case 1:
                        navigation.setSelectedItemId(R.id.navigation_dashboard);
                        break;
                    case 2:
                        navigation.setSelectedItemId(R.id.navigation_notifications);
                        break;
                    case 3:
                        navigation.setSelectedItemId(R.id.navigation_shopping);
                        break;
                    case 4:
                        navigation.setSelectedItemId(R.id.navigation_my);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

}
