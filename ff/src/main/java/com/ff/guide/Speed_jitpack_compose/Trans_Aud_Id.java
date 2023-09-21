package com.ff.guide.Speed_jitpack_compose;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.ff.guide.R;
import com.ff.guide.mukesh_ads.Speed_Android_NAd_Temp;
import com.ff.guide.mukesh_ads.pro_sdk_c;
import com.ff.guide.databinding.AdUnitAdmobMedBinding;
import com.ff.guide.databinding.AdUnitAdmobSmallBinding;
import com.ff.guide.databinding.AdsAmActivityNativeAdsTempBinding;
import com.ff.guide.databinding.FbSdkDefaultAdsContainer1Binding;
import com.ff.guide.databinding.FbSdkDefaultAdsContainerBinding;
import com.ff.guide.databinding.SdkDefaultAdsContainer1Binding;
import com.ff.guide.databinding.SdkDefaultAdsContainerBinding;


public class Trans_Aud_Id {

    public static pro_sdk_c shared;

    //    Native Banner Ads
    static NativeBannerAd nativeBannerAd1;
    static NativeBannerAd nativeBannerAd2;

    static com.google.android.gms.ads.nativead.NativeAd unifiedNativeBannerAd1;
    static com.google.android.gms.ads.AdView adViewNativeBanner1;

    static com.google.android.gms.ads.nativead.NativeAd unifiedNativeBannerAd2;
    static com.google.android.gms.ads.AdView adViewNativeBanner2;

    //========================================================= Native Ads Code ===================================================
//    Native Ads Code
    static NativeAd nativeAd1;
    static NativeAd nativeAd2;
    static com.google.android.gms.ads.nativead.NativeAd unifiedNativeAd1;
    static com.google.android.gms.ads.nativead.NativeAd unifiedNativeAd2;
    static com.google.android.gms.ads.AdView adViewAM1;
    static com.google.android.gms.ads.AdView adViewAM2;
    static AdView adView1;
    static AdView adView2;

