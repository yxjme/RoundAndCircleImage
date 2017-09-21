package com.deringmobile.jbh.roundandcircleimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.deringmobile.jbh.imagelibrary.CircelImageView;
import com.deringmobile.jbh.imagelibrary.RoundImageView;

public class MainActivity extends AppCompatActivity {


    ImageView image,image1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=(ImageView)findViewById(R.id.image);
        image1=(ImageView)findViewById(R.id.image1);
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.aa);
        CircelImageView circelImage=new CircelImageView(bitmap);
        RoundImageView roundImageView=new RoundImageView(bitmap);
        image.setImageDrawable(circelImage);

        image1.setImageDrawable(roundImageView);

    }
}
