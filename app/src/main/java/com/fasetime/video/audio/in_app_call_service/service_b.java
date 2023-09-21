package com.fasetime.video.audio.in_app_call_service;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.fasetime.video.audio.R;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;

public class service_b extends AppCompatActivity {

    private TextView note;
    private boolean backer = false;
    private LottieAnimationView lottie;

    pro_sdk_c transMainPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_m);

        transMainPref = new pro_sdk_c(this);

        note = findViewById(R.id.note);
        lottie = findViewById(R.id.lottie);


        pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.adsContainer));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backer = true;
                if (transMainPref.getVideo_call().equalsIgnoreCase("on")) {
                    lottie.setAnimation("suc.json");
                    lottie.playAnimation();
                    lottie.loop(true);
                    note.setTextColor(getResources().getColor(R.color.green));
                    note.setText("Video call connected!");
                    TextView button = findViewById(R.id.my_button);
                    button.setVisibility(View.VISIBLE);
                    button.setText("JOIN");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (isNetworkConnected()) {
                                Show_Dialog();
                            }
                        }
                    });

                } else {
                    lottie.setAnimation("failed.json");
                    lottie.loop(true);
                    lottie.setRepeatMode(LottieDrawable.RESTART);
                    lottie.playAnimation();
                    note.setTextColor(Color.RED);
                    note.setText("People not found!");
                    TextView button = findViewById(R.id.my_button);
                    button.setVisibility(View.VISIBLE);
                    button.setText("TRY AGAIN");
                    button.setBackground(getResources().getDrawable(R.drawable.ad_exit_three));
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (isNetworkConnected())
                                startActivity(new Intent(service_b.this, service_b.class));
                            finish();
                        }
                    });
                }
            }
        }, 6000);
    }

    private void Show_Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(service_b.this);
        final View view = getLayoutInflater().inflate(R.layout.in_app_l, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView txt_con = view.findViewById(R.id.txt_con);
        txt_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(service_b.this, service_c.class));
                finish();
            }
        });
        dialog.show();
    }


    @Override
    public void onBackPressed() {
        if (backer) {
            try {
                super.onBackPressed();
                pro_sdk_i.ShowInterstitialAdsOnBack(this);
            } catch (Exception e) {
                finish();
                e.printStackTrace();
            }
        }
    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}