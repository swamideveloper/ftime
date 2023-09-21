package com.fasetime.video.audio.sdk_main;

import static com.fasetime.video.audio.sdk_network.sdk_net_v.getGeoApiService;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.fasetime.video.audio.R;
import com.fasetime.video.audio.sdk_appscreen.sdk_app_c;
import com.fasetime.video.audio.sdk_appscreen.sdk_app_d;
import com.fasetime.video.audio.sdk_appscreen.sdk_app_f;
import com.fasetime.video.audio.sdk_appscreen.sdk_app_h;
import com.fasetime.video.audio.sdk_appscreen.sdk_app_i;
import com.fasetime.video.audio.sdk_pojo.sdk_pojo_a;
import com.fasetime.video.audio.sdk_pojo.sdk_pojo_b;
import com.fasetime.video.audio.sdk_pojo.sdk_pojo_d;
import com.fasetime.video.audio.sdk_pojo.sdk_pojo_e;
import com.fasetime.video.audio.in_app_design.ui_g;
import com.fasetime.video.audio.sdk_network.sdk_net_a;
import com.fasetime.video.audio.sdk_network.sdk_net_d;
import com.fasetime.video.audio.sdk_api.api_a;
import com.fasetime.video.audio.sdk_api.api_b;
import com.ff.guide.Speed_jitpack_compose.Trans_Aud_Id;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.mukesh_ads.pro_sdk_c;
import com.ff.guide.mukesh_ads.pro_sdk_g;
import com.ff.guide.mukesh_ads.pro_sdk_a;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sdk_main_c extends AppCompatActivity {

    public static Class activity_X;
    public boolean excludeChecker = false;
    public boolean includeChecker = false;
    List<sdk_pojo_d> mVar = new ArrayList<>();
    pro_sdk_c transMainPref;
    //verify
    String iType = "";
    int normal_Index = 0;
    int publisher_Index = 1;

    AlertDialog.Builder builder1;
    AlertDialog.Builder builder2;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.in_app_g);


        transMainPref = new pro_sdk_c(this);


        if (isNetworkConnected()) {
            api_b specialApiInterface = api_a.getClient().create(api_b.class);
            Call<sdk_pojo_a> call = specialApiInterface.getSdkData();
            call.enqueue(new Callback<sdk_pojo_a>() {
                @Override
                public void onResponse(Call<sdk_pojo_a> call, Response<sdk_pojo_a> response) {

                    mVar = response.body().getAppVariables();

                    sdk_pojo_e app_SFLoanSt = response.body().getSettings();
                    iType = app_SFLoanSt.getLocType();

                    if (iType.equalsIgnoreCase("include") || iType.equalsIgnoreCase("exclude")) {
                        verifyUser(app_SFLoanSt.getLocArray());
                    } else {
                        setVariables(normal_Index);
                    }

                }

                @Override
                public void onFailure(Call<sdk_pojo_a> call, Throwable t) {
                    //Log.e("@@Trans", "onFailure: " + t.getMessage());
                }
            });
        } else {
            checkNetworkConnection();
        }
    }


    private void setVariables(int varIndex) {
        transMainPref.setInterCnt(Integer.parseInt(mVar.get(varIndex).getIntersCnt()));
        transMainPref.setBack_cnt(Integer.parseInt(mVar.get(varIndex).getBackCnt()));
        transMainPref.setFB_app_id(mVar.get(varIndex).getFBAppId());
        transMainPref.setFB_inter(mVar.get(varIndex).getFBInter());
        transMainPref.setFB_native(mVar.get(varIndex).getFBNative());
        transMainPref.setFB_native_banner(mVar.get(varIndex).getFBNativeBanner());
        transMainPref.setFB_banner(mVar.get(varIndex).getFBBanner());
        transMainPref.setAmAppId(mVar.get(varIndex).getAMAppId());
        transMainPref.setAM_native(mVar.get(varIndex).getAMNative());
        transMainPref.setAM_inter(mVar.get(varIndex).getAMInter());
        transMainPref.setAM_banner(mVar.get(varIndex).getAMBanner());
        transMainPref.setAM_App_Open(mVar.get(varIndex).getAMAppOpen());
        transMainPref.setAM_Rectangele(mVar.get(varIndex).getAMRectangle());
        transMainPref.setDuo_Ads(mVar.get(varIndex).getDuo_Ads());
        transMainPref.setQureka_Inter(mVar.get(varIndex).getQureka_Inter());
        transMainPref.setQureka_Inter_Mode(mVar.get(varIndex).getQureka_Inter_Mode());
        transMainPref.setQureka_Inter_CloseTap(mVar.get(varIndex).getQureka_Inter_CloseTap());
        transMainPref.setQureka_Url(mVar.get(varIndex).getQureka_Url());
        transMainPref.setApp_Country(mVar.get(varIndex).getApp_Country());
        transMainPref.setApp_Privacy(mVar.get(varIndex).getApp_Privacy());
        transMainPref.setApp_Language(mVar.get(varIndex).getApp_Language());
        transMainPref.setApp_Permission(mVar.get(varIndex).getApp_Permission());
        transMainPref.setApp_Start(mVar.get(varIndex).getApp_Start());
        transMainPref.setApp_Thankyou(mVar.get(varIndex).getApp_Thankyou());
        transMainPref.setApp_Exit_Dialoge(mVar.get(varIndex).getApp_Exit_Dialoge());
        transMainPref.setIsLongApp(mVar.get(varIndex).getIsLongApp());
        transMainPref.setVideo_call(mVar.get(varIndex).getVideo_call());
        transMainPref.setIncoming_Welcome(mVar.get(varIndex).getIncoming_Welcome());
        transMainPref.setIncoming_Counter(mVar.get(varIndex).getIncoming_Counter());

        //ads & next
        pro_sdk_i.LoadInterstitialAds(sdk_main_c.this);
        Trans_Aud_Id.NativeAddLoad1(sdk_main_c.this);
        Trans_Aud_Id.NativeBannerAddLoad1(sdk_main_c.this);
        pro_sdk_g.LoadInterstitialAd(sdk_main_c.this);
        moveToAppOpen();
    }

    private void verifyUser(List<sdk_pojo_b> iArray) {
        sdk_net_d apiService = getGeoApiService();
        apiService.getLocation().enqueue(new Callback<sdk_net_a>() {
            @Override
            public void onResponse(Call<sdk_net_a> call, Response<sdk_net_a> response) {

                String uCountryCode = response.body().getCountryCode();
                String uStateCode = response.body().getRegion();
                String uCityName = response.body().getCity();


                switch (iType) {
                    case "include":
                        for (int k = 0; k < iArray.size(); k++) {
                            if (uCountryCode.equalsIgnoreCase(iArray.get(k).getCountryCode()) ||
                                    uStateCode.equalsIgnoreCase(iArray.get(k).getStateCode()) ||
                                    uCityName.equalsIgnoreCase(iArray.get(k).getCityName())) {
                                k = 999;
                                includeChecker = true;
                            }
                        }

                        if (includeChecker) {
                            setVariables(publisher_Index);
                            //Log.e("@@Trans", "exclude - Publisher...");
                        } else {
                            setVariables(normal_Index);
                            //Log.e("@@Trans", "exclude - Normal User...");
                        }
                        break;

                    case "exclude":
                        for (int j = 0; j < iArray.size(); j++) {
                            if (uCountryCode.equalsIgnoreCase(iArray.get(j).getCountryCode()) ||
                                    uStateCode.equalsIgnoreCase(iArray.get(j).getStateCode()) ||
                                    uCityName.equalsIgnoreCase(iArray.get(j).getCityName())) {
                                j = 999;
                                excludeChecker = true;
                            }
                        }

                        if (excludeChecker) {
                            setVariables(publisher_Index);
                            //Log.e("@@Trans", "include - Publisher...");
                        } else {
                            setVariables(normal_Index);
                            //Log.e("@@Trans", "include - Normal User...");
                        }
                        break;

                    default:
                        setVariables(normal_Index);
                        break;
                }
            }

            @Override
            public void onFailure(Call<sdk_net_a> call, Throwable t) {
                //Log.e("@@Trans", "user verify api issue: " + t.getMessage());
                setVariables(normal_Index);
            }
        });
    }

    private void moveToAppOpen() {
        new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                if (pro_sdk_g.isAdAvailable()) {
                    onFinish();
                    cancel();
                }
            }

            public void onFinish() {
                pro_sdk_g.ShowInterstitialAd(sdk_main_c.this, new pro_sdk_a() {
                    @Override
                    public void onAdsClose() {
                        loadAppScreen();
                    }
                });
            }

        }.start();
    }

    private void loadAppScreen() {

        activity_X = ui_g.class;

        if (transMainPref.getApp_Country().equalsIgnoreCase("on")) {
            Intent i = new Intent(sdk_main_c.this, sdk_app_c.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (transMainPref.getApp_Privacy().equalsIgnoreCase("on")) {
            Intent i = new Intent(sdk_main_c.this, sdk_app_d.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (transMainPref.getApp_Language().equalsIgnoreCase("on")) {
            Intent i = new Intent(sdk_main_c.this, sdk_app_h.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (transMainPref.getApp_Permission().equalsIgnoreCase("on")) {
            Intent i = new Intent(sdk_main_c.this, sdk_app_i.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else if (transMainPref.getApp_Start().equalsIgnoreCase("on")) {
            Intent i = new Intent(sdk_main_c.this, sdk_app_f.class);
            i.putExtra("app_inter", false);
            startActivity(i);
        } else {
            Intent i = new Intent(sdk_main_c.this, activity_X);
            i.putExtra("app_inter", false);
            startActivity(i);
        }
    }

    public boolean isDevMode() {
        if (Integer.valueOf(android.os.Build.VERSION.SDK) == 16) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(), android.provider.Settings.Secure.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0;
        } else if (Integer.valueOf(android.os.Build.VERSION.SDK) >= 17) {
            return android.provider.Settings.Secure.getInt(getApplicationContext().getContentResolver(), android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0;
        } else return false;
    }


    public void checkNetworkConnection() {
        builder2 = new AlertDialog.Builder(this);
        builder2.setCancelable(false);
        builder2.setTitle("No internet Connection");
        builder2.setMessage("Please turn on internet connection to continue!");
        builder2.setPositiveButton("Turn On", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                sdk_main_c.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                sdk_main_c.this.finish();
            }
        }).show();
        builder2.setNegativeButton("Exit", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {
                sdk_main_c.this.finishAffinity();
            }
        }).show();
        builder2.create().show();
    }


    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
