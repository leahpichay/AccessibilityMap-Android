package edu.mwong38calpoly.mapsdemo;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageView;

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
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * TODO: All 360 image stuff should be moved to its own class.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener,
        GoogleApiClient.ConnectionCallbacks, LocationListener, GoogleApiClient.OnConnectionFailedListener {

    private LatLng origin = new LatLng(35.300240, -120.664044);
    private LatLng destination;

    private Building currentBuilding;
    private Polyline currentPath;
    private Marker currentOrigin;
    private Marker currentDest;

    private GoogleMap mMap;
    private ArrayList<Marker> mapMarkers;
    private ArrayList<Marker> markersWithPicture;
    private MarkerOptions markerOptions;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustToPath();
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
        currentBuilding = building;
    }

    private void moveToBuilding(GoogleMap mMap, Building building) {
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(building.location, 18);
        mMap.moveCamera(update);
    }

    private void addMarker(GoogleMap mMap, Entrance entrance) {
        if (mapMarkers == null)
            mapMarkers = new ArrayList<Marker>();
        if (markersWithPicture == null)
            markersWithPicture = new ArrayList<Marker>();

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

        if (entrance.imagePath != null) {
            markersWithPicture.add(mark);
        }

        mark.setIcon(icon);
        mapMarkers.add(mark);
    }

    private void removeMarkers() {
        if (mapMarkers == null || mapMarkers.size() < 1)
            return;
        for (Marker mark : mapMarkers) {
            mark.remove();
        }
    }

    private void adjustToPath() {
        boolean hasPoints = false;
        Double maxLat = null, minLat = null, minLon = null, maxLon = null;

        if (currentPath != null && currentPath.getPoints() != null) {
            List<LatLng> pts = currentPath.getPoints();
            for (LatLng coordinate : pts) {
                // Find out the maximum and minimum latitudes & longitudes
                // Latitude
                maxLat = maxLat != null ? Math.max(coordinate.latitude, maxLat) : coordinate.latitude;
                minLat = minLat != null ? Math.min(coordinate.latitude, minLat) : coordinate.latitude;

                // Longitude
                maxLon = maxLon != null ? Math.max(coordinate.longitude, maxLon) : coordinate.longitude;
                minLon = minLon != null ? Math.min(coordinate.longitude, minLon) : coordinate.longitude;

                hasPoints = true;
            }
        }

        if (hasPoints) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(new LatLng(maxLat, maxLon));
            builder.include(new LatLng(minLat, minLon));
            mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 48));
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
        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
        if (mMap != null) {
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    if (currentOrigin != null) { currentOrigin.remove(); }
                    if (currentDest != null) { currentDest.remove(); }

                    currentOrigin = mMap.addMarker(new MarkerOptions()
                            .position(origin)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                    destination = marker.getPosition();
                    currentDest = mMap.addMarker(new MarkerOptions().position(destination));
                    Path p = new Path(origin,destination,0);

                    if (currentPath != null) { currentPath.remove(); }

                    // Getting URL to the Google Directions API
                    FetchUrl FetchUrl = new FetchUrl();

                    // Start downloading json data from Google Directions API
                    FetchUrl.execute(p.getUrl());

                    View v = getLayoutInflater().inflate(R.layout.marker_info, null);
                    TextView markerTitle = (TextView) v.findViewById(R.id.markerTitle);
                    markerTitle.setText(marker.getTitle());

                    if (marker.getTitle().equals("Elevator")) {
                        TextView markerText1 = (TextView) v.findViewById(R.id.markerText1);
                        markerText1.setVisibility(View.VISIBLE);
                        TextView markerText2 = (TextView) v.findViewById(R.id.markerText2);
                        markerText2.setVisibility(View.VISIBLE);
                        TextView markerText3 = (TextView) v.findViewById(R.id.markerText3);
                        markerText3.setVisibility(View.VISIBLE);
                    }

                    if (markersWithPicture.contains(marker)) {
                        ImageView markerImage = (ImageView) v.findViewById(R.id.markerImage);
                        markerImage.setImageResource(R.mipmap.has_photo);
                    }

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
        //Toast.makeText(this,"onConnectionSuspended",Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a 360 image.  This shoul really be its own class, but we were hacking this together.
     * @param imagePath: Currently, it is just the image name.
     * @throws InterruptedException
     * TODO: Scale these huge bitmaps down, and have an option to only download them through da wifis.
     */
    public void showImage(String imagePath) throws InterruptedException {
        if(imagePath == null){
            //System.out.println("No image!");
            return;
        }
        //System.out.println("OPENING IMAGE: " + imagePath);
        AssetManager assetManager = getAssets();
        InputStream istr = null;
        Bitmap bm = null;

        try {
            //for (String s : assetManager.list(""))
                //System.out.println(s);

            istr = assetManager.open(imagePath);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8; //Stupid OOM. Good luck with these huge a** bitmaps.
            bm = BitmapFactory.decodeStream(istr,null,options);
        }
        catch (IOException e) { e.printStackTrace(); }

        /* If you wanted to download the URLs.
         * I have one image hosted on this website.
         * (1.1 I think... then I ran out of disk space xD)
         */
        //ImageDownloader t = new ImageDownloader("http://www.calpoly.edu/~bokumura/580/" + imagePath);
        //new Thread(t).start();

        //while(t.getBitmap() == null){};
        //bm = t.getBitmap();

        if (bm != null) { show360Img(bm); }
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
        if (mGoogleApiClient!= null && !mGoogleApiClient.isConnected())
            mGoogleApiClient.connect();
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
     * Runs if an InfoWindow is clicked.
     * Shows a 360 image if available.
     * @param marker
     */
    @Override
    public void onInfoWindowClick(Marker marker) {
        try {
            for (Entrance e: currentBuilding.entrances) {
                if (e.location.equals(marker.getPosition())) {
                    showImage(e.imagePath);
                }
            }
        }
        catch (InterruptedException e) { e.printStackTrace(); }
    }

    @Override
    public void onLocationChanged(Location location) {
        if (currLocationMarker != null) { currLocationMarker.remove(); }
        latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        currLocationMarker = mMap.addMarker(markerOptions);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        //Toast.makeText(this,"onConnectionFailed", Toast.LENGTH_SHORT).show();
    }

    /**
     * Running an Async task to download images in another thread.
     * Android complains if it is on the main thread :/
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
        /* Taken from github and modified. */
        private Bitmap downloadImage(String _url) {
            URL url;
            BufferedOutputStream out;
            InputStream in;
            BufferedInputStream buf;

            try {
                url = new URL(_url);
                in = url.openStream();

                // Read the InputStream
                buf = new BufferedInputStream(in);

                // Convert the BufferedInputStream to a Bitmap
                BitmapFactory.Options options=new BitmapFactory.Options();
                options.inSampleSize = 8; //Stupid OOM
                Bitmap bMap = BitmapFactory.decodeStream(buf,null,options);
                if (in != null) { in.close(); }
                if (buf != null) { buf.close(); }

                return bMap;
            }
            catch (Exception e) { Log.e("Error reading file", e.toString()); }

            return null;
        }
    }

    /**
     * A method to download json data from url
     */
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());
            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class FetchUrl extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                Log.d("Background Task data", data.toString());
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }

    /**
     * A class to parse the Google Places in JSON format
     */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                Log.d("ParserTask",jsonData[0].toString());
                DataParser parser = new DataParser();
                Log.d("ParserTask", parser.toString());

                // Starts parsing data
                routes = parser.parse(jObject);
                Log.d("ParserTask","Executing routes");
                Log.d("ParserTask",routes.toString());

            } catch (Exception e) {
                Log.d("ParserTask",e.toString());
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.BLUE);

                Log.d("onPostExecute","onPostExecute lineoptions decoded");

            }

            // Drawing polyline in the Google Map for the i-th route
            if(lineOptions != null) {
                currentPath = mMap.addPolyline(lineOptions);
            }
            else {
                Log.d("onPostExecute","without Polylines drawn");
            }
        }
    }
}