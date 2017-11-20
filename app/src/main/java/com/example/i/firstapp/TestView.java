package com.example.i.firstapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Created by i on 2017/11/13.
 */

public class TestView extends View {

    private String testString;
    private TextView view;
    private TypedArray typedArray;
    private Context mContext;
    private Bitmap bitmap;
    private int width;
    private int height;
    private Paint bitmapPaint;
    private Rect rect;
    private int textColor;
    private float textSize;
    private Paint textPaint;
    private String text;

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.TestView);
        testString = typedArray.getString(R.styleable.TestView_test);
        textColor = typedArray.getColor(R.styleable.TestView_textColor, Color.BLACK);
        textSize = typedArray.getDimension(R.styleable.TestView_textSize, 24);
        text = typedArray.getString(R.styleable.TestView_text);
        init();
    }

    private void init() {
        rect = new Rect();
        textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(textSize);
        textPaint.getTextBounds(text,0,text.length(),rect);
    }

    public void setTextColor(int color){
        textColor = color;
    }

    public void setTextSize(float size){
        textSize = size;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int modex = MeasureSpec.getMode(widthMeasureSpec);
        int modey = MeasureSpec.getMode(heightMeasureSpec);
        int sizex = MeasureSpec.getSize(widthMeasureSpec);
        int sizey = MeasureSpec.getSize(heightMeasureSpec);


        if (modex == MeasureSpec.EXACTLY) {
            width = sizex;
            height = sizey;
        } else {
            int newSize = rect.width();
            int newHeight =  rect.height();
            width = newSize;
            height = newHeight;
        }

        setMeasuredDimension(width, height);
        Log.d("zidingyi", "onMeasure------------------");

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("zidingyi", "onSizeChanged------------------");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       /* Log.d("zidingyi", "onDraw------------------");
        int widthb = bitmap.getWidth();
        int heightb = bitmap.getHeight();
        canvas.drawBitmap(bitmap, (width - widthb) / 2, (height - heightb) / 2, bitmapPaint);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();*/
        canvas.drawText(text, 0, rect.height(), textPaint);

        textPaint.setStrokeWidth(5);
    }

    public void change() {
        int index = typedArray.getResourceId(R.styleable.TestView_onclick, 0);
        view = (TextView) ((Activity) mContext).findViewById(index);

        view.setText("ririri");
    }

    public String getTestString() {
        return testString;
    }
}
