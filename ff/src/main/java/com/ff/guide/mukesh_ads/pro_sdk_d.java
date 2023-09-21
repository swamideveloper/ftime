package com.ff.guide.mukesh_ads;

import android.app.Activity;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.ff.guide.pro_sdk_mBit;
import com.ff.guide.Speed_jitpack_compose.pro_sdk_i;
import com.ff.guide.pro_sdk_k;

import static androidx.lifecycle.Lifecycle.Event.ON_START;

public class pro_sdk_d implements LifecycleObserver {

    private static pro_sdk_c transMainPref;
    public static AppOpenAd appOpenAd = null;
    public static Activity currentActivity;
    public static boolean isShowingAd = false;
    public static AppOpenAd.AppOpenAdLoadCallback loadCallback;
    private final pro_sdk_mBit myApplication;

    public pro_sdk_d(pro_sdk_mBit myApplication) {
        this.myApplication = myApplication;
        this.transMainPref = new pro_sdk_c(myApplication);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public static void fetchAds(Activity activity) {
        if (isAdAvailable()) {
            return;
        }
        loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull AppOpenAd ad) {
                //Log.e("@@Trans_ManageBeta", "Loaded");
                appOpenAd = ad;
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                //Log.e("@@Trans_ManageBeta", "Error: " + loadAdError.toString());
            }
        };
        AppOpenAd.load(activity, transMainPref.getAM_App_Open(), new AdRequest.Builder().build(),
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }

    public static void showAdIfAvailableAds(Activity activity, pro_sdk_k onInterCloseCallBack) {
        if (pro_sdk_i.Strcheckad.equalsIgnoreCase("StrClosed") && !isShowingAd && isAdAvailable()) {
            FullScreenContentCallback fullScreenContentCallback =
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            //Log.e("@@Trans_ManageBeta", "AdDismissedFullScreenContent");
                            appOpenAd = null;
                            isShowingAd = false;
                            fetchAds(activity);
                            pro_sdk_i.Strcheckad = "StrClosed";
                            onInterCloseCallBack.onAdsClose();
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            //Log.e("@@Trans_ManageBeta", "AdFailedToShowFullScreenContent" + adError.toString());
                            pro_sdk_i.Strcheckad = "StrClosed";
                            onInterCloseCallBack.onAdsClose();
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            //Log.e("@@Trans_ManageBeta", "AdShowedFullScreenContent");
                            pro_sdk_i.Strcheckad = "StrOpen";
                            isShowingAd = true;
                        }
                    };
            appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
            appOpenAd.show(currentActivity);
        } else {
            onInterCloseCallBack.onAdsClose();
            fetchAds(activity);
        }
    }

    public static boolean isAdAvailable() {
        return appOpenAd != null;
    }

    public static void clearInstance() {
        currentActivity = null;
        isShowingAd = false;
        appOpenAd = null;
    }

    @OnLifecycleEvent(ON_START)
    public void onStart() {
        showAdIfAvailable();
    }

    private void fetchAd() {
        if (isAdAvailable()) {
            return;
        }
        loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull AppOpenAd ad) {
                //Log.e("@@Trans_ManageBeta", "Loaded");
                appOpenAd = ad;
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                //Log.e("@@Trans_ManageBeta", "Error: " + loadAdError.toString());
                appOpenAd = null;
            }
        };
        AppOpenAd.load(myApplication, transMainPref.getAM_App_Open(), new AdRequest.Builder().build(),
                AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }

    private void showAdIfAvailable() {
        if (pro_sdk_i.Strcheckad.equalsIgnoreCase("StrClosed") && !isShowingAd && isAdAvailable()) {
            FullScreenContentCallback fullScreenContentCallback =
                    new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            //Log.e("@@Trans_ManageBeta", "AdDismissedFullScreenContent");
                            appOpenAd = null;
                            isShowingAd = false;
                            fetchAd();
                            pro_sdk_i.Strcheckad = "StrClosed";
                        }

                        @Override
                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                            //Log.e("@@Trans_ManageBeta", "AdFailedToShowFullScreenContent" + adError.toString());
                            pro_sdk_i.Strcheckad = "StrClosed";
                        }

                        @Override
                        public void onAdShowedFullScreenContent() {
                            //Log.e("@@Trans_ManageBeta", "AdShowedFullScreenContent");
                            pro_sdk_i.Strcheckad = "StrOpen";
                            isShowingAd = true;
                        }
                    };
            appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
            appOpenAd.show(currentActivity);
        } else {
            new Handler().postDelayed(() -> {
                //Log.e("@@SplashBeta", " - fetchAd going");
                fetchAd();
            }, 1500);
        }
    }
}