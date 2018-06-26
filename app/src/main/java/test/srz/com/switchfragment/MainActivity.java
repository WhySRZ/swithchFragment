package test.srz.com.switchfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import test.srz.com.switchfragment.adapter.LazyCustomFragmentPageAdapter;

public class MainActivity
        extends AppCompatActivity
{

    private List<Fragment> mList = new ArrayList<>();
    LazyViewPager mViewPager;
    RadioGroup mRadioGroup;
    RadioButton mRbNews;
    RadioButton mRbContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {
        mList.add(new MessageFragment());
        mList.add(new ContactFragment());

        mViewPager = findViewById(R.id.vp_news);
        mRadioGroup = findViewById(R.id.rg_group);
        mRbNews = findViewById(R.id.rb_news);
        mRbContact = findViewById(R.id.rb_contact);
        mViewPager.setAdapter(new LazyCustomFragmentPageAdapter(MainActivity.this.getSupportFragmentManager(),mList));

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.rb_news){
                    mViewPager.setCurrentItem(0);
                    switchItem(0);

                }else if (checkedId == R.id.rb_contact){
                    mViewPager.setCurrentItem(1);
                    switchItem(1);
                }
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position,
                                       float positionOffset,
                                       int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position) {
                //ViewPage和RadioGroup相关联

                switch (position){
                    case 0:
                        mRadioGroup.check(R.id.rb_news);
                        switchItem(0);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.rb_contact);
                        switchItem(1);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void switchItem(int i) {

        if (i == 0){
            mRbNews.setBackgroundResource(R.drawable.project_item_left_bg2);
            mRbNews.setTextColor(getResources().getColor(R.color.blue));
            mRbContact.setBackgroundResource(R.drawable.project_item_right_bg1);
            mRbContact.setTextColor(getResources().getColor(R.color.white));
        }else if (i == 1){
            mRbNews.setBackgroundResource(R.drawable.project_item_left_bg1);
            mRbNews.setTextColor(getResources().getColor(R.color.white));
            mRbContact.setBackgroundResource(R.drawable.project_item_right_bg2);
            mRbContact.setTextColor(getResources().getColor(R.color.blue));
        }
    }
}
