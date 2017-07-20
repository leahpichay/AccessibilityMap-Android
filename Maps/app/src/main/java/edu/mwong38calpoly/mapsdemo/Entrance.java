package edu.mwong38calpoly.mapsdemo;

import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by DBM on 11/16/2016.
 */
public class Entrance {
    public LatLng location;
    public boolean isElevator;
    public ArrayList<String> tags;
    //public NativeAd.Image image; //just a placeholder, no idea what future images will be like or how to display
    public String imagePath; //path or url of the 360 Image

    public Entrance(LatLng location, String imagePath, boolean isElevator, ArrayList<String> tags) {
        this.location = location;
        this.imagePath = imagePath;
        this.isElevator = isElevator;
        this.tags = tags;
    }
}
