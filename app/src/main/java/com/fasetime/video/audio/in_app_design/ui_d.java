package com.fasetime.video.audio.in_app_design;

import static com.fasetime.video.audio.in_app_design.ui_g.incoming_counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.fasetime.video.audio.R;
import com.fasetime.video.audio.in_app_call_service.service_a;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;

public class ui_d extends AppCompatActivity {

    private AppCompatButton gender_next;
    private LinearLayout ll_male, ll_female;
    private ImageView chk_male, chk_female;
    private boolean checker = false;
    pro_sdk_c transMainPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_d);

        incoming_counter++;
        transMainPref = new pro_sdk_c(this);


        pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.big_native));


        gender_next = findViewById(R.id.gender_next);
        ll_male = findViewById(R.id.ll_male);
        ll_female = findViewById(R.id.ll_female);
        chk_male = findViewById(R.id.chk_male);
        chk_female = findViewById(R.id.chk_female);

        ll_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = true;
                chk_male.setImageResource(R.drawable.check);
                chk_female.setImageResource(R.drawable.uncheck);
            }
        });

        ll_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = true;
                chk_male.setImageResource(R.drawable.uncheck);
                chk_female.setImageResource(R.drawable.check);
            }
        });

        gender_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker) {
                    if (transMainPref.getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                        startActivity(new Intent(ui_d.this, service_a.class));
                    } else {
                        startActivity(new Intent(ui_d.this, ui_f.class));
                    }
                } else {
                    Toast.makeText(ui_d.this, "select gender first!", Toast.LENGTH_SHORT).show();
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