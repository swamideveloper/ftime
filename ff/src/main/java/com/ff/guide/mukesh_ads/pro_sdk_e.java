package com.ff.guide.mukesh_ads;

import android.os.SystemClock;
import android.view.View;

public abstract class pro_sdk_e implements View.OnClickListener {

    protected int defaultInterval;
    private long lastTimeClicked = 0;

    public pro_sdk_e() {
        this(1000);
    }

    public pro_sdk_e(int minInterval) {
        this.defaultInterval = minInterval;
    }

    @Override
    public void onClick(View v) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return;
        }
        lastTimeClicked = SystemClock.elapsedRealtime();
        performClick(v);
    }

    public abstract void performClick(View v);
}
