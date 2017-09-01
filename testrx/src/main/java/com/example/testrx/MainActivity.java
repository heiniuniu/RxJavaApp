package com.example.testrx;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import com.example.testrx.ui.Home.HomeFragment;
import com.example.testrx.ui.dash.DashFragment;
import com.example.testrx.ui.notification.NotificationFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager mMainVp;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mMainVp.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    mMainVp.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    mMainVp.setCurrentItem(2);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainVp = (ViewPager) findViewById(R.id.main_vp);
        initVp();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void initVp() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new DashFragment());
        fragments.add(new NotificationFragment());
        mMainVp.setAdapter(new MyAdapter(fragments, getSupportFragmentManager()));
    }

    private static class MyAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;

        public MyAdapter(List<Fragment> fragments, FragmentManager fm) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
