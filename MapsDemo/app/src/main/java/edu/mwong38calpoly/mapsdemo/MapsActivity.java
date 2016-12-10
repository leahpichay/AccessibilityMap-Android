package edu.mwong38calpoly.mapsdemo;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
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
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * TODO: All 360 image stuff should be moved to its own class.
 *
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener,
        GoogleApiClient.ConnectionCallbacks, LocationListener, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    private ArrayList<Marker> mapMarkers;
    private MarkerOptions markerOptions;
    private Building currentBuilding;
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

        if (mMap != null) {
            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

                @Override
                public boolean onMarkerClick(Marker marker) {
                    Geocoder gc = new Geocoder(MapsActivity.this);
                    return false;
                }
            });
        }

        Spinner dropDown = (Spinner) findViewById(R.id.dropDown);
        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int p = parent.getSelectedItemPosition();
                removeMarkers();
                if (p == 0) {
                    resetMap(mMap);
                } else if (p == 1) {
                    Building b = BuildingFactory.getBuilding1();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 2) {
                    Building b = BuildingFactory.getBuilding2();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 3) {
                    Building b = BuildingFactory.getBuilding3();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 4) {
                    Building b = BuildingFactory.getBuilding10();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 5) {
                    Building b = BuildingFactory.getBuilding14();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 6) {
                    Building b = BuildingFactory.getBuilding15();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 7) {
                    Building b = BuildingFactory.getBuilding19();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 8) {
                    Building b = BuildingFactory.getBuilding20();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 9) {
                    Building b = BuildingFactory.getBuilding20A();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 10) {
                    Building b = BuildingFactory.getBuilding22();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 11) {
                    Building b = BuildingFactory.getBuilding24();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 12) {
                    Building b = BuildingFactory.getBuilding25();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 13) {
                    Building b = BuildingFactory.getBuilding26();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 14) {
                    Building b = BuildingFactory.getBuilding27();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 15) {
                    Building b = BuildingFactory.getBuilding33();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 16) {
                    Building b = BuildingFactory.getBuilding34();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 17) {
                    Building b = BuildingFactory.getBuilding35();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 18) {
                    Building b = BuildingFactory.getBuilding38();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 19) {
                    Building b = BuildingFactory.getBuilding40();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 20) {
                    Building b = BuildingFactory.getBuilding43();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 21) {
                    Building b = BuildingFactory.getBuilding52();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 22) {
                    Building b = BuildingFactory.getBuilding53();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 23) {
                    Building b = BuildingFactory.getBuilding65();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 24) {
                    Building b = BuildingFactory.getBuilding124();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 25) {
                    Building b = BuildingFactory.getBuilding180();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                } else if (p == 26) {
                    Building b = BuildingFactory.getBuilding192();
                    moveToBuilding(mMap, b);
                    addBuildingEntrances(mMap, b);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Resets the map by clearing all markers and zooms out
     * @param mMap
     */
    private void resetMap(GoogleMap mMap) {
        removeMarkers();
        LatLng calPoly = new LatLng(35.304925, -120.662048);

        /*Testing polylines to draw directions.  good luck with this...*/
        /*
        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(new LatLng(35.30117, -120.65829), new LatLng(35.300358, -120.662165))
                .width(5)
                .color(Color.RED));*/

        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(calPoly, 15);
        mMap.moveCamera(update);
    }

    /**
     * Adds a building to the map.
     * @param mMap
     * @param building
     */
    private void addBuildingEntrances(GoogleMap mMap, Building building) {
        for (Entrance entrance : building.entrances) {
            addMarker(mMap, entrance);
        }
        currentBuilding = building;
    }

    /**
     * Moves the map to a building
     * @param mMap
     * @param building
     */
    private void moveToBuilding(GoogleMap mMap, Building building) {
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(building.location, 18);
        mMap.moveCamera(update);
    }

    /**
     * Adds a marker to the map.
     * @param mMap
     * @param entrance
     */
    private void addMarker(GoogleMap mMap, Entrance entrance) {
        if (mapMarkers == null)
            mapMarkers = new ArrayList<Marker>();

        MarkerOptions mOptions = markerOptions.position(entrance.location);
        Marker mark = mMap.addMarker(mOptions);
        BitmapDescriptor icon;

        if (entrance.isElevator) {
            mark.setTitle("Elevator");
            icon = BitmapDescriptorFactory.fromResource(R.mipmap.elevator);
        } else {
            mark.setTitle("Entrance");
            icon = BitmapDescriptorFactory.fromResource(R.mipmap.blue_door);
        }
        mark.setIcon(icon);
        mapMarkers.add(mark);
    }

    /**
     * Removes makers from the map
     */
    private void removeMarkers() {
        if (mapMarkers == null || mapMarkers.size() < 1)
            return;
        for (Marker mark : mapMarkers) {
            mark.remove();
        }
    }

    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    private Marker currLocationMarker;
    private LatLng latLng;

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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        //    // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        //}
        //mMap.setMyLocationEnabled(true);
        buildGoogleApiClient();
        if (mMap != null) {
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    System.out.println("HIT GET INFO CONTENTS");
                    Path p = new Path(null,null,0);

                    p.main(mMap); //For testing the a* algorithm.

                    View v = getLayoutInflater().inflate(R.layout.marker_info, null);
                    TextView markerTitle = (TextView) v.findViewById(R.id.markerTitle);
                    markerTitle.setText(marker.getTitle());
                    TextView markerText1 = (TextView) v.findViewById(R.id.markerText1);
                    TextView markerText2 = (TextView) v.findViewById(R.id.markerText2);
                    TextView markerText3 = (TextView) v.findViewById(R.id.markerText3);

                    return v;
                }
            });
        }

        // Add a marker in Cal Poly and move the camera
        LatLng calPoly = new LatLng(35.304925, -120.662048);
        Entrance cpCenter = new Entrance(calPoly, null, false, null);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(calPoly, 15);
        mMap.moveCamera(update);
        mMap.setBuildingsEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mGoogleApiClient.connect();
        mMap.setOnInfoWindowClickListener(this);
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onConnected(Bundle bundle) {
        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            //place marker at current position
            //mGoogleMap.clear();
            latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Current Position");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            currLocationMarker = mMap.addMarker(markerOptions);
        }

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(5000); //5 seconds
        mLocationRequest.setFastestInterval(3000); //3 seconds
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        //mLocationRequest.setSmallestDisplacement(0.1F); //1/10 meter

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    /**
     * Shows a 360 image.  This shoul really be its own class, but we were hacking this together.
     * @param imagePath: right now, its just the image name.
     * @throws InterruptedException
     * TODO: Scale these huge bitmaps down, and have an option to only download them through da wifis.
     */
    public void showImage(String imagePath) throws InterruptedException {
        if(imagePath == null){
            System.out.println("No image!");
            return;
        }
        System.out.println("OPENING IMAGE: " + imagePath);

        AssetManager assetManager = getAssets();
        InputStream istr = null;
        Bitmap bm = null;
        try {
            for (String s : assetManager.list(""))
            System.out.println(s);
            istr = assetManager.open(imagePath);

            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inSampleSize = 8; //Stupid OOM.  good luck with these huge a** bitmaps.
            bm=BitmapFactory.decodeStream(istr,null,options);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*If you wanted to download the URLs.  I have one image hosted on this website.
        * (1.1 I think... then I ran out of disk space xD)
        * */
        //ImageDownloader t = new ImageDownloader("http://www.calpoly.edu/~bokumura/580/" + imagePath);
        //new Thread(t).start();

        //while(t.getBitmap() == null){};
        //bm = t.getBitmap();

        if(bm != null)
            show360Img(bm);
    }

    /**
     * Displays a 360 image given a bitmap.
     * Again, this should be put in a diff class LOL.
     * @param bm bitmap to render
     */
    public void show360Img(Bitmap bm){
        Dialog builder = new Dialog(this);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });
        VrPanoramaView.Options panoOptions = new VrPanoramaView.Options();
        VrPanoramaView pv = new VrPanoramaView(this);
        pv.loadImageFromBitmap(bm, panoOptions);

        builder.addContentView(pv, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
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

    /**
     * Function is ran if a infowindow is clicked.  right now, it will show a 360 image if available.
     * @param marker
     */
    @Override
    public void onInfoWindowClick(Marker marker){
        System.out.println("HIT ON INFO WINDOW CLICK");
        try {
            for(Entrance e: currentBuilding.entrances){
                if (e.location.equals(marker.getPosition())){
                    showImage(e.imagePath);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        if (currLocationMarker != null) {
            currLocationMarker.remove();
        }
        latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        currLocationMarker = mMap.addMarker(markerOptions);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        //hmmm....
    }







    /**
     * Running an Async task to download images in another thread.  Android complians if its on
     * the main thread :/
     */
    public class ImageDownloader implements Runnable {
        private volatile Bitmap bm = null;
        private String url;

        public ImageDownloader(String url){
            this.url = url;
        }
        @Override
        public void run() {
            bm = downloadImage(url);
        }

        public Bitmap getBitmap() {
            return bm;
        }

        /*Taken from github and modified*/
        private Bitmap downloadImage(String _url) {
            URL url;
            BufferedOutputStream out;
            InputStream in;
            BufferedInputStream buf;

            try {
                url = new URL(_url);
                in = url.openStream();
                // Read the inputstream
                buf = new BufferedInputStream(in);

                // Convert the BufferedInputStream to a Bitmap\
                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inSampleSize = 8; //Stupid OOM D:
                Bitmap bMap = BitmapFactory.decodeStream(buf,null,options);
                if (in != null) {
                    in.close();
                }
                if (buf != null) {
                    buf.close();
                }

                return bMap;

            } catch (Exception e) {
                Log.e("Error reading file", e.toString());
            }
            return null;
        }
    }
}
