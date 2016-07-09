package com.example.colincooke.nameless;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.internal.LocationRequestUpdateData;

import org.json.JSONObject;

/**
 * Created by colincooke on 7/9/16.
 */
public class LocationUtils {

    private static PlayWrapper playWrapper;

    public static Location getCurrentLocation() {
        return getPlayWrapper().getCurrentLocation();
    }

    public static void init() {
        getPlayWrapper();
    }

    private static PlayWrapper getPlayWrapper() {
        if (playWrapper == null) {
            playWrapper = new PlayWrapper(Nameless.getAppContext());
        }
        return playWrapper;
    }

    private static class PlayWrapper implements
            GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

        GoogleApiClient apiClient;
        boolean connected = false;

        Location mLocation = null;

        public PlayWrapper(Context context) {

            apiClient = new GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
            apiClient.connect();


            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            } else {
            }

            mLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient);
            LocationServices.FusedLocationApi.requestLocationUpdates(apiClient, getLocationRequest(), this);
        }

        private LocationRequest getLocationRequest() {
            return new LocationRequest().setInterval(1000).setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        }

        public Location getCurrentLocation() {
            return mLocation;
        }

        @Override
        public void onConnected(@Nullable Bundle bundle) {
            connected = true;
        }

        @Override
        public void onConnectionSuspended(int i) {
            connected = false;
        }

        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            connected = false;
        }

        @Override
        public void onLocationChanged(Location location) {
            mLocation = location;
        }
    }


}
