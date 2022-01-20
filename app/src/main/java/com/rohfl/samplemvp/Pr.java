package com.rohfl.samplemvp;

import android.os.Handler;
import android.util.Log;

public class Pr implements Sample.Presenter {

    private Sample.View view;

    public Pr(Sample.View view) {
        this.view = view;
    }

    public void start() {
        // this runs when we click start progress button, see that it will start to show progress
        // after 10 seconds. Did this to create a special case.
        // Now after back immediately after pressing Start Progress
        new Handler().postDelayed(() -> {
            view.showProgressDialog();
            // calling stopProgress method
            stopProgress();
        }, 10000);
    }

    public void stopProgress() {
        // this will stop the progress dialog after 10 seconds, so in total we saw the progress dialog
        // for 10 seconds
        new Handler().postDelayed(() -> {
            if(view != null)
                view.dismissProgressDialog();
            else {
                Log.d(">>>>>>", "stopProgress: View is NULL");
            }

        }, 10000);
    }

    public void onDestroy() {
        this.view = null;
    }

}
