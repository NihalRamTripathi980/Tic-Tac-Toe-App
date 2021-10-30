package com.nihalramtripathi.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.textfield.TextInputEditText;
import com.nihalramtripathi.tictactoe.databinding.ActivityPlayerBinding;

import java.util.Objects;

import hotchemi.android.rate.AppRate;

public class Player_Activity extends AppCompatActivity {


    ActivityPlayerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



     getSupportActionBar().hide();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView;
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Player_Activity.this,MainActivity.class);
                intent.putExtra("playerOne",binding.playerOne.getText().toString().trim());
                intent.putExtra("playerTwo",binding.playerTwo.getText().toString().trim());
                startActivity(intent);
            }
        });


        AppRate.with(this)
                .setInstallDays(0)
                .setLaunchTimes(3)
                .setRemindInterval(2)
                .monitor();

        AppRate.showRateDialogIfMeetsConditions(this);
    }
}