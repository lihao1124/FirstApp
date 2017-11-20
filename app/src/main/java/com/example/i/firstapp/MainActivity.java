package com.example.i.firstapp;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener {


    private TestView testView;
    private TextView tv;
    private String replace;
    private Date date;
    private TextView tab1;
    private TextView tab2;
    private TextView tab3;
    private TextView tab4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab1 = (TextView) findViewById(R.id.tab_time);
        tab2 = (TextView) findViewById(R.id.tab_up);
        tab3 = (TextView) findViewById(R.id.tab_down);
        tab4 = (TextView) findViewById(R.id.tab_ping);
        tv = (TextView) findViewById(R.id.tv);

        tab1.setOnFocusChangeListener(this);
        tab2.setOnFocusChangeListener(this);
        tab3.setOnFocusChangeListener(this);
        tab4.setOnFocusChangeListener(this);

//        tab1.setOnClickListener(this);
//        tab2.setOnClickListener(this);
//        tab3.setOnClickListener(this);
//        tab4.setOnClickListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.tab_time:
                if (hasFocus)
                    tv.setText("1");
                break;
            case R.id.tab_up:
                if (hasFocus)
                    tv.setText("2");
                break;
            case R.id.tab_down:
                if (hasFocus)
                    tv.setText("3");
                break;
            case R.id.tab_ping:
                if (hasFocus)
                    tv.setText("4");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_time:
                tv.setText("1");
                break;
            case R.id.tab_up:
                tv.setText("2");
                break;
            case R.id.tab_down:
                tv.setText("3");
                break;
            case R.id.tab_ping:
                tv.setText("4");
                break;
        }
    }
}
