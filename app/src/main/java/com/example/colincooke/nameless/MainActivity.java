package com.example.colincooke.nameless;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        Button button = (Button) this.findViewById(R.id.text);


        grantPermission(this, Manifest.permission.SEND_SMS);
        grantPermission(this, Manifest.permission.RECEIVE_SMS);
        grantPermission(this, Manifest.permission.READ_SMS);
        grantPermission(this, Manifest.permission.RECEIVE_MMS);
        grantPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                SmsManager smsManager = SmsManager.getDefault();
//
//
//
//            }
//        });

        setContentView(R.layout.activity_main);
    }


    private void grantPermission(Activity activity, String permission) {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity,
                permission)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    permission)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(activity,
                        new String[]{permission},
                        1);
            }
        }
    }

}
