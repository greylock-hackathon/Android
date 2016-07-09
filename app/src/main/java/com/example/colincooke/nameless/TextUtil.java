package com.example.colincooke.nameless;

import android.app.PendingIntent;
import android.telephony.SmsManager;

/**
 * Created by colincooke on 7/9/16.
 */
public class TextUtil {


    public static void sendText(String phonenumber, String text) {
        sendText(phonenumber, text, null);
    }


    public static void sendText(String phonenumber, String text, PendingIntent deliveryIntent) {

        SmsManager smsManager = SmsManager.getDefault();

        smsManager.sendTextMessage(phonenumber, null, text, null, deliveryIntent);

    }


}
