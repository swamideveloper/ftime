package com.ff.guide.mukesh_ads;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;

public class pro_sdk_g {
    private static Context mContext;
    private static pro_sdk_a adsListener1;
    private static AppOpenAd openAd;
    private static boolean isShowingAd = false;
    public static pro_sdk_c transMainPref;

    public static void LoadInterstitialAd(Context context) {
        transMainPref = new pro_sdk_c(context);
        try {
            mContext = context;
            displayAdMobBetaAd();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void displayAdMobBetaAd() {
        try {
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                @Override
                public void onAdLoaded(AppOpenAd ad) {
                    //Log.e("AdmobBetaFive", "SP Loaded- ");
                    openAd = ad;
                }

                @Override
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    //Log.e("AdmobBetaFive", "SP Error- " + loadAdError.toString());
                }
            };
            final AdRequest adRequest = new AdRequest.Builder().build();
            AppOpenAd.load(mContext, transMainPref.getAM_App_Open(), adRequest, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
        } catch (Exception e) {
            //Log.e("AdmobBetaFive: ", e.getMessage());
            e.printStackTrace();
        }
    }

    public static void ShowInterstitialAd(Context context, pro_sdk_a interstitialAdsListener1) {
        mContext = context;
        adsListener1 = interstitialAdsListener1;
        if (!isShowingAd && isAdAvailable()) {
            //Log.e("AdmobBetaFive", "SP Show- ");
            FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    openAd = null;
                    isShowingAd = false;
                    adsListener1.onAdsClose();
                    pro_sdk_i.Strcheckad = "StrClosed";
                }

                @Override
                public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                    adsListener1.onAdsClose();
                    pro_sdk_i.Strcheckad = "StrClosed";
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    isShowingAd = true;
                    pro_sdk_i.Strcheckad = "StrOpen";
                }
            };
            openAd.setFullScreenContentCallback(fullScreenContentCallback);
            openAd.show((Activity) mContext);
        } else {
            adsListener1.onAdsClose();
        }
    }

    public static boolean isAdAvailable() {
        //Log.e("isAdAvailable: ", "");
        return openAd != null;
    }
}
