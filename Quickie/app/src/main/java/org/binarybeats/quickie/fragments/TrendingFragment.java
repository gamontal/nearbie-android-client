package org.binarybeats.quickie.fragments;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.models.MapMarker;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendingFragment extends Fragment implements OnMapReadyCallback {

    public TrendingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trending, container, false);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        return view;
    }

    // Declare a variable for the cluster manager.
    private ClusterManager<MapMarker> mClusterManager;

    @Override
    public void onMapReady(GoogleMap googleMap) {

        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setRotateGesturesEnabled(false);



        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.marker_circle, null);
        Canvas canvas = new Canvas();
        int width = getResources().getDimensionPixelOffset(R.dimen.marker_size);
        int height = getResources().getDimensionPixelOffset(R.dimen.marker_size);
        drawable.setBounds(0, 0, width, height);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.draw(canvas);
        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap);



        // Position the map.
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(18.2418833, -66.0066341), 9f));
//        googleMap.addMarker(new MarkerOptions()
//                .position(new LatLng(18.2418833, -66.0066341))
//                .title("Hack Turabo")
//                .icon(bitmapDescriptor));

        // Initialize the manager with the context and the map.
        // (Activity extends context, so we can pass 'this' in the constructor.)
        mClusterManager = new ClusterManager<>(getContext(), googleMap);
        mClusterManager.setRenderer(new OwnIconRendered(getContext(), googleMap, mClusterManager));

        // Point the map's listeners at the listeners implemented by the cluster manager.
        googleMap.setOnCameraChangeListener(mClusterManager);
        googleMap.setOnMarkerClickListener(mClusterManager);



        mClusterManager.addItem(new MapMarker(18.2418833, -66.0066341, bitmapDescriptor));
        mClusterManager.addItem(new MapMarker(18.256305, -66.125411, bitmapDescriptor));
        mClusterManager.addItem(new MapMarker(18.282305, -66.052411, bitmapDescriptor));
        mClusterManager.addItem(new MapMarker(18.125017, -66.008691, bitmapDescriptor));
        mClusterManager.addItem(new MapMarker(18.351231, -65.996612, bitmapDescriptor));
        mClusterManager.addItem(new MapMarker(18.301231, -65.946612, bitmapDescriptor));
        mClusterManager.addItem(new MapMarker(18.383037, -66.037965, bitmapDescriptor));


//        addDummyItems1(bitmapDescriptor);
//        addDummyItems2(bitmapDescriptor);
//        addDummyItems3(bitmapDescriptor);
    }

    private void addDummyItems1(BitmapDescriptor bitmapDescriptor) {

        // Set some lat/lng coordinates to start with.
        double lat = 18.2418833;
        double lng = -66.0066341;

        // Add ten cluster items in close proximity, for purposes of this example.
        for (int i = 0; i < 10; i++) {
            double offset = i / 500d;
            lat = lat + offset;
            lng = lng + offset;
            MapMarker offsetItem = new MapMarker(lat, lng, bitmapDescriptor);
            mClusterManager.addItem(offsetItem);
        }
    }

    private void addDummyItems2(BitmapDescriptor bitmapDescriptor) {

        // Set some lat/lng coordinates to start with.
        double lat = 18.127021;
        double lng = -66.890701;

        // Add ten cluster items in close proximity, for purposes of this example.
        for (int i = 0; i < 6; i++) {
            double offset = i / 500d;
            lat = lat + offset;
            lng = lng + offset;
            MapMarker offsetItem = new MapMarker(lat, lng, bitmapDescriptor);
            mClusterManager.addItem(offsetItem);
        }
    }

    private void addDummyItems3(BitmapDescriptor bitmapDescriptor) {

        // Set some lat/lng coordinates to start with.
        double lat = 18.303319;
        double lng = -66.600747;

        // Add ten cluster items in close proximity, for purposes of this example.
        for (int i = 0; i < 7; i++) {
            double offset = i / 500d;
            lat = lat + offset;
            lng = lng + offset;
            MapMarker offsetItem = new MapMarker(lat, lng, bitmapDescriptor);
            mClusterManager.addItem(offsetItem);
        }
    }


}