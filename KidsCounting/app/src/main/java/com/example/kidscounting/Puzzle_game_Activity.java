package com.example.kidscounting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class Puzzle_game_Activity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton cross_btn, repeat_sound,two_btn,four_btn,six_btn;
    private MediaPlayer mp1, mp2, mp3, mp4,mp5;
    private int state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove notification Bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_puzzle_game);
        // hide action bar
        getSupportActionBar().hide();
        // always open in Landscape mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //find all the button
        two_btn = findViewById(R.id.puzzle_2_btn);
        four_btn = findViewById(R.id.puzzle_4_btn);
        six_btn = findViewById(R.id.puzzle_6_btn);
        cross_btn = findViewById(R.id.puzzle_cross_btn);
        repeat_sound = findViewById(R.id.repeat_volume_btn);

        // adding onClick Listener
        two_btn.setOnClickListener(this);
        four_btn.setOnClickListener(this);
        six_btn.setOnClickListener(this);
        cross_btn.setOnClickListener(this);
        repeat_sound.setOnClickListener(this);

        Random_number_generator();
        Puzzle_create();
    }

    @Override
    public void onClick(View view) {
        if (view == cross_btn){
            Fade_Animation();
            Intent intent = new Intent(Puzzle_game_Activity.this,Home_Activities.class);
            startActivity(intent);
            finish();
        }

        if (view == two_btn){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
            two_btn.startAnimation(animation);

            if (state == 1){
                  mp5 = MediaPlayer.create(this,R.raw.winner);
                  mp5.start();
                  startActivity(new Intent(Puzzle_game_Activity.this,Pop.class));
             }
             else {
                 mp4 = MediaPlayer.create(this,R.raw.no);
                 mp4.start();
                 Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_LONG).show();
             }
        }

        if (view == four_btn){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
            four_btn.startAnimation(animation);

            if (state == 2){
                mp5 = MediaPlayer.create(this,R.raw.winner);
                mp5.start();
                startActivity(new Intent(Puzzle_game_Activity.this,Pop.class));
            }
            else {
                mp4 = MediaPlayer.create(this,R.raw.no);
                mp4.start();
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_SHORT).show();
            }
        }

        if (view == six_btn){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.move);
            six_btn.startAnimation(animation);

            if (state == 3) {
                mp5 = MediaPlayer.create(this, R.raw.winner);
                mp5.start();
                startActivity(new Intent(Puzzle_game_Activity.this,Pop.class));
            }
                else{
                    mp4 = MediaPlayer.create(this, R.raw.no);
                    mp4.start();
                Toast.makeText(getApplicationContext(), "NO", Toast.LENGTH_SHORT).show();
            }
        }

        if (view == repeat_sound){
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);
            repeat_sound.startAnimation(animation);
            Puzzle_create();
        }
    }

    public void Random_number_generator(){
        Random random = new Random();
        state = random.nextInt(3)+1;
    }
    public void Puzzle_create(){
        if (state == 1){
           mp1 = MediaPlayer.create(this,R.raw.two);
           mp1.start();
        }
        if (state == 2){
           mp2 = MediaPlayer.create(this,R.raw.four);
           mp2.start();
        }
        if (state == 3){
           mp3 = MediaPlayer.create(this,R.raw.six);
           mp3.start();
        }
    }

    public void Fade_Animation() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        cross_btn.startAnimation(animation);
    }
}