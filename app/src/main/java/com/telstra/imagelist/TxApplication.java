package com.telstra.imagelist;

import android.app.Application;
import android.util.Log;

public class TxApplication extends Application {
    private static final String TAG = TxApplication.class
            .getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, getString(R.string.app_launch));
    }
}
