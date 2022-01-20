package com.rohfl.samplemvp;

public class Sample {

    interface View {
        void showProgressDialog();
        void dismissProgressDialog();
    }

    interface Presenter {
        void start();
    }

}
