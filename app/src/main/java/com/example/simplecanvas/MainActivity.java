package com.example.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText=new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.my_image_view);
        mPaint.setColor(Color.BLUE);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.black, null));
        mPaintText.setTextSize(60);
    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap=Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas (mBitmap);
        mCanvas.drawARGB(255, 78, 168, 186);
        mCanvas.drawText("Reyhan Muhammad",100,100, mPaintText);

        Path path=new Path();
        path.moveTo(350,200);
        path.lineTo(100,350);
        path.lineTo(600,350);
        mPaint.setColor(Color.MAGENTA);
        mCanvas.drawPath(path, mPaint);

        mPaint.setColor(Color.BLACK);
        Rect mRect = new Rect();
        mRect.set(100, 350, 600, 750);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(Color.parseColor("#FFFFFF"));
        mCanvas.drawCircle(450,550, 80, mPaint);


        mPaint.setColor(Color.parseColor("#753613"));
        Rect mRect1 = new Rect();
        mRect1.set(150, 450, 300, 750);
        mCanvas.drawRect(mRect1, mPaint);

        mPaint.setColor(Color.BLACK);
        mCanvas.drawCircle(180, 580, 15, mPaint);

        mPaint.setColor(Color.parseColor("#753613"));
        mPaint.setStrokeWidth(10);
        mCanvas.drawLine(450,470,450,630,mPaint);

        mPaint.setStrokeWidth(10);
        mCanvas.drawLine(370,550,530,550,mPaint);

        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
        mCanvas.drawCircle(450,550, 80, mPaint);

        view.invalidate();
    }
}