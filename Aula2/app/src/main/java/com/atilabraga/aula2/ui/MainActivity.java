package com.atilabraga.aula2.ui;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.atilabraga.aula2.R;
import com.atilabraga.aula2.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        mViewPager.setAdapter(
                new ViewPagerAdapter(this,
                        getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(final int position) {
//                Toast.makeText(MainActivity.this,
//                        "Aba: " + (position + 1),
//                        Toast.LENGTH_SHORT).show();
                final Snackbar snack = Snackbar.make(mViewPager,
                        "Aba: " + (position + 1),
                        Snackbar.LENGTH_INDEFINITE);
                snack.setAction("Toast", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this,
                                "Aba: " + (position + 1),
                                Toast.LENGTH_SHORT).show();
                        snack.dismiss();
                    }
                });
                snack.show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void setViews() {
        mViewPager = (ViewPager) findViewById(R.id.main_view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.main_tab_layout);
    }

}
