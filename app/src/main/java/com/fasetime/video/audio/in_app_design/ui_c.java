package com.fasetime.video.audio.in_app_design;

import static com.fasetime.video.audio.in_app_design.ui_g.incoming_counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.fasetime.video.audio.R;
import com.fasetime.video.audio.in_app_call_service.service_a;
import com.fasetime.video.audio.in_app_call_service.service_b;

import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;

public class ui_c extends AppCompatActivity {

    pro_sdk_c transMainPref;
    LinearLayout guide_1, guide_2, guide_3, guide_4, guide_5, guide_6, guide_7, guide_8, guide_9, guide_0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_e);

        incoming_counter++;
        transMainPref = new pro_sdk_c(this);

        
        pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.big_native));
        init();

        guide_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ui_c.this, service_b.class));
            }
        });

        guide_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(1);
            }
        });
        guide_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(2);
            }
        });
        guide_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(3);
            }
        });
        guide_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(4);
            }
        });
        guide_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(5);
            }
        });
        guide_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(6);
            }
        });
        guide_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(7);
            }
        });
        guide_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(8);
            }
        });
    }

    public void init() {
        guide_1 = findViewById(R.id.guide_1);
        guide_2 = findViewById(R.id.guide_2);
        guide_3 = findViewById(R.id.guide_3);
        guide_4 = findViewById(R.id.guide_4);
        guide_5 = findViewById(R.id.guide_5);
        guide_6 = findViewById(R.id.guide_6);
        guide_7 = findViewById(R.id.guide_7);
        guide_8 = findViewById(R.id.guide_8);
        guide_9 = findViewById(R.id.guide_1);
        guide_0 = findViewById(R.id.guide_0);
    }

    public void next(int count) {
        if (transMainPref.getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
            startActivity(new Intent(ui_c.this, service_a.class));
        } else {
            Intent intent = new Intent(ui_c.this, ui_a.class);
            intent.putExtra("counter", count);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
pro_sdk_i.ShowInterstitialAdsOnBack(this);
    }
}