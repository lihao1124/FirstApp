package com.example.i.firstapp;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private Outer outer;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        //github test
        //hahahhahahahahaha
    }

    public void clicka(View view){
        ImageView imageView1 = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);
        imageView1.setImageResource(R.mipmap.ic_launcher);
        imageView2.setImageResource(R.mipmap.ic_launcher);
        imageView3.setImageResource(R.mipmap.ic_launcher);
        pageview.add(imageView1);
        pageview.add(imageView2);
        pageview.add(imageView3);
        MyPagerAdapter adapter = new MyPagerAdapter();
        vp.setAdapter(adapter);
    }
    private ArrayList<View> pageview = new ArrayList<>();
    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        //是从ViewGroup中移出当前View
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(pageview.get(arg1));
        }

        //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
        public Object instantiateItem(View arg0, int arg1){
            ((ViewPager)arg0).addView(pageview.get(arg1));
            return pageview.get(arg1);
        }
    }
}
