package com.ff.guide.mukesh_ads;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.ff.guide.R;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class pro_sdk_b extends Dialog {

    TextView header, bodytxt, tvTimer, ad_advertiser;
    GifImageView gifImageView;
    ImageView banner;
    CardView ImgClose, cardViewBg, cc;
    Button playgame;
    ProgressBar progressBarCircle;
    RelativeLayout rlClose, rlClose2;
    static int uniqNo;
    static int uniqNoRes;
    Context context;
    boolean layoutRandom;
    pro_sdk_c transMainPref;
    ImageView mLogo, mBanner;
    TextView mText;
    TextView mText1;
    TextView mText2;
    TextView ivThum;
    LinearLayout lll;


    public pro_sdk_b(@NonNull Context context) {
        super(context, R.style.fulldialog);
        this.context = context;
        uniqNo = new Random().nextInt(14);
//        uniqNoRes = new Random().nextInt(9);
        layoutRandom = new Random().nextBoolean();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        String[] headers = context.getResources().getStringArray(R.array.header);
        String[] bodys = context.getResources().getStringArray(R.array.body);
        int[] circles = {R.drawable.q1, R.drawable.q2, R.drawable.q3, R.drawable.q4, R.drawable.q5, R.drawable.q6, R.drawable.q7, R.drawable.q8, R.drawable.q9, R.drawable.q10};
        int[] banners = {R.drawable.b1, R.drawable.b2, R.drawable.b3, R.drawable.b4, R.drawable.b5, R.drawable.b6, R.drawable.b7, R.drawable.b8, R.drawable.b9, R.drawable.b10};

        uniqNoRes = new Random().nextInt(circles.length);

        transMainPref = new pro_sdk_c(context);
        if (layoutRandom) {
            this.setContentView(R.layout.qureka_inter_one);


            Animation logoanim = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_top);
            Animation banner = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_bottom);
            Animation textbb = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_bottom);
            Animation playtxt = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_bottombtnlst);
            Animation slide_downtext = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_bottomtext);
            mLogo = findViewById(R.id.mLogo);
            mText = findViewById(R.id.mText);
            mText1 = findViewById(R.id.mText1);
            mText2 = findViewById(R.id.mText2);
            ivThum = findViewById(R.id.ivThum);
            cc = findViewById(R.id.cc);
            mBanner = findViewById(R.id.mBanner);
            rlClose = findViewById(R.id.rlClose);
            mText.setText(headers[uniqNoRes]);
            mText2.setText(bodys[uniqNoRes]);
            mBanner.setImageResource(banners[uniqNoRes]);
            mLogo.setImageResource(circles[uniqNoRes]);

            logoanim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {


                }

                @Override
                public void onAnimationEnd(Animation animation) {


                    mText.setVisibility(View.VISIBLE);
                    /* Create an Intent that will start the Menu-Activity. */
                    mText.startAnimation(slide_downtext);


                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            mLogo.startAnimation(logoanim);
            slide_downtext.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mBanner.setVisibility(View.VISIBLE);
                            /* Create an Intent that will start the Menu-Activity. */
                            mBanner.startAnimation(banner);
                            mText2.setVisibility(View.VISIBLE);
                            /* Create an Intent that will start the Menu-Activity. */
                            mText2.startAnimation(banner);


                        }
                    }, 300);


                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mText1.setVisibility(View.VISIBLE);
                    mText1.startAnimation(textbb);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            textbb.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ivThum.setVisibility(View.VISIBLE);
                            ivThum.startAnimation(playtxt);

                            rlClose.setVisibility(View.VISIBLE);

                        }
                    }, 300);
                }

                @Override
                public void onAnimationEnd(Animation animation) {


                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            rlClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (transMainPref.getQureka_Inter_CloseTap().equalsIgnoreCase("on")) {
                        dismiss();
                        CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                        customIntent.setToolbarColor(ContextCompat.getColor(context, R.color.chormecolor));
                        openCustomTab(context, customIntent.build(), Uri.parse(transMainPref.getQureka_Url()));
                    } else {
                        dismiss();
                    }
                }
            });


            cc.setOnClickListener(new pro_sdk_e() {
                @Override
                public void performClick(View v) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dismiss();
                        }
                    }, 1000);
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(context, R.color.chormecolor));
                    openCustomTab(context, customIntent.build(), Uri.parse(transMainPref.getQureka_Url()));
                }
            });

        } else {
            this.setContentView(R.layout.qureka_inter_two);
            mLogo = findViewById(R.id.ddd);
            mText = findViewById(R.id.mText2);
            mText1 = findViewById(R.id.mText1);
            mText2 = findViewById(R.id.mText2);
            ivThum = findViewById(R.id.ivThum);
            cc = findViewById(R.id.cc);
            mBanner = findViewById(R.id.mBanner);
            rlClose2 = findViewById(R.id.rlClose);
            lll = findViewById(R.id.lll);
            Animation leftslide = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
            Animation rightslide = AnimationUtils.loadAnimation(getContext(), R.anim.slide_right);
            Animation fadein = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
            Animation playtxt = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_bottombtnlst);
            mText.setText(headers[uniqNoRes]);
            mText2.setText(bodys[uniqNoRes]);
            mLogo.setImageResource(circles[uniqNoRes]);
            mBanner.setImageResource(banners[uniqNoRes]);
            mLogo.setAnimation(leftslide);
            lll.setAnimation(rightslide);
            rightslide.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    mBanner.setVisibility(View.VISIBLE);
                    mText2.setVisibility(View.VISIBLE);

                    mBanner.startAnimation(fadein);
                    mText2.startAnimation(fadein);

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    ivThum.setVisibility(View.VISIBLE);
                    ivThum.startAnimation(playtxt);
                    rlClose2.setVisibility(View.VISIBLE);

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            rlClose2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (transMainPref.getQureka_Inter_CloseTap().equalsIgnoreCase("on")) {
                        dismiss();
                        CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                        customIntent.setToolbarColor(ContextCompat.getColor(context, R.color.chormecolor));
                        openCustomTab(context, customIntent.build(), Uri.parse(transMainPref.getQureka_Url()));
                    } else {
                        dismiss();
                    }
                }
            });
            cc.setOnClickListener(new pro_sdk_e() {
                @Override
                public void performClick(View v) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            dismiss();
                        }
                    }, 1000);
                    CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                    customIntent.setToolbarColor(ContextCompat.getColor(context, R.color.chormecolor));
                    openCustomTab(context, customIntent.build(), Uri.parse(transMainPref.getQureka_Url()));
                }
            });
        }

    }

    @Override
    public void dismiss() {
        super.dismiss();
//        Strcheckad = "StrClosed";
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    public void show() {
        super.show();
//        Strcheckad = "StrOpen";
    }

    public static void openCustomTab(Context activity, CustomTabsIntent customTabsIntent, Uri uri) {
        String packageName = "com.android.chrome";
        if (packageName != null) {
            customTabsIntent.intent.setPackage(packageName);
            customTabsIntent.launchUrl(activity, uri);
        } else {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }
}
