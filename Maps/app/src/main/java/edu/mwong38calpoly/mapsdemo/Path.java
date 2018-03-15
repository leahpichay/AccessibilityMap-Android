package edu.mwong38calpoly.mapsdemo;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

/**
 * Created by bokumura on 12/0/16? <- heehee.
 */

public class Path {

    private LatLng origin;
    private LatLng destination;
    int type;
    /*
     * 0 == Everyone
     * 1 == Meh. Might be unreachable by some.
     * 2 = Nope. Stairs suck.
     */

    /* Ranking can be changed later. */
    Path (LatLng p1, LatLng p2, int type) {
        this.origin = p1;
        this.destination = p2;
        this.type = type;
    }

    String getUrl() {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + destination.latitude + "," + destination.longitude;

        // Sensor enabled
        String mode = "mode=walking";

        // Building the parameters to the web service
        String parameters = "&" + mode + "&" + str_origin + "&" + str_dest;

        // Output format
        String output = "json";

        // Building the url to the web service
        return "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

    }

}
