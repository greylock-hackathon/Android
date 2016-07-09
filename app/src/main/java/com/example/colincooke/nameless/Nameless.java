package com.example.colincooke.nameless;

import android.app.Application;
import android.content.Context;

/**
 * Created by colincooke on 7/9/16.
 */
public class Nameless extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        //init Google Play by calling getPlayWrapper
        LocationUtils.init();

    }

    public static Context getAppContext() {
        return context;
    }
}
