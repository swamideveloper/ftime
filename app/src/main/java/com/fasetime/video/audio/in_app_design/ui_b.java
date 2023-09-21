package com.fasetime.video.audio.in_app_design;

import static com.fasetime.video.audio.in_app_design.ui_g.incoming_counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.fasetime.video.audio.R;
import com.fasetime.video.audio.in_app_call_service.service_a;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;

public class ui_b extends AppCompatActivity {

    LinearLayout videocall, videocall_advice;
    pro_sdk_c transMainPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_c);

        incoming_counter++;
        transMainPref = new pro_sdk_c(this);

        
        pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.big_native));


        videocall = findViewById(R.id.videocall);
        videocall_advice = findViewById(R.id.videocall_advice);

        videocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (transMainPref.getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                    startActivity(new Intent(ui_b.this, service_a.class));
                } else {
                    startActivity(new Intent(ui_b.this, ui_e.class));
                }
            }
        });


        videocall_advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (transMainPref.getIncoming_Counter().equalsIgnoreCase("on")) {
                    startActivity(new Intent(ui_b.this, service_a.class));
                } else {
                    startActivity(new Intent(ui_b.this, ui_c.class));
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
pro_sdk_i.ShowInterstitialAdsOnBack(this);
    }
}