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

public class ui_e extends AppCompatActivity {

    private LinearLayout room1, room2, room3, room4;
    pro_sdk_c transMainPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_f);

        incoming_counter++;
        transMainPref = new pro_sdk_c(this);
        
        pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.big_native));


        room1 = findViewById(R.id.room1);
        room2 = findViewById(R.id.room2);
        room3 = findViewById(R.id.room3);
        room4 = findViewById(R.id.room4);

        room1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
        room4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });
    }

    private void next() {
        if (transMainPref.getIncoming_Counter().equalsIgnoreCase("on")) {
            startActivity(new Intent(ui_e.this, service_a.class));
        } else {
            startActivity(new Intent(ui_e.this, service_b.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
pro_sdk_i.ShowInterstitialAdsOnBack(this);
    }
}