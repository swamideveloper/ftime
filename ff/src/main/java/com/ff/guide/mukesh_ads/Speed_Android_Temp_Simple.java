// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.ff.guide.mukesh_ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.ff.guide.R;

public class Speed_Android_Temp_Simple extends FrameLayout {

    private int templateType = R.layout.ad_unit_admob_med;
    private int templateMinHeight = 120;
    private Speed_Android_NAd_Temp styles;
    private NativeAd nativeAd;
    private NativeAdView nativeAdView;
    private TextView primaryView;
    private TextView secondaryView;
    private RatingBar ratingBar;
    private TextView tertiaryView;
    private ImageView iconView;
    private MediaView mediaView;
    private AppCompatButton callToActionView;
//    private LinearLayout background;

    public Speed_Android_Temp_Simple(Context context) {
        super(context);
    }

    public Speed_Android_Temp_Simple(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public Speed_Android_Temp_Simple(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @SuppressLint("NewApi")
    public Speed_Android_Temp_Simple(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    public void setStyles(Speed_Android_NAd_Temp styles) {
        this.styles = styles;
        this.applyStyles();
    }

    public NativeAdView getNativeAdView() {
        return nativeAdView;
    }

    private void applyStyles() {

        Drawable mainBackground = styles.getMainBackgroundColor();
        if (mainBackground != null) {
//            background.setBackground(mainBackground);
            if (primaryView != null) {
                primaryView.setBackground(mainBackground);
            }
            if (secondaryView != null) {
                secondaryView.setBackground(mainBackground);
            }
            if (tertiaryView != null) {
                tertiaryView.setBackground(mainBackground);
            }
        }

        Typeface primary = styles.getPrimaryTextTypeface();
        if (primary != null && primaryView != null) {
            primaryView.setTypeface(primary);
        }

        Typeface secondary = styles.getSecondaryTextTypeface();
        if (secondary != null && secondaryView != null) {
            secondaryView.setTypeface(secondary);
        }

        Typeface tertiary = styles.getTertiaryTextTypeface();
        if (tertiary != null && tertiaryView != null) {
            tertiaryView.setTypeface(tertiary);
        }

        Typeface ctaTypeface = styles.getCallToActionTextTypeface();
        if (ctaTypeface != null && callToActionView != null) {
            callToActionView.setTypeface(ctaTypeface);
        }

        int primaryTypefaceColor = styles.getPrimaryTextTypefaceColor();
        if (primaryTypefaceColor > 0 && primaryView != null) {
            primaryView.setTextColor(primaryTypefaceColor);
        }

        int secondaryTypefaceColor = styles.getSecondaryTextTypefaceColor();
        if (secondaryTypefaceColor > 0 && secondaryView != null) {
            secondaryView.setTextColor(secondaryTypefaceColor);
        }

        int tertiaryTypefaceColor = styles.getTertiaryTextTypefaceColor();
        if (tertiaryTypefaceColor > 0 && tertiaryView != null) {
            tertiaryView.setTextColor(tertiaryTypefaceColor);
        }

        int ctaTypefaceColor = styles.getCallToActionTypefaceColor();
        if (ctaTypefaceColor > 0 && callToActionView != null) {
            callToActionView.setTextColor(ctaTypefaceColor);
        }

        float ctaTextSize = styles.getCallToActionTextSize();
        if (ctaTextSize > 0 && callToActionView != null) {
            callToActionView.setTextSize(ctaTextSize);
        }

        float primaryTextSize = styles.getPrimaryTextSize();
        if (primaryTextSize > 0 && primaryView != null) {
            primaryView.setTextSize(primaryTextSize);
        }

        float secondaryTextSize = styles.getSecondaryTextSize();
        if (secondaryTextSize > 0 && secondaryView != null) {
            secondaryView.setTextSize(secondaryTextSize);
        }

        float tertiaryTextSize = styles.getTertiaryTextSize();
        if (tertiaryTextSize > 0 && tertiaryView != null) {
            tertiaryView.setTextSize(tertiaryTextSize);
        }

        Drawable ctaBackground = styles.getCallToActionBackgroundColor();
        if (ctaBackground != null && callToActionView != null) {
            callToActionView.setBackground(ctaBackground);
        }

        Drawable primaryBackground = styles.getPrimaryTextBackgroundColor();
        if (primaryBackground != null && primaryView != null) {
            primaryView.setBackground(primaryBackground);
        }

        Drawable secondaryBackground = styles.getSecondaryTextBackgroundColor();
        if (secondaryBackground != null && secondaryView != null) {
            secondaryView.setBackground(secondaryBackground);
        }

        Drawable tertiaryBackground = styles.getTertiaryTextBackgroundColor();
        if (tertiaryBackground != null && tertiaryView != null) {
            tertiaryView.setBackground(tertiaryBackground);
        }

        invalidate();
        requestLayout();
    }

    private boolean adHasOnlyStore(NativeAd nativeAd) {
        String store = nativeAd.getStore();
        String advertiser = nativeAd.getAdvertiser();
        return !TextUtils.isEmpty(store) && TextUtils.isEmpty(advertiser);
    }

    public void setNativeAd(NativeAd nativeAd) {
        this.nativeAd = nativeAd;

        String store = nativeAd.getStore();
        String advertiser = nativeAd.getAdvertiser();
        String headline = nativeAd.getHeadline();
        String body = nativeAd.getBody();
        String cta = nativeAd.getCallToAction();
        Double starRating = nativeAd.getStarRating();
        NativeAd.Image icon = nativeAd.getIcon();

        String secondaryText;

        nativeAdView.setCallToActionView(callToActionView);
        nativeAdView.setHeadlineView(primaryView);
        nativeAdView.setMediaView(mediaView);
        if (adHasOnlyStore(nativeAd)) {
            nativeAdView.setStoreView(secondaryView);
            secondaryText = store;
        } else if (!TextUtils.isEmpty(advertiser)) {
            nativeAdView.setAdvertiserView(secondaryView);
            secondaryText = advertiser;
        } else {
            secondaryText = "";
        }

        primaryView.setText(headline);
        callToActionView.setText(cta);

        //  Set the secondary view to be the star rating if available.
        if (starRating != null && starRating > 0) {
            ratingBar.setVisibility(GONE);
            ratingBar.setMax(5);
            nativeAdView.setStarRatingView(ratingBar);
        } else {
            secondaryView.setVisibility(!secondaryText.equals("") ? VISIBLE : GONE);
            secondaryView.setText(secondaryText);
            ratingBar.setVisibility(GONE);
        }

        if (icon != null) {
            iconView.setVisibility(VISIBLE);
            iconView.setImageDrawable(icon.getDrawable());
        } else {
            iconView.setVisibility(INVISIBLE);
        }

        if (tertiaryView != null) {
            tertiaryView.setText(body);
            nativeAdView.setBodyView(tertiaryView);
        }

        nativeAdView.setNativeAd(nativeAd);
    }

    public void destroyNativeAd() {
        nativeAd.destroy();
    }

    private void initView(Context context, AttributeSet attributeSet) {

        TypedArray attributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TemplateView, 0, 0);

        try {
            templateType = attributes.getResourceId(R.styleable.TemplateView_gnt_template_type, templateType);
            templateMinHeight = attributes.getResourceId(R.styleable.TemplateView_gnt_template_min_height, templateMinHeight);
        } finally {
            attributes.recycle();
        }
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(templateType, this);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        nativeAdView = findViewById(R.id.native_ad_view);
        primaryView = findViewById(R.id.primary);
        secondaryView = findViewById(R.id.secondary);
        tertiaryView = findViewById(R.id.body);

        ratingBar = findViewById(R.id.rating_bar);
        ratingBar.setEnabled(false);

        callToActionView = findViewById(R.id.cta);
        iconView = findViewById(R.id.icon);
        mediaView = findViewById(R.id.media_view);
//        background = findViewById(R.id.background);

    }
}
