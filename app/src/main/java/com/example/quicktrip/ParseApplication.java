package com.example.quicktrip;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("FiUvLxFtuTgcCRpHMCb2zFCw34U1oIvP0lkaMLdc")
                .clientKey("dObQ72CQSrzC3WLKzoHhyBbZbrAC5WSoGbSl98bX")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
