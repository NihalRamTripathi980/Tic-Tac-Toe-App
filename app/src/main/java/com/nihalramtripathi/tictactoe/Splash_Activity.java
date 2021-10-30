package com.nihalramtripathi.tictactoe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Activity extends AppCompatActivity {

    private ImageView logo;
    private static int splashTimeOut=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        getSupportActionBar().hide();


            logo=(ImageView)findViewById(R.id.logo);

             new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Splash_Activity.this,Player_Activity.class);
                    startActivity(i);
                    finish();
                }
            },splashTimeOut);

            Animation myanim = AnimationUtils.loadAnimation(this,R.anim.clockwise);
            logo.startAnimation(myanim);
        }





    }

