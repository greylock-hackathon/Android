package com.example.colincooke.nameless;

import org.json.JSONObject;
import android.location.Location;

/**
 * Created by colincooke on 7/9/16.
 */
public class Maps {

    Location location;
    double zoom = 10;

    public Maps(double z) {
        zoom = z;
    }

    public void requestMap() {
        location = LocationUtils.getCurrentLocation();

        JSONObject obj = new JSONObject();

        try {
            obj.put("type", "map");
            obj.put("lon", Double.valueOf(location.getLongitude()));
            obj.put("lat", Double.valueOf(location.getLatitude()));
            obj.put("zoom", Double.valueOf(zoom));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        TextUtil.sendText("15714712696", obj.toString());
    }

}