    public static void NativeAddLoad1(final Context context) {
        shared = new pro_sdk_c(context);
        try {

            nativeAd1 = new NativeAd(context, shared.getFB_native());
            nativeAd1.loadAd(nativeAd1.buildLoadAdConfig()
                    .withAdListener(new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {

                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            //Log.e("NativeAds1", "Native adError -> " + adError.getErrorMessage());
                            try {
                                nativeAd1 = null;
                                adView1 = new AdView(context, shared.getFB_banner(), AdSize.RECTANGLE_HEIGHT_250);
                                adView1.loadAd(adView1.buildLoadAdConfig().withAdListener(new AdListener() {
                                    @Override
                                    public void onError(Ad ad, AdError adError) {
                                        adView1 = null;
                                        //Log.e("NativeAds1", "Rec adError -> " + adError.getErrorMessage());
                                        try {
                                            AdLoader.Builder builder = new AdLoader.Builder(context, shared.getAM_native());

                                            builder.forNativeAd(_unifiedNativeAd -> {
                                                //Log.e("NativeAds1", "AM Native Loaded -> ");
                                                unifiedNativeAd1 = _unifiedNativeAd;
                                            });

                                            AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() {
                                                @Override
                                                public void onAdFailedToLoad(LoadAdError adError) {
                                                    //Log.e("NativeAds1", "AM Native adError -> " + adError.getMessage());
                                                    unifiedNativeAd1 = null;
                                                    adViewAM1 = new com.google.android.gms.ads.AdView(context);
                                                    adViewAM1.setAdUnitId(shared.getAM_Rectangele());
                                                    adViewAM1.setAdSize(com.google.android.gms.ads.AdSize.MEDIUM_RECTANGLE);
                                                    adViewAM1.loadAd(new AdRequest.Builder().build());
                                                    adViewAM1.setAdListener(new com.google.android.gms.ads.AdListener() {
                                                        @Override
                                                        public void onAdLoaded() {
                                                            super.onAdLoaded();
                                                            //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 Loaded -> 1");
                                                            // Code to be executed when an ad finishes loading.
                                                        }

                                                        @Override
                                                        public void onAdFailedToLoad(LoadAdError adError) {
                                                            // Code to be executed when an ad request fails.
                                                            //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 adError -> 1" + adError.toString());
                                                            adViewAM1 = null;
                                                        }

                                                        @Override
                                                        public void onAdImpression() {
                                                            //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 onAdImpression1: Yes");
                                                            super.onAdImpression();
                                                        }
                                                    });

                                                }

                                                @Override
                                                public void onAdImpression() {
                                                    //Log.e("@@TAG", "Native onAdImpression1: Yes");
                                                    unifiedNativeAd1 = null;
                                                    super.onAdImpression();
                                                }

                                                @Override
                                                public void onAdLoaded() {
                                                    //Log.e("@@TAG", "Native onAdLoaded1: Yes");
                                                    super.onAdLoaded();
                                                }
                                            }).build();
                                            adLoader.loadAd(new AdRequest.Builder().build());
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {

                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {

                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {

                                    }
                                }).build());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            //Log.e("@@Ads", "onAdLoaded + Native");
                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                        }
                    })
                    .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void NativeAddLoad2(final Context context) {
        shared = new pro_sdk_c(context);
        try {

            nativeAd2 = new NativeAd(context, shared.getFB_native());
            nativeAd2.loadAd(nativeAd2.buildLoadAdConfig()
                    .withAdListener(new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {

                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            try {
                                //Log.e("NativeAds2", "Native adError -> " + adError.getErrorMessage());
                                nativeAd2 = null;
                                adView2 = new AdView(context, shared.getFB_banner(), AdSize.RECTANGLE_HEIGHT_250);
                                adView2.loadAd(adView2.buildLoadAdConfig().withAdListener(new AdListener() {
                                    @Override
                                    public void onError(Ad ad, AdError adError) {
                                        adView2 = null;
                                        //Log.e("NativeAds2", "Rec adError -> " + adError.getErrorMessage());
                                        try {
                                            AdLoader.Builder builder = new AdLoader.Builder(context, shared.getAM_native());

                                            builder.forNativeAd(_unifiedNativeAd -> {
                                                //Log.e("NativeAds2", "Native Loaded ");
                                                unifiedNativeAd2 = _unifiedNativeAd;
                                            });

                                            AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() {
                                                @Override
                                                public void onAdFailedToLoad(LoadAdError adError) {
                                                    //Log.e("NativeAds2", "Native adError -> " + adError.getMessage());
                                                    unifiedNativeAd2 = null;
                                                    adViewAM2 = new com.google.android.gms.ads.AdView(context);
                                                    adViewAM2.setAdUnitId(shared.getAM_Rectangele());
                                                    adViewAM2.setAdSize(com.google.android.gms.ads.AdSize.MEDIUM_RECTANGLE);
                                                    adViewAM2.loadAd(new AdRequest.Builder().build());
                                                    adViewAM2.setAdListener(new com.google.android.gms.ads.AdListener() {
                                                        @Override
                                                        public void onAdLoaded() {
                                                            super.onAdLoaded();
                                                            //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 Loaded -> 1");
                                                            // Code to be executed when an ad finishes loading.
                                                        }

                                                        @Override
                                                        public void onAdFailedToLoad(LoadAdError adError) {
                                                            // Code to be executed when an ad request fails.
                                                            //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 adError -> 1" + adError.toString());
                                                            adViewAM2 = null;
                                                        }

                                                        @Override
                                                        public void onAdImpression() {
                                                            //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 onAdImpression1: Yes");
                                                            super.onAdImpression();
                                                        }
                                                    });

                                                }

                                                @Override
                                                public void onAdImpression() {
                                                    //Log.e("@@TAG", "Native onAdImpression1: Yes");
                                                    unifiedNativeAd2 = null;
                                                    super.onAdImpression();
                                                }

                                                @Override
                                                public void onAdLoaded() {
                                                    //Log.e("@@TAG", "Native onAdLoaded1: Yes");
                                                    super.onAdLoaded();
                                                }
                                            }).build();
                                            adLoader.loadAd(new AdRequest.Builder().build());
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {

                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {

                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {

                                    }
                                }).build());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onAdLoaded(Ad ad) {

                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                        }
                    })
                    .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void NativeAddShow(final Activity context, final ViewGroup BannerContainer) {
        shared = new pro_sdk_c(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        FbSdkDefaultAdsContainerBinding bindingdefault = DataBindingUtil.inflate(inflater, R.layout.fb_sdk_default_ads_container, BannerContainer, false);
        BannerContainer.removeAllViews();
        BannerContainer.addView(bindingdefault.getRoot());

        if (nativeAd1 != null || adView1 != null || unifiedNativeAd1 != null || adViewAM1 != null) {
            if (nativeAd1 != null && nativeAd1.isAdLoaded()) {
                try {
                    View adView = NativeAdView.render(context, nativeAd1, NativeAdView.Type.HEIGHT_300);
                    BannerContainer.removeAllViews();
                    BannerContainer.addView(adView);
                    nativeAd1 = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (adView1 != null) {
                BannerContainer.removeAllViews();
                BannerContainer.addView(adView1);
                adView1 = null;
            } else if (unifiedNativeAd1 != null) {
                AdsAmActivityNativeAdsTempBinding binding = DataBindingUtil.inflate(inflater, R.layout.ads_am_activity_native_ads_temp, BannerContainer, false);
                binding.cardLargeTemplate.setVisibility(View.VISIBLE);
                binding.cardSmallTemplate.setVisibility(View.GONE);
                Speed_Android_NAd_Temp styles = new Speed_Android_NAd_Temp.Builder().build();
                BannerContainer.removeAllViews();
                BannerContainer.addView(binding.getRoot());
                binding.myTemplateLarge.setStyles(styles);
                binding.myTemplateLarge.setNativeAd(unifiedNativeAd1);
            } else if (adViewAM1 != null) {
                BannerContainer.removeAllViews();
                AdUnitAdmobMedBinding adUnitAdmobMedBinding = DataBindingUtil.inflate(context.getLayoutInflater(), R.layout.ad_unit_admob_med, BannerContainer, false);
                adUnitAdmobMedBinding.getRoot().setVisibility(View.INVISIBLE);
                BannerContainer.addView(adUnitAdmobMedBinding.getRoot());
                BannerContainer.addView(adViewAM1);
                adViewAM1 = null;
            }

            if (nativeAd2 == null && adView2 == null)
                NativeAddLoad2(context);

        } else if (nativeAd2 != null || adView2 != null || unifiedNativeAd2 != null || adViewAM2 != null) {
            if (nativeAd2 != null && nativeAd2.isAdLoaded()) {
                try {
                    View adView = NativeAdView.render(context, nativeAd2, NativeAdView.Type.HEIGHT_300);
                    BannerContainer.removeAllViews();
                    BannerContainer.addView(adView);
                    nativeAd2 = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (adView2 != null) {
                BannerContainer.removeAllViews();
                BannerContainer.addView(adView2);
                adView2 = null;
            } else if (unifiedNativeAd2 != null) {
                AdsAmActivityNativeAdsTempBinding binding = DataBindingUtil.inflate(inflater, R.layout.ads_am_activity_native_ads_temp, BannerContainer, false);
                binding.cardLargeTemplate.setVisibility(View.VISIBLE);
                binding.cardSmallTemplate.setVisibility(View.GONE);
                Speed_Android_NAd_Temp styles = new Speed_Android_NAd_Temp.Builder().build();
                BannerContainer.removeAllViews();
                BannerContainer.addView(binding.getRoot());
                binding.myTemplateLarge.setStyles(styles);
                binding.myTemplateLarge.setNativeAd(unifiedNativeAd2);
            } else if (adViewAM2 != null) {
                BannerContainer.removeAllViews();
                AdUnitAdmobMedBinding adUnitAdmobMedBinding = DataBindingUtil.inflate(context.getLayoutInflater(), R.layout.ad_unit_admob_med, BannerContainer, false);
                adUnitAdmobMedBinding.getRoot().setVisibility(View.INVISIBLE);
                BannerContainer.addView(adUnitAdmobMedBinding.getRoot());
                BannerContainer.addView(adViewAM2);
                adViewAM2 = null;
            }

            if (nativeAd1 == null && adView1 == null)
                NativeAddLoad1(context);

        } else {
            NativeAddOld(context, BannerContainer);
            NativeAddLoad1(context);
        }
    }

    private static void NativeAddOld(final Context context, final ViewGroup BannerContainer) {
        shared = new pro_sdk_c(context);
        try {
            LayoutInflater inflater = LayoutInflater.from(context);
            SdkDefaultAdsContainerBinding bindingdefault = DataBindingUtil.inflate(inflater, R.layout.sdk_default_ads_container, BannerContainer, false);
            BannerContainer.removeAllViews();
            BannerContainer.addView(bindingdefault.getRoot());

            final NativeAd nativeAd = new NativeAd(context, shared.getFB_native());
            nativeAd.loadAd(nativeAd.buildLoadAdConfig()
                    .withAdListener(new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {

                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            try {
                                AdView adView = new AdView(context, shared.getFB_banner(), AdSize.RECTANGLE_HEIGHT_250);
                                adView.loadAd(adView.buildLoadAdConfig().withAdListener(new AdListener() {
                                    @Override
                                    public void onError(Ad ad, AdError adError) {
                                        try {

                                            AdLoader.Builder builder = new AdLoader.Builder(context, shared.getAM_native());
                                            builder.forNativeAd(unifiedNativeAd -> {
                                                AdsAmActivityNativeAdsTempBinding binding = DataBindingUtil.inflate(inflater, R.layout.ads_am_activity_native_ads_temp, BannerContainer, false);
                                                binding.cardLargeTemplate.setVisibility(View.VISIBLE);
                                                binding.cardSmallTemplate.setVisibility(View.GONE);
                                                Speed_Android_NAd_Temp styles = new Speed_Android_NAd_Temp.Builder().build();

                                                BannerContainer.removeAllViews();
                                                BannerContainer.addView(binding.getRoot());

                                                binding.myTemplateLarge.setStyles(styles);
                                                binding.myTemplateLarge.setNativeAd(unifiedNativeAd);

                                            });

                                            AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() {
                                                @Override
                                                public void onAdFailedToLoad(LoadAdError errorCode) {
                                                    com.google.android.gms.ads.AdView adView = new com.google.android.gms.ads.AdView(context);
                                                    adView.setAdUnitId(shared.getAM_Rectangele());
                                                    adView.setAdSize(com.google.android.gms.ads.AdSize.MEDIUM_RECTANGLE);
                                                    adView.setAdListener(new com.google.android.gms.ads.AdListener() {
                                                        @Override
                                                        public void onAdLoaded() {
                                                            // Code to be executed when an ad finishes loading.
                                                            BannerContainer.removeAllViews();
                                                            BannerContainer.addView(adView);
                                                        }

                                                        @Override
                                                        public void onAdFailedToLoad(LoadAdError adError) {
                                                            // Code to be executed when an ad request fails.
                                                            //Log.e("@@Medium_Rect", adError.getMessage() + "-" + adError.getCode());
                                                        }

                                                        @Override
                                                        public void onAdOpened() {
                                                            // Code to be executed when an ad opens an overlay that
                                                            // covers the screen.
                                                        }

                                                        @Override
                                                        public void onAdClicked() {
                                                            // Code to be executed when the user clicks on an ad.
                                                        }

                                                        @Override
                                                        public void onAdClosed() {
                                                            // Code to be executed when the user is about to return
                                                            // to the app after tapping on an ad.
                                                        }
                                                    });
                                                    AdRequest adRequest = new AdRequest.Builder().build();

                                                    adView.loadAd(adRequest);
                                                }
                                            }).build();

                                            adLoader.loadAd(new AdRequest.Builder().build());
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }

                                    @Override
                                    public void onAdLoaded(Ad ad) {
                                        BannerContainer.removeAllViews();
                                        BannerContainer.addView(adView);
                                    }

                                    @Override
                                    public void onAdClicked(Ad ad) {

                                    }

                                    @Override
                                    public void onLoggingImpression(Ad ad) {

                                    }
                                }).build());

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            try {
                                View adView = NativeAdView.render(context, nativeAd, NativeAdView.Type.HEIGHT_300);
                                //Log.e("Native Ad", "Loaded");
                                BannerContainer.removeAllViews();
                                BannerContainer.addView(adView);
                                NativeAddLoad1(context);

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                        }
                    })
                    .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //========================================================= End of Native Ads Code ================================================
//========================================================= Native Banner Ads Code ================================================
    public static void NativeBannerAddLoad1(final Context context) {
        shared = new pro_sdk_c(context);
        try {
            nativeBannerAd1 = new NativeBannerAd(context, shared.getFB_native_banner());
            nativeBannerAd1.loadAd(nativeBannerAd1.buildLoadAdConfig()
                    .withAdListener(new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {

                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            nativeBannerAd1 = null;
                            try {
                                AdLoader.Builder builder = new AdLoader.Builder(context, shared.getAM_native());

                                builder.forNativeAd(_unifiedNativeAd -> {
                                    unifiedNativeBannerAd1 = _unifiedNativeAd;
                                });

                                AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError adError) {
                                        unifiedNativeBannerAd1 = null;
                                        adViewNativeBanner1 = new com.google.android.gms.ads.AdView(context);
                                        adViewNativeBanner1.setAdUnitId(shared.getAM_Rectangele());
                                        adViewNativeBanner1.setAdSize(com.google.android.gms.ads.AdSize.LARGE_BANNER);
                                        adViewNativeBanner1.loadAd(new AdRequest.Builder().build());
                                        adViewNativeBanner1.setAdListener(new com.google.android.gms.ads.AdListener() {
                                            @Override
                                            public void onAdLoaded() {
                                                super.onAdLoaded();
                                                //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 Loaded -> 1");
                                                // Code to be executed when an ad finishes loading.
                                            }

                                            @Override
                                            public void onAdFailedToLoad(LoadAdError adError) {
                                                // Code to be executed when an ad request fails.
                                                //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 adError -> 1" + adError.toString());
                                                adViewNativeBanner1 = null;
                                            }

                                            @Override
                                            public void onAdImpression() {
                                                //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 onAdImpression1: Yes");
                                                super.onAdImpression();
                                            }
                                        });

                                    }

                                    @Override
                                    public void onAdImpression() {
                                        //Log.e("@@TAG", "NativeBanner onAdImpression1: Yes");
                                        unifiedNativeBannerAd1 = null;
                                        super.onAdImpression();
                                    }

                                    @Override
                                    public void onAdLoaded() {
                                        //Log.e("@@TAG", "NativeBanner onAdLoaded1: Yes");
                                        super.onAdLoaded();
                                    }
                                }).build();
                                adLoader.loadAd(new AdRequest.Builder().build());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            //Log.e("@@Ads", "onAdLoaded + NativeBanner");
                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                        }
                    })
                    .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void NativeBannerAddLoad2(final Context context) {
        shared = new pro_sdk_c(context);
        try {
            nativeBannerAd2 = new NativeBannerAd(context, shared.getFB_native_banner());
            nativeBannerAd2.loadAd(nativeBannerAd2.buildLoadAdConfig()
                    .withAdListener(new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {

                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            nativeBannerAd2 = null;
                            try {
                                AdLoader.Builder builder = new AdLoader.Builder(context, shared.getAM_native());

                                builder.forNativeAd(_unifiedNativeAd -> {
                                    unifiedNativeBannerAd2 = _unifiedNativeAd;
                                });

                                AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError adError) {
                                        unifiedNativeBannerAd2 = null;
                                        adViewNativeBanner2 = new com.google.android.gms.ads.AdView(context);
                                        adViewNativeBanner2.setAdUnitId(shared.getAM_Rectangele());
                                        adViewNativeBanner2.setAdSize(com.google.android.gms.ads.AdSize.LARGE_BANNER);
                                        adViewNativeBanner2.loadAd(new AdRequest.Builder().build());
                                        adViewNativeBanner2.setAdListener(new com.google.android.gms.ads.AdListener() {
                                            @Override
                                            public void onAdLoaded() {
                                                super.onAdLoaded();
                                                //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 Loaded -> 1");
                                                // Code to be executed when an ad finishes loading.
                                            }

                                            @Override
                                            public void onAdFailedToLoad(LoadAdError adError) {
                                                // Code to be executed when an ad request fails.
                                                //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 adError -> 1" + adError.toString());
                                                adViewNativeBanner2 = null;
                                            }

                                            @Override
                                            public void onAdImpression() {
                                                //Log.e("NativeAdTest", "MEDIUM_RECTANGLE1 onAdImpression1: Yes");
                                                super.onAdImpression();
                                            }
                                        });

                                    }

                                    @Override
                                    public void onAdImpression() {
                                        //Log.e("@@TAG", "NativeBanner onAdImpression1: Yes");
                                        unifiedNativeBannerAd2 = null;
                                        super.onAdImpression();
                                    }

                                    @Override
                                    public void onAdLoaded() {
                                        //Log.e("@@TAG", "NativeBanner onAdLoaded1: Yes");
                                        super.onAdLoaded();
                                    }
                                }).build();
                                adLoader.loadAd(new AdRequest.Builder().build());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {

                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                        }
                    })
                    .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void NativeBannerAddShow(final Activity context, final ViewGroup BannerContainer) {
        shared = new pro_sdk_c(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        FbSdkDefaultAdsContainer1Binding bindingdefault = DataBindingUtil.inflate(inflater, R.layout.fb_sdk_default_ads_container1, BannerContainer, false);
        BannerContainer.removeAllViews();
        BannerContainer.addView(bindingdefault.getRoot());

        if (nativeBannerAd1 != null || unifiedNativeBannerAd1 != null || adViewNativeBanner1 != null) {
            if (nativeBannerAd1 != null && nativeBannerAd1.isAdLoaded()) {
                try {
                    View adView = NativeBannerAdView.render(context, nativeBannerAd1, NativeBannerAdView.Type.HEIGHT_120);
                    BannerContainer.removeAllViews();
                    BannerContainer.addView(adView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (unifiedNativeBannerAd1 != null) {
                AdsAmActivityNativeAdsTempBinding binding = DataBindingUtil.inflate(inflater, R.layout.ads_am_activity_native_ads_temp, BannerContainer, false);
                binding.cardLargeTemplate.setVisibility(View.GONE);
                binding.cardSmallTemplate.setVisibility(View.VISIBLE);
                Speed_Android_NAd_Temp styles = new Speed_Android_NAd_Temp.Builder().build();
                BannerContainer.removeAllViews();
                BannerContainer.addView(binding.getRoot());
                binding.myTemplateSmall.setStyles(styles);
                binding.myTemplateSmall.setNativeAd(unifiedNativeBannerAd1);
            } else if (adViewNativeBanner1 != null) {
                BannerContainer.removeAllViews();
                //todo: new
//                AdUnitAdmobMedBinding adUnitAdmobMedBinding = DataBindingUtil.inflate(context.getLayoutInflater(), R.layout.ad_unit_admob_small, BannerContainer, false);
                AdUnitAdmobSmallBinding adUnitAdmobMedBinding = DataBindingUtil.inflate(context.getLayoutInflater(), R.layout.ad_unit_admob_small, BannerContainer, false);
                adUnitAdmobMedBinding.getRoot().setVisibility(View.INVISIBLE);
                BannerContainer.addView(adUnitAdmobMedBinding.getRoot());
                BannerContainer.addView(adViewNativeBanner1);
                adViewNativeBanner1 = null;
            }

            if (nativeBannerAd2 == null)
                NativeBannerAddLoad2(context);

        } else if (nativeBannerAd2 != null || unifiedNativeBannerAd2 != null || adViewNativeBanner2 != null) {
            if (nativeBannerAd2 != null && nativeBannerAd2.isAdLoaded()) {
                try {
                    View adView = NativeBannerAdView.render(context, nativeBannerAd2, NativeBannerAdView.Type.HEIGHT_120);
                    BannerContainer.removeAllViews();
                    BannerContainer.addView(adView);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (unifiedNativeBannerAd2 != null) {
                AdsAmActivityNativeAdsTempBinding binding = DataBindingUtil.inflate(inflater, R.layout.ads_am_activity_native_ads_temp, BannerContainer, false);
                binding.cardLargeTemplate.setVisibility(View.GONE);
                binding.cardSmallTemplate.setVisibility(View.VISIBLE);
                Speed_Android_NAd_Temp styles = new Speed_Android_NAd_Temp.Builder().build();
                BannerContainer.removeAllViews();
                BannerContainer.addView(binding.getRoot());
                binding.myTemplateSmall.setStyles(styles);
                binding.myTemplateSmall.setNativeAd(unifiedNativeBannerAd2);
            } else if (adViewNativeBanner2 != null) {
                BannerContainer.removeAllViews();
                //todo: new
//                AdUnitAdmobMedBinding adUnitAdmobMedBinding = DataBindingUtil.inflate(context.getLayoutInflater(), R.layout.ad_unit_admob_small, BannerContainer, false);
                AdUnitAdmobSmallBinding adUnitAdmobMedBinding = DataBindingUtil.inflate(context.getLayoutInflater(), R.layout.ad_unit_admob_small, BannerContainer, false);
                adUnitAdmobMedBinding.getRoot().setVisibility(View.INVISIBLE);
                BannerContainer.addView(adUnitAdmobMedBinding.getRoot());
                BannerContainer.addView(adViewNativeBanner2);
                adViewNativeBanner2 = null;
            }

            if (nativeBannerAd1 == null)
                NativeBannerAddLoad1(context);

        } else {
            NativeBannerAdd120(context, BannerContainer);
            NativeBannerAddLoad1(context);
        }
    }

    private static void NativeBannerAdd120(final Context context, final ViewGroup BannerContainer) {
        shared = new pro_sdk_c(context);
        try {
            LayoutInflater inflater = LayoutInflater.from(context);
            SdkDefaultAdsContainer1Binding bindingdefault = DataBindingUtil.inflate(inflater, R.layout.sdk_default_ads_container1, BannerContainer, false);

            BannerContainer.removeAllViews();
            BannerContainer.addView(bindingdefault.getRoot());

            final NativeBannerAd nativeAd = new NativeBannerAd(context, shared.getFB_native_banner());
            nativeAd.loadAd(nativeAd.buildLoadAdConfig()
                    .withAdListener(new NativeAdListener() {
                        @Override
                        public void onMediaDownloaded(Ad ad) {

                        }

                        @Override
                        public void onError(Ad ad, AdError adError) {
                            try {
                                AdLoader.Builder builder = new AdLoader.Builder(context, shared.getAM_native());

                                builder.forNativeAd(unifiedNativeAd -> {
                                    AdsAmActivityNativeAdsTempBinding binding = DataBindingUtil.inflate(inflater, R.layout.ads_am_activity_native_ads_temp, BannerContainer, false);
                                    if (context.getClass().getSimpleName().equalsIgnoreCase("StartActivity") || context.getClass().getSimpleName().equalsIgnoreCase("TermsActivity"))
                                        binding.cardSmallTemplate.setCardBackgroundColor(Color.parseColor("#383838"));
                                    binding.cardLargeTemplate.setVisibility(View.GONE);
                                    binding.cardSmallTemplate.setVisibility(View.VISIBLE);
                                    Speed_Android_NAd_Temp styles = new Speed_Android_NAd_Temp.Builder().build();
                                    BannerContainer.removeAllViews();
                                    BannerContainer.addView(binding.getRoot());
                                    binding.myTemplateSmall.setStyles(styles);
                                    binding.myTemplateSmall.setNativeAd(unifiedNativeAd);

                                });

                                AdLoader adLoader = builder.withAdListener(new com.google.android.gms.ads.AdListener() {
                                    @Override
                                    public void onAdFailedToLoad(LoadAdError errorCode) {
                                        //Log.e("AMNativeBanner", "Error-" + errorCode.getMessage());
                                        com.google.android.gms.ads.AdView adView = new com.google.android.gms.ads.AdView(context);
                                        adView.setAdUnitId(shared.getAM_Rectangele());
                                        adView.setAdSize(com.google.android.gms.ads.AdSize.LARGE_BANNER);
                                        adView.setAdListener(new com.google.android.gms.ads.AdListener() {
                                            @Override
                                            public void onAdLoaded() {
                                                // Code to be executed when an ad finishes loading.
                                                BannerContainer.removeAllViews();
                                                BannerContainer.addView(adView);
                                            }

                                            @Override
                                            public void onAdFailedToLoad(LoadAdError adError) {
                                                // Code to be executed when an ad request fails.
                                                //Log.e("Medium_Rect", adError.getMessage() + "-" + adError.getCode());

                                            }

                                            @Override
                                            public void onAdOpened() {
                                                // Code to be executed when an ad opens an overlay that
                                                // covers the screen.
                                            }

                                            @Override
                                            public void onAdClicked() {
                                                // Code to be executed when the user clicks on an ad.
                                            }

                                            @Override
                                            public void onAdClosed() {
                                                // Code to be executed when the user is about to return
                                                // to the app after tapping on an ad.
                                            }
                                        });
                                        AdRequest adRequest = new AdRequest.Builder().build();

                                        adView.loadAd(adRequest);
                                    }
                                }).build();

                                adLoader.loadAd(new AdRequest.Builder().build());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onAdLoaded(Ad ad) {
                            try {
                                View adView = NativeBannerAdView.render(context, nativeAd, NativeBannerAdView.Type.HEIGHT_120);
                                //Log.e("Native Ad", "Loaded");
                                BannerContainer.removeAllViews();
                                BannerContainer.addView(adView);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onAdClicked(Ad ad) {

                        }

                        @Override
                        public void onLoggingImpression(Ad ad) {

                        }
                    })
                    .withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL)
                    .build());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //========================================================= Banner Ads Code =======================================================

    public static void LoadNormalBanner(final Context context, final ViewGroup BannerContainer) {
        shared = new pro_sdk_c(context);
        try {
            AdView adView1 = new AdView(context, shared.getFB_banner(), AdSize.BANNER_HEIGHT_50);
            adView1.loadAd(adView1.buildLoadAdConfig().withAdListener(new AdListener() {
                @Override
                public void onError(Ad ad, AdError adError) {
                    com.google.android.gms.ads.AdView adView = new com.google.android.gms.ads.AdView(context);
                    adView.setAdUnitId(shared.getAM_banner());
                    adView.setAdSize(com.google.android.gms.ads.AdSize.BANNER);
                    adView.setAdListener(new com.google.android.gms.ads.AdListener() {
                        @Override
                        public void onAdLoaded() {
                            // Code to be executed when an ad finishes loading.
                            BannerContainer.removeAllViews();
                            BannerContainer.addView(adView);
                        }

                        @Override
                        public void onAdFailedToLoad(LoadAdError adError) {
                            // Code to be executed when an ad request fails.
                        }

                        @Override
                        public void onAdOpened() {
                            // Code to be executed when an ad opens an overlay that
                            // covers the screen.
                        }

                        @Override
                        public void onAdClicked() {
                            // Code to be executed when the user clicks on an ad.
                        }

                        @Override
                        public void onAdClosed() {
                            // Code to be executed when the user is about to return
                            // to the app after tapping on an ad.
                        }
                    });
                    AdRequest adRequest = new AdRequest.Builder().build();
                    adView.loadAd(adRequest);
                }

                @Override
                public void onAdLoaded(Ad ad) {

                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }
            }).build());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
