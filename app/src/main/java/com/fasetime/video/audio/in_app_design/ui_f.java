package com.fasetime.video.audio.in_app_design;

import static com.fasetime.video.audio.in_app_design.ui_g.incoming_counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.fasetime.video.audio.R;
import com.fasetime.video.audio.in_app_call_service.service_a;

import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;

public class ui_f extends AppCompatActivity {

    private AppCompatButton age_next;
    private RadioButton r1, r2, r3;
    private RadioGroup radioGroup;
    pro_sdk_c transMainPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_b);

        incoming_counter++;
        transMainPref = new pro_sdk_c(this);

        
        pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.big_native));


        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        radioGroup = findViewById(R.id.radioGroup);
        age_next = findViewById(R.id.age_next);

        age_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (transMainPref.getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                    startActivity(new Intent(ui_f.this, service_a.class));
                } else {
                    startActivity(new Intent(ui_f.this, ui_b.class));
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