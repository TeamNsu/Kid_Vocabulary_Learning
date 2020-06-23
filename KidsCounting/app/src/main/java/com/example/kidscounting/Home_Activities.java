package com.example.kidscounting;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class Home_Activities extends AppCompatActivity implements View.OnClickListener {
     private ImageButton counting123,AppleCount;
     private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove notification Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home__activities);

        // hide action bar
        getSupportActionBar().hide();

        // always open in Landscape mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        counting123 = findViewById(R.id.Counting123_button);
        AppleCount = findViewById(R.id.AppleCount_button);
        counting123.setOnClickListener(this);
        AppleCount.setOnClickListener(this);

        // Start_Animation();
        Animation_Runnable.run();

    }


    @Override
    public void onClick(View view) {
        if(view == counting123){
            Intent intent = new Intent(Home_Activities.this,MainActivity.class);
            startActivity(intent);
            finish();
        }if(view == AppleCount){
            Intent intent = new Intent(Home_Activities.this,AppleCount_activity.class);
            startActivity(intent);
            finish();
        }

    }


   public void Start_Animation(){
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.bounce);
        Bounce_animation_Interpolator bounce_animation_interpolator = new Bounce_animation_Interpolator(0.3,15);
        animation.setInterpolator(bounce_animation_interpolator);
        counting123.startAnimation(animation);
        AppleCount.startAnimation(animation);
    }

    private Runnable Animation_Runnable = new Runnable() {
        @Override
        public void run() {
            Start_Animation();
            handler.postDelayed(this,2000);

        }
    };

}