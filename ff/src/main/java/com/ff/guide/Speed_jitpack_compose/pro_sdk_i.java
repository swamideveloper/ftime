package com.ff.guide.Speed_jitpack_compose;

import android.app.Activity;
import android.content.Context;

import com.ff.guide.mukesh_ads.pro_sdk_f;
import com.ff.guide.mukesh_ads.pro_sdk_c;
import com.ff.guide.pro_sdk_s;

import java.util.Arrays;
import java.util.List;

public class pro_sdk_i {
    public static String Strcheckad = "StrClosed";
    public static List<String> TestDeviceFB = Arrays.asList("53a3f7a8-b5ca-4054-be2f-9a7e06eaeeff");
    public static List<String> TestDeviceID = Arrays.asList(
            "FF8C3E217FCFC3F61610E14A420DEC2D",
            "018CA95DDE421581B68674E0640DC383",
            "95156D8543D9421D5FFE4F73EAF2C32E",
            "29471F7796C9694ABF9C23412BE1F80C",
            "FB1D7434FFFF94297066072DDCEF6333");

    public static int classSelection = 0;
    public static int AdsCounter = 0;

    public static pro_sdk_s pro_sdk_s;

    public static void LoadInterstitialAds(Context context) {
        pro_sdk_j.LoadInterstitialAd(context);
        pro_sdk_h.LoadInterstitialAd(context);
    }

    public static void ShowInterstitialAdsOnCreate(Context context) {
        pro_sdk_c transMainPref = new pro_sdk_c(context);
        if (AdsCounter % transMainPref.getInter_count() == 0) {
            if (classSelection == 0) {
                classSelection = 1;
                pro_sdk_j.ShowInterstitialAd(context, () -> {
                    if (transMainPref.getDuo_Ads().equalsIgnoreCase("on")) {
                        //Log.e("@@TAG", "duo ads: ");
                        pro_sdk_f.showQurekaInter(context);
                    }
                });
            } else if (classSelection == 1) {
                classSelection = 0;
                pro_sdk_h.ShowInterstitialAd(context, () -> {
                    if (transMainPref.getDuo_Ads().equalsIgnoreCase("on")) {
                        //Log.e("@@TAG", "duo ads: ");
                        pro_sdk_f.showQurekaInter(context);
                    }
                });
            }
        }
        AdsCounter++;
    }

    public static void ShowInterstitialAdsWithListener(final Activity SourceActivity, final pro_sdk_s mListener) {
        pro_sdk_c transMainPref = new pro_sdk_c(SourceActivity);
        if (AdsCounter % transMainPref.getInter_count() == 0) {
            if (classSelection == 0) {
                classSelection = 1;

                pro_sdk_j.ShowInterstitialAd(SourceActivity, () -> {
                    pro_sdk_s = mListener;
                    pro_sdk_s.onInterClose();
//                    Intent localIntent = new Intent(SourceActivity, DestinationClass);
//                    SourceActivity.startActivity(localIntent);
                });

            } else if (classSelection == 1) {
                classSelection = 0;
                pro_sdk_h.ShowInterstitialAd(SourceActivity, () -> {
                    pro_sdk_s = mListener;
                    pro_sdk_s.onInterClose();
//                    Intent localIntent = new Intent(SourceActivity, DestinationClass);
//                    SourceActivity.startActivity(localIntent);
                });
            }
        }
        AdsCounter++;
    }

    public static void ShowInterstitialAdsOnBack(Context context) {
        pro_sdk_c transMainPref = new pro_sdk_c(context);
        if (AdsCounter % transMainPref.getBack_cnt() == 0) {
            if (classSelection == 0) {
                classSelection = 1;
                pro_sdk_j.ShowInterstitialAd(context, () -> {
                    ((Activity) context).finish();
                });
            } else if (classSelection == 1) {
                classSelection = 0;
                pro_sdk_h.ShowInterstitialAd(context, () -> {
                    ((Activity) context).finish();
                });
            }
        }
        AdsCounter++;
    }
}
