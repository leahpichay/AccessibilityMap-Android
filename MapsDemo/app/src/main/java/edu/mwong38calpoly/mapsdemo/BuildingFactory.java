package edu.mwong38calpoly.mapsdemo;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by DBM on 11/16/2016.
 */
//Eventual helper class to generate all our wonderful buildings... "wonderful"
public class BuildingFactory {
    public static ArrayList<Building> getAllBuildings() {
        ArrayList<Building> buildings = new ArrayList<Building>();
        return buildings;
    }

    public static Building getBuilding1(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.30117, -120.65829), null, false, null));
        entrances.add(new Entrance(new LatLng(35.30081, -120.658708), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301177, -120.65836), null, true, null));
        Building building = new Building("Administration", new LatLng(35.301051, -120.658601), entrances);

        return building;
    }

    public static Building getBuilding2(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.300345, -120.664826), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300297, -120.664284), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300209, -120.664552), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300513, -120.664444), null, true, null));
        Building building = new Building("Cotchett Education Building", new LatLng(35.300294, -120.66446), entrances);

        return building;
    }

    public static Building getBuilding14(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.300358, -120.662165), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299822, -120.662343), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299925, -120.661797), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300501, -120.662217), null, true, null));
        Building building = new Building("Frank E. Pilling", new LatLng(35.300157, -120.662231), entrances);

        return building;
    }

    public static Building getBuilding15(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.303167, -120.660341), null, false, null));
        entrances.add(new Entrance(new LatLng(35.303048, -120.660489), null, false, null));
        Building building = new Building("Cal Poly Corporation Admin", new LatLng(35.303091, -120.660329), entrances);

        return building;
    }
}
