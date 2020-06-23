package com.example.kidscounting;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.io.IOException;

public class AppleCount_activity extends AppCompatActivity implements View.OnClickListener {
    private MainActivity mainActivity;
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4, imageButton5, imageButton6,
            imageButton7, imageButton8, imageButton9, imageButton10, repeat, cross_btn, mute;
    private ImageView AppleShow;
    private MediaPlayer sound1, sound2, sound3, sound4, sound5, sound6, sound7, sound8, sound9,sound10;
    private int state=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove notification Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_apple_count_activity);
        // hide action bar
        getSupportActionBar().hide();
        // always open in Landscape mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // object of main activity
        mainActivity = new MainActivity();
        // find Image view
        AppleShow = findViewById(R.id.Apple_ImageView);
        //find all button
        imageButton1 = findViewById(R.id.btn_1);
        imageButton2 = findViewById(R.id.btn_2);
        imageButton3 = findViewById(R.id.btn_3);
        imageButton4 = findViewById(R.id.btn_4);
        imageButton5 = findViewById(R.id.btn_5);
        imageButton6 = findViewById(R.id.btn_6);
        imageButton7 = findViewById(R.id.btn_7);
        imageButton8 = findViewById(R.id.btn_8);
        imageButton9 = findViewById(R.id.btn_9);
        imageButton10 = findViewById(R.id.btn_10);
        mute = findViewById(R.id.btn_volume);
        repeat = findViewById(R.id.btn_repeat);
        cross_btn = findViewById(R.id.cross_btn);

        //initialize onClick Listener
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        imageButton7.setOnClickListener(this);
        imageButton8.setOnClickListener(this);
        imageButton9.setOnClickListener(this);
        imageButton10.setOnClickListener(this);
        mute.setOnClickListener(this);
        repeat.setOnClickListener(this);
        cross_btn.setOnClickListener(this);

        //create mediaPlayer for all sounds
        sound1 = MediaPlayer.create(this, R.raw.one);
        sound2 = MediaPlayer.create(this, R.raw.two);
        sound3 = MediaPlayer.create(this, R.raw.three);
        sound4 = MediaPlayer.create(this, R.raw.four);
        sound5 = MediaPlayer.create(this, R.raw.five);
        sound6 = MediaPlayer.create(this, R.raw.six);
        sound7 = MediaPlayer.create(this, R.raw.seven);
        sound8 = MediaPlayer.create(this, R.raw.eight);
        sound9 = MediaPlayer.create(this, R.raw.nine);
        sound10 = MediaPlayer.create(this, R.raw.ten);


    }

    @Override
    public void onClick(View view) {
        if (view == mute) {
            if(state==0){
                mute.setImageResource(R.drawable.btn_mute);
                sound1.reset();
                sound2.reset();
                sound3.reset();
                sound4.reset();
                sound5.reset();
                sound6.reset();
                sound7.reset();
                sound8.reset();
                sound9.reset();
                sound10.reset();
                state=state+1;
            }
            else {
                mute.setImageResource(R.drawable.btn_unmute);
                state=state-1;
        }
        }

        if (view == imageButton1) {
            AppleShow.setImageResource(R.drawable.object_1);
            if (sound1 != null) {
                sound1.start();
            }
        }

        if (view == imageButton2) {
            AppleShow.setImageResource(R.drawable.object_2);
            if (sound2 != null) {
                sound2.start();
            }
        }
        if (view == imageButton3) {
            AppleShow.setImageResource(R.drawable.object_3);
            if (sound3 != null) {
                sound3.start();
            }
        }
        if (view == imageButton4) {
            AppleShow.setImageResource(R.drawable.object_4);
            if (sound4 != null) {
                sound4.start();
            }
        }
        if (view == imageButton5) {
            AppleShow.setImageResource(R.drawable.object_5);
            if (sound5 != null) {
                sound5.start();}
            }
            if (view == imageButton6) {
                AppleShow.setImageResource(R.drawable.object_6);
                if (sound6 != null) {
                    sound6.start();
                }
            }
            if (view == imageButton7) {
                AppleShow.setImageResource(R.drawable.object_7);
                if (sound7 != null) {
                    sound7.start();
                }
            }
            if (view == imageButton8) {
                AppleShow.setImageResource(R.drawable.object_8);
                if (sound8 != null) {
                    sound8.start();
                }
            }
            if (view == imageButton9) {
                AppleShow.setImageResource(R.drawable.object_9);
                if (sound9 != null) {
                    sound9.start();
                }
            }
            if (view == imageButton10) {
                AppleShow.setImageResource(R.drawable.object_10);
                if (sound10 != null) {
                    sound10.start();
                }
            }


            }
        }

