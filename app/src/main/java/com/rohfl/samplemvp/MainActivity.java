package com.rohfl.samplemvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame, new FragmentOne()).commit();

    }

    @Override
    public void onBackPressed(){
        // here I am creating the case where the presenter has got the view
        // and it starts to execute the methods.
        // But when it was about to execute the show progress method we hit back, now what is happening
        // is that, Presenter execution and fragment destroy are running in parallel,
        // showProgress dialog will execute because the fragment is still in the process of
        // destroying and not yet destroyed. So, the progress dialog is shown. But by the time we execute
        // dismissProgress, fragment is destroyed, hence view is null. So we will anyway have to put
        // dismissDialog in onDestroy of the fragment.
        Log.d(">>>>", "onBackPressed: Entered");
        new Handler().postDelayed(super::onBackPressed, 15000);
    }

}