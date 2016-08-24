package com.jaydenxiao.expandabletextviewexample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import jaydenxiao.com.expandabletextview.ExpandableTextView;


public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiView();
        initData();
    }

    private void initiView() {
        mViewPager= (ViewPager) findViewById(R.id.container);
        mTabLayout= (TabLayout) findViewById(R.id.tabs );
    }

    private void initData() {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        setupTabLayout(mTabLayout);
    }


    private void setupTabLayout(TabLayout tabLayout) {
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(mViewPager);
    }
    /**
     * viewpager适配器
     */
    class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new FragmentListview();
            } else {
                return new FragemntScrollview();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.situation1);
                case 1:
                    return getString(R.string.situation2);
            }
            return null;
        }
    }

    /**
     非列表情况fragment
     */
    public static class FragemntScrollview extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fra_scrollview, container, false);

            ExpandableTextView etvLeft = (ExpandableTextView) rootView.findViewById(R.id.etv_left);
            ExpandableTextView etvpRight = (ExpandableTextView) rootView.findViewById(R.id.etv_right);

            etvLeft.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
                @Override
                public void onExpandStateChanged(TextView textView, boolean isExpanded) {
                    Toast.makeText(getActivity(), isExpanded ? "展开" : "收起", Toast.LENGTH_SHORT).show();
                }
            });
            etvpRight.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
                @Override
                public void onExpandStateChanged(TextView textView, boolean isExpanded) {
                    Toast.makeText(getActivity(), isExpanded ? "展开" : "收起", Toast.LENGTH_SHORT).show();
                }
            });
            etvLeft.setText(getString(R.string.test_content));
            etvpRight.setText(getString(R.string.test_content));

            return rootView;
        }
    }
    /**
     列表情况fragment
     */
    public static class FragmentListview extends ListFragment {
        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            ListAdapter adapter = new ListAdapter(getActivity());
            setListAdapter(adapter);
        }
    }

}
