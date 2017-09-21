package com.deringmobile.jbh.imagelibrary;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by zbsdata on 2017/9/21.
 */

public class CircelImageView extends Drawable {

    private Bitmap bitmap;
    private Paint paint;
    private int mWidth;

    public CircelImageView(Bitmap bitmap){
        this.bitmap=bitmap;
        mWidth = Math.min(bitmap.getWidth(),bitmap.getHeight());
        BitmapShader bitmapShader=new BitmapShader(bitmap, Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        paint=new Paint();
        paint.setDither(true);
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
    }

    @Override
    public void setBounds(@NonNull Rect bounds) {
        super.setBounds(bounds);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 2, paint);
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
