package com.rohfl.samplemvp;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentTwo extends Fragment implements Sample.View {


    Dialog progressDialogNew;
    Button start;
    Pr pr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_two, container, false);
        initPresenter();
        return v;
    }

    private void initPresenter() {
        pr = new Pr(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        start = view.findViewById(R.id.start);
        start.setOnClickListener(v -> {
            pr.start();
        });

    }

    @Override
    public void onDestroy() {
        Log.d(">>>>>>", "onDestroy: Entered");
        dismissProgressDialog();
        super.onDestroy();
        pr.onDestroy();
    }

    public void showProgressDialog() {
        try {
            if (progressDialogNew == null) {
                progressDialogNew = new Dialog(getActivity());
                progressDialogNew.requestWindowFeature(Window.FEATURE_NO_TITLE);
                progressDialogNew.setCancelable(false);
                progressDialogNew.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                progressDialogNew.setContentView(R.layout.custom_loading_layout);

                progressDialogNew.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissProgressDialog() {
        try {

            if (progressDialogNew != null && progressDialogNew.isShowing()) {
                progressDialogNew.dismiss();
                progressDialogNew = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
