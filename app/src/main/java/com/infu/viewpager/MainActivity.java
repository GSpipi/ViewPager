package com.infu.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bt0;
    private Button bt1;
    private Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewById = ((ViewPager) findViewById(R.id.viewpager));
        bt0 = ((Button) findViewById(R.id.bt0));
        bt1 = ((Button) findViewById(R.id.bt1));
        bt2 = ((Button) findViewById(R.id.bt2));


        List<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentOn());
        fragments.add(new Fragmentttt());
        fragments.add(new BbFragment());


        if (viewById != null) {
            viewById.setAdapter(new Adapter(getSupportFragmentManager(), fragments));

            viewById.setCurrentItem(1);
            bt1.setSelected(true);

            viewById.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    resetTextView();
                    switch (position) {
                        case 0:
                            bt0.setSelected(true);

                            break;
                        case 1:
                            bt1.setSelected(true);
                            break;
                        case 2:
                            bt2.setSelected(true);
                            break;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    public void onTabClicked(View view) {
        switch (view.getId()){

        }

    }

    /**
     * 重置颜色
     */
    private void resetTextView() {

        bt0.setSelected(false);
        bt1.setSelected(false);
        bt2.setSelected(false);

    }
}
