package com.nihalramtripathi.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.nihalramtripathi.tictactoe.databinding.ActivityMainBinding;

import java.nio.MappedByteBuffer;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    InterstitialAd mInterstitialAd ;

     String startGame = "x";
    int b1 = 5, b2 = 5, b3 = 5, b4 = 5, b5 = 5, b6 = 5, b7 = 5, b8 = 5, b9 = 5, xCount = 0, oCount = 0, i = 0;

    AdRequest adRequest;
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getSupportActionBar().hide();


        //Ads

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdView mAdView;
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
//ads



        String player1 = getIntent().getStringExtra("playerOne").trim();
        String player2 = getIntent().getStringExtra("playerTwo").trim();

        binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));
        binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        if (startGame.equals("o")){

            ImageView imageY = (ImageView) findViewById(R.id.yArrow);
            Animation animation1 =
                    AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.blink);
            imageY.startAnimation(animation1);
            binding.xArrow.clearAnimation();

            binding.xArrow.setVisibility(View.INVISIBLE);
            binding.yArrow.setVisibility(View.VISIBLE);

        }
        else {
            ImageView imageX= (ImageView) findViewById(R.id.xArrow);
            Animation animation1 =
                    AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.blink);
            imageX.startAnimation(animation1);
            binding.yArrow.clearAnimation();

            binding.yArrow.setVisibility(View.INVISIBLE);
            binding.xArrow.setVisibility(View.VISIBLE);




        }





        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            startGame ="x";











                // reset code is here
                binding.buttonImage1.setImageDrawable(null);
                binding.buttonImage2.setImageDrawable(null);
                binding.buttonImage3.setImageDrawable(null);
                binding.buttonImage4.setImageDrawable(null);
                binding.buttonImage5.setImageDrawable(null);
                binding.buttonImage6.setImageDrawable(null);
                binding.buttonImage7.setImageDrawable(null);
                binding.buttonImage8.setImageDrawable(null);
                binding.buttonImage9.setImageDrawable(null);
                resetValues();
                xCount=0;
                oCount=0;

                binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));
                binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));

            }
        });

        // button code



        binding.buttonImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage1.setImageResource(R.drawable.cross);
                    b1=1;
                    i++;


                }
                else {
                    binding.buttonImage1.setImageResource(R.drawable.circle);
                    b1=0;
                    i++;
                }
                binding.buttonImage1.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });

        binding.buttonImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage2.setImageResource(R.drawable.cross);
                    b2=1;
                    i++;


                }
                else {
                    binding.buttonImage2.setImageResource(R.drawable.circle);
                    b2=0;
                    i++;
                }
                binding.buttonImage2.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });

        binding.buttonImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage3.setImageResource(R.drawable.cross);
                    b3=1;
                    i++;


                }
                else {
                    binding.buttonImage3.setImageResource(R.drawable.circle);
                    b3=0;
                    i++;
                }
                binding.buttonImage3.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });

        binding.buttonImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage4.setImageResource(R.drawable.cross);
                    b4=1;
                    i++;


                }
                else {
                    binding.buttonImage4.setImageResource(R.drawable.circle);
                    b4=0;
                    i++;
                }
                binding.buttonImage4.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });

        binding.buttonImage5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage5.setImageResource(R.drawable.cross);
                    b5=1;
                    i++;


                }
                else {
                    binding.buttonImage5.setImageResource(R.drawable.circle);
                    b5=0;
                    i++;
                }
                binding.buttonImage5.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });

        binding.buttonImage6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage6.setImageResource(R.drawable.cross);
                    b6=1;
                    i++;


                }
                else {
                    binding.buttonImage6.setImageResource(R.drawable.circle);
                    b6=0;
                    i++;
                }
                binding.buttonImage6.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });

        binding.buttonImage7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage7.setImageResource(R.drawable.cross);
                    b7=1;
                    i++;


                }
                else {
                    binding.buttonImage7.setImageResource(R.drawable.circle);
                    b7=0;
                    i++;
                }
                binding.buttonImage7.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });


        binding.buttonImage8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage8.setImageResource(R.drawable.cross);
                    b8=1;
                    i++;


                }
                else {
                    binding.buttonImage8.setImageResource(R.drawable.circle);
                    b8=0;
                    i++;
                }
                binding.buttonImage8.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });

        binding.buttonImage9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (startGame.equals("x")){
                    binding.buttonImage9.setImageResource(R.drawable.cross);
                    b9=1;
                    i++;


                }
                else {
                    binding.buttonImage9.setImageResource(R.drawable.circle);
                    b9=0;
                    i++;
                }
                binding.buttonImage9.setClickable(false);
                choosePlayer();
                winningGame(player1,player2);
            }
        });


    }
        public  void winningGame( String player1 ,String player2) {

        if ((b1 == 1) && (b2 == 1) && (b3 == 1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));


        } else if ((b4 == 1) && (b5 == 1) && (b6 == 1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));


        } else if ((b7 == 1) && (b8 == 1) && (b9 == 1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));


        } else if ((b1 == 1) && (b4 == 1) && (b7 == 1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));


        } else if ((b2 == 1) && (b5 == 1) && (b8 == 1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));


        } else if ((b3 == 1) && (b6 == 1) && (b9 == 1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));


        } else if ((b1 == 1) && (b5 == 1) && (b9 == 1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));


        } else if ((b3 == 1) && (b5 == 1) && (b7 == 1)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player1 + "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            xCount++;
            binding.scoreX.setText(player1 + ":- " + String.valueOf(xCount));


        } else if ((b1 == 0) && (b2 == 0) && (b3 == 0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2+ "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        } else if ((b4 == 0) && (b5 == 0) && (b6 == 0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2+ "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        } else if ((b7 == 0) && (b8 == 0) && (b9 == 0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2+ "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        } else if ((b1 == 0) && (b4 == 0) && (b7 == 0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2+ "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);

                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        } else if ((b2 == 0) && (b5 == 0) && (b8 == 0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2+ "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        } else if ((b3 == 0) && (b6 == 0) && (b9 == 0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2+ "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        } else if ((b1 == 0) && (b5 == 0) && (b9 == 0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2+ "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);
                            resetValues();
                            resetClickAblility();

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        } else if ((b3 == 0) && (b5 == 0) && (b7 == 0)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(player2+ "  Won").setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            binding.buttonImage1.setImageDrawable(null);
                            binding.buttonImage2.setImageDrawable(null);
                            binding.buttonImage3.setImageDrawable(null);
                            binding.buttonImage4.setImageDrawable(null);
                            binding.buttonImage5.setImageDrawable(null);
                            binding.buttonImage6.setImageDrawable(null);
                            binding.buttonImage7.setImageDrawable(null);
                            binding.buttonImage8.setImageDrawable(null);
                            binding.buttonImage9.setImageDrawable(null);

                            resetValues();
                            resetClickAblility();


                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            oCount++;
            binding.scoreY.setText(player2 + ":- " + String.valueOf(oCount));


        } else {
            if (i == 9) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("No One Win").setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                binding.buttonImage1.setImageDrawable(null);
                                binding.buttonImage2.setImageDrawable(null);
                                binding.buttonImage3.setImageDrawable(null);
                                binding.buttonImage4.setImageDrawable(null);
                                binding.buttonImage5.setImageDrawable(null);
                                binding.buttonImage6.setImageDrawable(null);
                                binding.buttonImage7.setImageDrawable(null);
                                binding.buttonImage8.setImageDrawable(null);
                                binding.buttonImage9.setImageDrawable(null);

                                resetValues();
                                resetClickAblility();

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        }

    }



    private void choosePlayer() {

        if (startGame.equals("x")){

            startGame="o";



            ImageView imageY = (ImageView) findViewById(R.id.yArrow);
            Animation animation1 =
                    AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.blink);
            imageY.startAnimation(animation1);
            binding.xArrow.clearAnimation();

            binding.xArrow.setVisibility(View.INVISIBLE);
            binding.yArrow.setVisibility(View.VISIBLE);


        }
        else {
            startGame="x";



            ImageView imageX= (ImageView) findViewById(R.id.xArrow);
            Animation animation1 =
                    AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.blink);
            imageX.startAnimation(animation1);
            binding.yArrow.clearAnimation();

            binding.yArrow.setVisibility(View.INVISIBLE);
            binding.xArrow.setVisibility(View.VISIBLE);



        }
    }

    private void resetValues() {

        if (startGame.equals("o")){

            ImageView imageY = (ImageView) findViewById(R.id.yArrow);
            Animation animation1 =
                    AnimationUtils.loadAnimation(getApplicationContext(),
                            R.anim.blink);
            imageY.startAnimation(animation1);
            binding.xArrow.clearAnimation();

            binding.xArrow.setVisibility(View.INVISIBLE);
            binding.yArrow.setVisibility(View.VISIBLE);

        }
        else {
            ImageView imageX= (ImageView) findViewById(R.id.xArrow);
            Animation animation1 =
                    AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
            imageX.startAnimation(animation1);
            binding.yArrow.clearAnimation();

            binding.yArrow.setVisibility(View.INVISIBLE);
            binding.xArrow.setVisibility(View.VISIBLE);
        }

        i=0;
        b1=5;
        b2=5; 
        b3=5;
        b4=5;
        b5=5;
        b6=5;
        b7=5;
        b8=5;
        b9=5;

        resetClickAblility();
    }
    private void resetClickAblility(){


        binding.buttonImage1.setClickable(true);
        binding.buttonImage2.setClickable(true);
        binding.buttonImage3.setClickable(true);
        binding.buttonImage4.setClickable(true);
        binding.buttonImage5.setClickable(true);
        binding.buttonImage6.setClickable(true);
        binding.buttonImage7.setClickable(true);
        binding.buttonImage8.setClickable(true);
        binding.buttonImage9.setClickable(true);
    }
}





