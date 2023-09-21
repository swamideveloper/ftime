package com.ff.guide.mukesh_ads;

import static com.ff.guide.mukesh_ads.pro_sdk_b.openCustomTab;

import android.content.Context;
import android.net.Uri;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import com.ff.guide.R;

public class pro_sdk_f {

    public static void showQurekaInter(Context context) {
        if (new pro_sdk_c(context).getQureka_Inter().equalsIgnoreCase("on")) {
            if (new pro_sdk_c(context).getQureka_Inter_Mode().equalsIgnoreCase("on")) {
                CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                customIntent.setToolbarColor(ContextCompat.getColor(context, R.color.chormecolor));
                openCustomTab(context, customIntent.build(), Uri.parse(new pro_sdk_c(context).getQureka_Url()));
            } else {
                new pro_sdk_b(context).show();
            }
        }
    }
}
