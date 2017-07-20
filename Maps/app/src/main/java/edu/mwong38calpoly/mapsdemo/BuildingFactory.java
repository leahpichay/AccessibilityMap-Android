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
        entrances.add(new Entrance(new LatLng(35.30117, -120.65829), "1.1.jpg", false, null));
        entrances.add(new Entrance(new LatLng(35.30081, -120.658708), "1.2.jpg", false, null));
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

    public static Building getBuilding3(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.299731, -120.664965), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299897, -120.664635), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299831, -120.664873), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300054, -120.665077), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299866, -120.664937), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300255, -120.665094), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300218, -120.664953), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300044, -120.665162), null, true, null));
        //Ramp entrances.add(new Entrance(new LatLng(35.299727, -120.664983), null, false, null));
        Building building = new Building("Business Building", new LatLng(35.300249, -120.664975), entrances);

        return building;
    }

    public static Building getBuilding10(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.302331, -120.661693), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301554, -120.661399), null, false, null));
        entrances.add(new Entrance(new LatLng(35.30257, -120.66104), null, false, null));
        entrances.add(new Entrance(new LatLng(35.302436, -120.661092), null, true, null));
        Building building = new Building("Alan A. Erhart Agriculture", new LatLng(35.302149, -120.661376), entrances);

        return building;
    }

    public static Building getBuilding14(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.300358, -120.662165), "14.1.jpg", false, null));
        entrances.add(new Entrance(new LatLng(35.299822, -120.662343), "14.2.jpg", false, null));
        entrances.add(new Entrance(new LatLng(35.299925, -120.661797), "14.3.jpg", false, null));
        entrances.add(new Entrance(new LatLng(35.300521, -120.662234), "14.7.jpg", false, null));
        entrances.add(new Entrance(new LatLng(35.300501, -120.662217), "14.4.jpg", true, null));
        //ramp entrances.add(new Entrance(new LatLng(35.300144, -120.662493), null, false, null));
        //ramp entrances.add(new Entrance(new LatLng(35.299887, -120.661709), null, false, null));
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

    public static Building getBuilding19(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.299754, -120.659444), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299842, -120.659623), null, false, null));
        entrances.add(new Entrance(new LatLng(35.29997, -120.659729), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299411, -120.659202), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299716, -120.659368), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299458, -120.659594), null, true, null));
        Building building = new Building("Dining Complex", new LatLng(35.299629, -120.659716), entrances);

        return building;
    }

    public static Building getBuilding20(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.30086, -120.661819), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300239, -120.661955), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300184, -120.66136), null, false, null));
        Building building = new Building("Engineering East", new LatLng(35.30045, -120.661529), entrances);

        return building;
    }

    public static Building getBuilding20A(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.300071, -120.661644), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300225, -120.661507), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300151, -120.661435), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300106, -120.661534), null, true, null));
        Building building = new Building("Engineering East Faculty Building", new LatLng(35.300141, -120.661558), entrances);

        return building;
    }

    public static Building getBuilding22(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.302375, -120.660872), null, false, null));
        entrances.add(new Entrance(new LatLng(35.30257, -120.66104), null, false, null));
        entrances.add(new Entrance(new LatLng(35.302436, -120.661092), null, true, null));
        Building building = new Building("English Building", new LatLng(35.302132, -120.660798), entrances);

        return building;
    }

    public static Building getBuilding24(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.303841, -120.662849), null, false, null));
        entrances.add(new Entrance(new LatLng(35.303727, -120.662814), null, false, null));
        entrances.add(new Entrance(new LatLng(35.303274, -120.662795), null, false, null));
        Building building = new Building("Food Processing", new LatLng(35.303613, -120.66299), entrances);

        return building;
    }

    public static Building getBuilding25(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.301087, -120.65929), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301142, -120.659306), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301186, -120.659316), null, true, null));
        Building building = new Building("Faculty Offices East", new LatLng(35.300824, -120.659217), entrances);

        return building;
    }

    public static Building getBuilding26(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.299523, -120.662017), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299068, -120.661945), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299223, -120.661448), null, true, null));
        Building building = new Building("Graphic Arts", new LatLng(35.299333, -120.661698), entrances);

        return building;
    }

    public static Building getBuilding27(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.297964, -120.661135), null, false, null));
        entrances.add(new Entrance(new LatLng(35.297826, -120.66107), null, false, null));
        entrances.add(new Entrance(new LatLng(35.298233, -120.660936), null, false, null));
        Building building = new Building("Health Center", new LatLng(35.297914, -120.661211), entrances);

        return building;
    }

    public static Building getBuilding33(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.302171, -120.659404), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301789, -120.659341), null, false, null));
        entrances.add(new Entrance(new LatLng(35.302249, -120.659393), null, true, null));
        Building building = new Building("Clyde P. Fisher Science", new LatLng(35.30218, -120.659344), entrances);

        return building;
    }

    public static Building getBuilding34(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.301056, -120.663224), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300977, -120.663302), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301138, -120.663332), null, true, null));
        //ramp entrances.add(new Entrance(new LatLng(35.300951, -120.662958), null, false, null));
        Building building = new Building("Walter F. Dexter Building", new LatLng(35.301112, -120.663453), entrances);

        return building;
    }

    public static Building getBuilding35(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.301914, -120.663453), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301778, -120.664158), null, true, null));
        entrances.add(new Entrance(new LatLng(35.301762, -120.664155), null, true, null));
        //ramp entrances.add(new Entrance(new LatLng(35.302133, -120.663376), null, false, null));
        Building building = new Building("Robert E. Kennedy Library", new LatLng(35.301872, -120.663834), entrances);

        return building;
    }

    public static Building getBuilding38(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.302202, -120.662411), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301528, -120.662084), null, false, null));
        entrances.add(new Entrance(new LatLng(35.30143, -120.662309), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300916, -120.662427), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301252, -120.661859), null, false, null));
        //ramp entrances.add(new Entrance(new LatLng(35.301473, -120.662459), null, false, null));
        Building building = new Building("Mathematics and Science", new LatLng(35.301672, -120.662288), entrances);

        return building;
    }

    public static Building getBuilding40(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.299119, -120.661089), null, false, null));
        entrances.add(new Entrance(new LatLng(35.299107, -120.660766), null, false, null));
        Building building = new Building("Engineering South", new LatLng(35.299247, -120.660805), entrances);

        return building;
    }

    public static Building getBuilding43(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.298612, -120.659911), null, false, null));
        entrances.add(new Entrance(new LatLng(35.298875, -120.660195), null, false, null));
        Building building = new Building("Recreation Center", new LatLng(35.298398, -120.659932), entrances);

        return building;
    }

    public static Building getBuilding52(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.300912, -120.660331), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300722, -120.659323), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300277, -120.659645), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300118, -120.660132), null, false, null));
        Building building = new Building("Science Building", new LatLng(35.300619, -120.660185), entrances);

        return building;
    }

    public static Building getBuilding53(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.302096, -120.659555), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301894, -120.659717), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301931, -120.660148), null, false, null));
        entrances.add(new Entrance(new LatLng(35.30198, -120.660134), null, true, null));
        Building building = new Building("Science North", new LatLng(35.302009, -120.659885), entrances);

        return building;
    }

    public static Building getBuilding65(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.300445, -120.658452), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300132, -120.658806), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300043, -120.658932), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300364, -120.659097), null, false, null));
        entrances.add(new Entrance(new LatLng(35.300052, -120.659101), null, true, null));
        //ramp entrances.add(new Entrance(new LatLng(35.299766, -120.65865), null, false, null));
        Building building = new Building("University Union", new LatLng(35.300298, -120.658731), entrances);

        return building;
    }

    public static Building getBuilding124(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.298581, -120.663994), null, false, null));
        entrances.add(new Entrance(new LatLng(35.298528, -120.664024), null, false, null));
        entrances.add(new Entrance(new LatLng(35.298636, -120.664057), null, true, null));
        Building building = new Building("Student Services", new LatLng(35.298535, -120.663949), entrances);

        return building;
    }

    public static Building getBuilding180(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.301089, -120.661172), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301082, -120.660854), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301199, -120.660404), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301454, -120.659721), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301557, -120.660504), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301362, -120.660819), null, false, null));
        entrances.add(new Entrance(new LatLng(35.301454, -120.660266), null, true, null));
        entrances.add(new Entrance(new LatLng(35.301188, -120.660882), null, true, null));
        Building building = new Building("Baker Science and Mathematics", new LatLng(35.301305, -120.660576), entrances);

        return building;
    }

    public static Building getBuilding192(){
        ArrayList<Entrance> entrances = new ArrayList<Entrance>();
        entrances.add(new Entrance(new LatLng(35.302884, -120.665048), null, false, null));
        entrances.add(new Entrance(new LatLng(35.302895, -120.665043), null, false, null));
        entrances.add(new Entrance(new LatLng(35.30325, -120.664313), null, false, null));
        entrances.add(new Entrance(new LatLng(35.302641, -120.665335), null, false, null));
        entrances.add(new Entrance(new LatLng(35.30274, -120.665008), null, true, null));
        Building building = new Building("Engineering IV", new LatLng(35.302891, -120.664785), entrances);

        return building;
    }
}












































