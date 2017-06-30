package a.logintest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;





import static a.logintest.R.id.map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(this);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final int[] counter = {1};




        LatLng coordinate = new LatLng(14.595107, 120.987977);//Declare Coordinate

        CameraUpdate yourLocation = CameraUpdateFactory.newLatLngZoom(coordinate, 17);// Zoom w/ 15
        mMap.animateCamera(yourLocation); /// Zoom


        mMap.addMarker(new MarkerOptions() // Set Marker
                .position(coordinate)
                .title("You are here")
                .snippet("Insert Event Details Here")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));



        // WHen map is clicked
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){



            int counter=1;
            @Override
            public void onMapClick(LatLng point) {


                LatLng cursorcoordinate = new LatLng(point.latitude, point.longitude);// Set current click location to marker

                MarkerOptions marker = new MarkerOptions().position(cursorcoordinate)
                        .title("MarkerID: " + counter)
                        .snippet("Event details here")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));

                mMap.addMarker(marker);
                counter++;

                System.out.println(point.latitude + "---" + point.longitude);
            }
        });


    }




}
