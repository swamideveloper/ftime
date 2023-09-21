package com.fasetime.video.audio.in_app_design;

import static com.fasetime.video.audio.in_app_design.ui_g.incoming_counter;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fasetime.video.audio.R;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.pro_sdk_s;


public class ui_a extends AppCompatActivity {

    TextView tv_description, tv_title;
    int counter;
    RelativeLayout rl_7, rl_8, rl_9, rl_10, rl_11, rl_12, rl_13, rl_14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_app_a);


        pro_sdk_i.ShowInterstitialAdsOnCreate(this);
        Trans_Aud_Id.NativeAddShow(this, findViewById(R.id.big_native));


        init();

    }

    public void init() {

        counter = getIntent().getIntExtra("counter", 0);

        tv_description = findViewById(R.id.tv_description);
        tv_title = findViewById(R.id.tv_title);
        rl_7 = findViewById(R.id.rl_7);
        rl_8 = findViewById(R.id.rl_8);
        rl_9 = findViewById(R.id.rl_9);
        rl_10 = findViewById(R.id.rl_10);
        rl_11 = findViewById(R.id.rl_11);
        rl_12 = findViewById(R.id.rl_12);
        rl_13 = findViewById(R.id.rl_13);
        rl_14 = findViewById(R.id.rl_14);

        if (counter == 0) {
            rl_7.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_1);
            tv_title.setText(R.string.title_1);
        } else if (counter == 1) {
            rl_7.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_1);
            tv_title.setText(R.string.title_1);
        } else if (counter == 2) {
            rl_8.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_2);
            tv_title.setText(R.string.title_2);
        } else if (counter == 3) {
            rl_9.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_3);
            tv_title.setText(R.string.title_3);
        } else if (counter == 4) {
            rl_10.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_4);
            tv_title.setText(R.string.title_4);
        } else if (counter == 5) {
            rl_11.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_5);
            tv_title.setText(R.string.title_5);
        } else if (counter == 6) {
            rl_12.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_6);
            tv_title.setText(R.string.title_6);
        } else if (counter == 7) {
            rl_13.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_7);
            tv_title.setText(R.string.title_7);
        } else if (counter == 8) {
            rl_14.setVisibility(View.GONE);
            tv_description.setText(R.string.advice_8);
            tv_title.setText(R.string.title_8);
        }


        rl_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pro_sdk_i.ShowInterstitialAdsWithListener(ui_a.this, new pro_sdk_s() {
                    @Override
                    public void onInterClose() {
                        incoming_counter++;
                        rl_7.setVisibility(View.GONE);
                        rl_8.setVisibility(View.VISIBLE);
                        rl_9.setVisibility(View.VISIBLE);
                        rl_10.setVisibility(View.VISIBLE);
                        rl_11.setVisibility(View.VISIBLE);
                        rl_12.setVisibility(View.VISIBLE);
                        rl_13.setVisibility(View.VISIBLE);
                        rl_14.setVisibility(View.VISIBLE);
                        tv_description.setText(R.string.advice_1);
                        tv_title.setText(R.string.title_1);
                    }
                });

            }
        });
        rl_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pro_sdk_i.ShowInterstitialAdsWithListener(ui_a.this, new pro_sdk_s() {
                    @Override
                    public void onInterClose() {
                        rl_8.setVisibility(View.GONE);
                        rl_7.setVisibility(View.VISIBLE);
                        rl_9.setVisibility(View.VISIBLE);
                        rl_10.setVisibility(View.VISIBLE);
                        rl_11.setVisibility(View.VISIBLE);
                        rl_12.setVisibility(View.VISIBLE);
                        rl_13.setVisibility(View.VISIBLE);
                        rl_14.setVisibility(View.VISIBLE);
                        tv_description.setText(R.string.advice_2);
                        tv_title.setText(R.string.title_2);
                    }
                });


            }
        });
        rl_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                pro_sdk_i.ShowInterstitialAdsWithListener(ui_a.this, new pro_sdk_s() {
                    @Override
                    public void onInterClose() {
                        rl_9.setVisibility(View.GONE);
                        rl_7.setVisibility(View.VISIBLE);
                        rl_8.setVisibility(View.VISIBLE);
                        rl_10.setVisibility(View.VISIBLE);
                        rl_11.setVisibility(View.VISIBLE);
                        rl_12.setVisibility(View.VISIBLE);
                        rl_13.setVisibility(View.VISIBLE);
                        rl_14.setVisibility(View.VISIBLE);
                        tv_description.setText(R.string.advice_3);
                        tv_title.setText(R.string.title_3);
                    }
                });


            }
        });
        rl_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro_sdk_i.ShowInterstitialAdsWithListener(ui_a.this, new pro_sdk_s() {
                    @Override
                    public void onInterClose() {
                        rl_10.setVisibility(View.GONE);
                        rl_7.setVisibility(View.VISIBLE);
                        rl_8.setVisibility(View.VISIBLE);
                        rl_9.setVisibility(View.VISIBLE);
                        rl_11.setVisibility(View.VISIBLE);
                        rl_12.setVisibility(View.VISIBLE);
                        rl_13.setVisibility(View.VISIBLE);
                        rl_14.setVisibility(View.VISIBLE);
                        tv_description.setText(R.string.advice_4);
                        tv_title.setText(R.string.title_4);
                    }
                });

            }
        });
        rl_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pro_sdk_i.ShowInterstitialAdsWithListener(ui_a.this, new pro_sdk_s() {
                    @Override
                    public void onInterClose() {
                        rl_11.setVisibility(View.GONE);
                        rl_7.setVisibility(View.VISIBLE);
                        rl_8.setVisibility(View.VISIBLE);
                        rl_9.setVisibility(View.VISIBLE);
                        rl_10.setVisibility(View.VISIBLE);
                        rl_12.setVisibility(View.VISIBLE);
                        rl_13.setVisibility(View.VISIBLE);
                        rl_14.setVisibility(View.VISIBLE);
                        tv_description.setText(R.string.advice_5);
                        tv_title.setText(R.string.title_5);
                    }
                });

            }
        });
        rl_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro_sdk_i.ShowInterstitialAdsWithListener(ui_a.this, new pro_sdk_s() {
                    @Override
                    public void onInterClose() {
                        rl_12.setVisibility(View.GONE);
                        rl_7.setVisibility(View.VISIBLE);
                        rl_8.setVisibility(View.VISIBLE);
                        rl_9.setVisibility(View.VISIBLE);
                        rl_10.setVisibility(View.VISIBLE);
                        rl_11.setVisibility(View.VISIBLE);
                        rl_13.setVisibility(View.VISIBLE);
                        rl_14.setVisibility(View.VISIBLE);
                        tv_description.setText(R.string.advice_6);
                        tv_title.setText(R.string.title_6);
                    }
                });

            }
        });
        rl_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro_sdk_i.ShowInterstitialAdsWithListener(ui_a.this, new pro_sdk_s() {
                    @Override
                    public void onInterClose() {
                        rl_13.setVisibility(View.GONE);
                        rl_7.setVisibility(View.VISIBLE);
                        rl_8.setVisibility(View.VISIBLE);
                        rl_9.setVisibility(View.VISIBLE);
                        rl_10.setVisibility(View.VISIBLE);
                        rl_11.setVisibility(View.VISIBLE);
                        rl_12.setVisibility(View.VISIBLE);
                        rl_14.setVisibility(View.VISIBLE);
                        tv_description.setText(R.string.advice_7);
                        tv_title.setText(R.string.title_7);
                    }
                });

            }
        });
        rl_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro_sdk_i.ShowInterstitialAdsWithListener(ui_a.this, new pro_sdk_s() {
                    @Override
                    public void onInterClose() {
                        rl_14.setVisibility(View.GONE);
                        rl_7.setVisibility(View.VISIBLE);
                        rl_8.setVisibility(View.VISIBLE);
                        rl_9.setVisibility(View.VISIBLE);
                        rl_10.setVisibility(View.VISIBLE);
                        rl_11.setVisibility(View.VISIBLE);
                        rl_12.setVisibility(View.VISIBLE);
                        rl_13.setVisibility(View.VISIBLE);
                        tv_description.setText(R.string.advice_8);
                        tv_title.setText(R.string.title_8);
                    }
                });

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        pro_sdk_i.ShowInterstitialAdsOnBack(this);
    }
}