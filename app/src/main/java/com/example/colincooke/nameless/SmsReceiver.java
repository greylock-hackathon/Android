package com.example.colincooke.nameless;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by colincooke on 7/9/16.
 */
public class SmsReceiver extends BroadcastReceiver {
    private String TAG = SmsReceiver.class.getSimpleName();

    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the data (SMS data) bound to intent
        Bundle bundle = intent.getExtras();

        SmsMessage[] msgs = null;

        String str = "";

        if (bundle != null) {
            // Retrieve the SMS Messages received
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            // For every SMS message received
            for (int i=0; i < msgs.length; i++) {
                // Convert Object array
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                // Sender's phone number
                processText(msgs[i].getOriginatingAddress(), msgs[i].getMessageBody().toString());
            }
        }
    }


    public void processText(String originatingNumber, String contents){

        Character first = contents.charAt(0);

        switch (first){
            case 'U':
            case 'u':
               new Uber(originatingNumber).sendLocation();


                break;
            case 'M':
            case 'm':
                break;
        }

    }

}
