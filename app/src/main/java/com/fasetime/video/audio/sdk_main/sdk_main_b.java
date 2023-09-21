package com.fasetime.video.audio.sdk_main;

import android.os.SystemClock;
import android.view.View;

public abstract class sdk_main_b implements View.OnClickListener {

    protected int defaultInterval;
    private long lastTimeClicked = 0;

    public sdk_main_b() {
        this(1000);
    }

    public sdk_main_b(int minInterval) {
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