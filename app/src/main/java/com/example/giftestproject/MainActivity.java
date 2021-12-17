package com.example.giftestproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button but1;
    Button but2;
    Button but3;
    Button but4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        but1 = findViewById(R.id.button1);
        but2 = findViewById(R.id.button2);
        but3 = findViewById(R.id.button3);
        but4 = findViewById(R.id.button4);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGif(R.drawable.emo1);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGif(R.drawable.emo2);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGif(R.drawable.emo3);
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayGif(R.drawable.sam);
            }
        });

    }


    public void PlayGif(final int draw) {
        Glide.with(this).asGif()
                .load(draw)
                .addListener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<GifDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model, Target<GifDrawable> target, DataSource dataSource, boolean isFirstResource) {
                        resource.setLoopCount(4);
                        return false;
                    }
                })

                .into(imageView);
    }
}