package edu.mwong38calpoly.mapsdemo;

import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by DBM on 11/16/2016.
 */
public class Entrance {
    public LatLng location;
    public NativeAd.Image image; //just a placeholder, no idea what future images will be like or how to display

    public Entrance(LatLng location, NativeAd.Image image) {
        this.location = location;
        this.image = image;
    }
}
