/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mapdemo;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class PZP extends AppCompatActivity
        implements GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, GoogleMap.OnCameraChangeListener,
        OnMapReadyCallback {

    private TextView mTapTextView;

    private TextView mCameraTextView;


    private GoogleMap mMap;

    private UiSettings mUISettings;


    public LatLng POS_DC = new LatLng(43.47263807808989, -80.54214913398027);
    public LatLng POS_EloraLibrary = new LatLng(43.68390318064219,-80.43112613260746);

//    Marker markDC = (new Marker()
//            .position(POS_DC)
//            .title("DC Library")
//            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));

//    public static int minZoom;


//    private LatLngBounds AUSTRALIA = new LatLngBounds(new LatLng(-44, 113), new LatLng(-10, 154));



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_demo);

//        // This box shows the CameraPosition, located below Top blue box.
//        mTapTextView = (TextView) findViewById(R.id.tap_text);
//        mCameraTextView = (TextView) findViewById(R.id.camera_text);
//
//        SupportMapFragment mapFragment =
//                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we
     * just add a marker near Africa.
     */
    @Override
    public void onMapReady(GoogleMap map) {

        map.addMarker(new MarkerOptions()
                .position(POS_DC)
                .title("DC Library")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        map.addMarker(new MarkerOptions()
                .position(POS_EloraLibrary)
                .title("Elora Public Library")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
//        map.addMarker(new MarkerOptions()
//                .position(new LatLng(43.600681479915146,-80.56106708943844))
//                .title("North Waterloo Veterinary Hospital")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));

        mMap = map;
        mUISettings = mMap.getUiSettings();

/*      Modifying Settings  */
//        mMap.setMyLocationEnabled(true);
        mMap.setIndoorEnabled(false);
        mMap.getMinZoomLevel();       // If exist, 10
        mMap.getMaxZoomLevel();
//        minZoom = GoogleMap.getMaxZoomLevel();


//        mMap.getCameraPosition()      // still need to get camera target position
        mMap.setBuildingsEnabled(true);
        mUISettings.setRotateGesturesEnabled(false);
        mUISettings.setTiltGesturesEnabled(false);
        mUISettings.setZoomControlsEnabled(true);   // expecting to be +/- option
        mUISettings.setCompassEnabled(true);
        mUISettings.setMyLocationButtonEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(POS_DC, 17.0f));


//  Scaling and Zooming factor not working...
        CameraUpdateFactory.scrollBy(200.0f, 200.0f);

        // give you a CameraUpdate that increases (or decreases, if the value is
        // negative) the zoom level by the given value.
        CameraUpdateFactory.zoomBy(200000000);


        map.setOnMapClickListener(this);
        map.setOnMapLongClickListener(this);
        map.setOnCameraChangeListener(this);


        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            // Listener for change in Zoom
            private float currentZoom = -1;
            @Override
            public void onCameraChange(CameraPosition pos) {
                if (pos.zoom != currentZoom){
                    currentZoom = pos.zoom;
                    // shall save data!
                    System.out.println("----------***-----------");
                }
            }
        });

//        mMap.setOnMarkerClickListener();

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latlng) {
                System.out.println("         ========== *** ==========>          ");
//                Intent intent = new Intent(MapActivity.this,
//                        ForecastActivity.class);
//                Bundle extras = new Bundle();
//                extras.putParcelable(SyncStateContract.Constants.PARAM_LATLNG, latlng);
//                intent.putExtras(extras);
//                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
//                        | Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
            }
        });






    }

    @Override
    public void onMapClick(LatLng point) {
        mTapTextView.setText("tapped, point=" + point);
    }

    @Override
    public void onMapLongClick(LatLng point) {
        mTapTextView.setText("long pressed, point=" + point);
    }

    @Override
    public void onCameraChange(final CameraPosition position) {
        mCameraTextView.setText(position.toString());
    }





}
