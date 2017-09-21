package com.deringmobile.jbh.imagelibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by zbsdata on 2017/9/21.
 */

public class RoundImageView extends Drawable {

    private Paint paint;
    private Bitmap bitmap;
    private RectF rectF;

    private int mWidth;
    public RoundImageView(Bitmap bitmap){
        this.bitmap=bitmap;

        BitmapShader shader=new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        paint=new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setShader(shader);
        mWidth = Math.min(bitmap.getWidth(),bitmap.getHeight());
    }
    @Override
    public int getIntrinsicWidth()
    {
        return mWidth;
    }

    @Override
    public int getIntrinsicHeight()
    {
        return mWidth;
    }
    @Override
    public void setBounds(int left, int top, int right, int bottom)
    {
        super.setBounds(left, top, right, bottom);
        rectF = new RectF(left, top, right, bottom);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawRoundRect(rectF,50,50,paint);
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
