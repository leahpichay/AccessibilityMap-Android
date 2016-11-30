package edu.mwong38calpoly.mapsdemo;

import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Marker> mapMarkers;
    private MarkerOptions markerOptions;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    private ArrayList<Building> buildings = new ArrayList<Building>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        markerOptions = new MarkerOptions();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        if(mMap != null) {
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

                @Override
                public boolean onMarkerClick(Marker marker) {
                    Geocoder gc = new Geocoder(MapsActivity.this);
                    return false;
                }
            });
        }

        ArrayList<Entrance> eeEntrances = new ArrayList<Entrance>();
        eeEntrances.add(new Entrance(new LatLng(35.300217,-120.661962), null, false, null));
        eeEntrances.add(new Entrance(new LatLng(35.300890,-120.661810), null, false, null));
        eeEntrances.add(new Entrance(new LatLng(35.300222,-120.661402), null, false, null));
        final Building eeBuilding = new Building("Engineering East", new LatLng(35.300459, -120.661537), eeEntrances);

        //Kennedy Library!
        ArrayList<Entrance> klEntrances = new ArrayList<Entrance>();
        klEntrances.add(new Entrance(new LatLng(35.3018246, -120.6636285), null, false, null));
        final Building klBuilding = new Building("Kennedy Library", new LatLng(35.301775, -120.663809), klEntrances);

        Spinner dropDown = (Spinner) findViewById(R.id.dropDown);
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = parent.getSelectedItemPosition();
                if(pos == 0) {
                    resetMap(mMap);
                }
                else if(pos == 1) {
                    Building b = BuildingFactory.getBuilding1();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                }
                else if(pos == 2) {
                    Building b = BuildingFactory.getBuilding2();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                }
                else if(pos == 3) {
                    Building b = BuildingFactory.getBuilding14();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                }
                else if(pos == 4) {
                    Building b = BuildingFactory.getBuilding15();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                }
                else if(parent.getSelectedItemPosition() == 5) {
                    removeMarkers();
                    moveToBuilding(mMap, eeBuilding);
                    addBuildingEntrances(mMap, eeBuilding);
                }
                else if(parent.getSelectedItemPosition() == 6) {
                    removeMarkers();
                    moveToBuilding(mMap, klBuilding);
                    addBuildingEntrances(mMap,klBuilding);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void resetMap(GoogleMap mMap) {
        removeMarkers();
        LatLng calPoly = new LatLng(35.304925, -120.662048);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(calPoly, 15);
        mMap.moveCamera(update);
    }

    private void addBuildingEntrances(GoogleMap mMap, Building building) {
        for (Entrance entrance : building.entrances) {
            addMarker(mMap, entrance);
        }
    }

    private void moveToBuilding(GoogleMap mMap, Building building) {
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(building.location, 18);
        mMap.moveCamera(update);
    }

    private void addMarker(GoogleMap mMap, Entrance entrance) {
        if(mapMarkers == null)
            mapMarkers = new ArrayList<Marker>();

        MarkerOptions mOptions = markerOptions.position(entrance.location);
        Marker mark = mMap.addMarker(mOptions);
        if (entrance.isElevator) {
            mark.setTitle("Elevator");
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.mipmap.elevator);
            mark.setIcon(icon);
        }
        else {
            mark.setTitle("Entrance");
            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.mipmap.blue_door);
            mark.setIcon(icon);
        }
        mapMarkers.add(mark);
    }

    private void removeMarkers() {
        if(mapMarkers == null || mapMarkers.size()<1)
            return;
        for(Marker mark : mapMarkers) {
            mark.remove();
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        if(mMap != null) {
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }
                @Override
                public View getInfoContents(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.marker_info, null);
                    TextView markerTitle = (TextView)v.findViewById(R.id.markerTitle);
                    if (markerTitle!=null && marker!=null) {
                        markerTitle.setText(marker.getTitle());
                    }
                    TextView markerText1 = (TextView)v.findViewById(R.id.markerText1);
                    TextView markerText2 = (TextView)v.findViewById(R.id.markerText2);
                    TextView markerText3 = (TextView)v.findViewById(R.id.markerText3);

                    return v;
                }
            });
        }

        // Add a marker in Cal Poly and move the camera
        LatLng calPoly = new LatLng(35.304925, -120.662048);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(calPoly, 15);
        mMap.moveCamera(update);
        mMap.setBuildingsEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.mwong38calpoly.mapsdemo/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.mwong38calpoly.mapsdemo/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
