package com.example.martalainezt24canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

public class MyCanvasView extends View {
    private static final float TOUCH_TOLERANCE = 4;
     Paint mPaint;
    private Path mPath;
    private Bitmap mExtraBitmap;
    private Canvas mExtraCanvas;
    public int mDrawColor;
    private int mBackgroundColor;


    private float mX, mY;
    private Rect mFrame = new Rect();


    public MyCanvasView(Context context, int tamanio, int color) {
        super(context);

        mPaint = new Paint();
        mPath = new Path();
        mDrawColor = color;

        mBackgroundColor = ResourcesCompat.getColor(getResources(), R.color.white, null);

        mPaint.setColor(mDrawColor);
        mPaint.setAntiAlias(true);

        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(tamanio);


    }
    @Override
    protected void onSizeChanged(int vWidth, int vHeight, int oldw, int oldh) {
        mExtraBitmap = Bitmap.createBitmap(vWidth,vHeight,Bitmap.Config.ARGB_8888);
        mExtraCanvas = new Canvas(mExtraBitmap);
        mExtraCanvas.drawColor(mBackgroundColor);
        // Calculate the rect a frame around the picture.
        int inset = 40;
        mFrame = new Rect (inset, inset, vWidth - inset, vHeight - inset);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mExtraBitmap, 0, 0, null);
        // Draw a frame around the picture.
        Paint mPaint2 = new Paint();
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setStrokeJoin(Paint.Join.ROUND);
        mPaint2.setStrokeCap(Paint.Cap.ROUND);
        mPaint2.setStrokeWidth(24);
        canvas.drawRect(mFrame, mPaint2);



    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        // Invalidate() is inside the case statements because there are many
        // other types of motion events passed into this listener,
        // and we don't want to invalidate the view for those.
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                touchStart(x, y);
                // No need to invalidate because we are not drawing anything.
                break;
            case MotionEvent.ACTION_MOVE:
                touchMove(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touchUp();
                // No need to invalidate because we are not drawing anything.
                break;
            default:
                // Do nothing.
        }
        return true;
    }
    private void touchStart(float x, float y) {
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }
    private void touchMove(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            // QuadTo() adds a quadratic bezier from the last point,
            // approaching control point (x1,y1), and ending at (x2,y2).
            mPath.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);
            // Reset mX and mY to the last drawn point.
            mX = x;
            mY = y;
            // Save the path in the extra bitmap,
            // which we access through its canvas.
            mExtraCanvas.drawPath(mPath, mPaint);
        }
    }
    private void touchUp() {
// Reset the path so it doesn't get drawn again.
        mPath.reset();
    }


}
