package edu.mwong38calpoly.mapsdemo;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by DBM on 11/16/2016.
 */
public class Building {
    public String name;
    public LatLng location; //'center' of building
    public ArrayList<Entrance> entrances;

    public Building(String name, LatLng location, ArrayList<Entrance> entrances) {
        this.name = name;
        this.location = location;
        this.entrances = entrances;
    }
}
