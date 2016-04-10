package org.binarybeats.quickie.models;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Leamsy on 4/9/2016.
 */
public class MapMarker implements ClusterItem {

    private final LatLng mPosition;
    private BitmapDescriptor mBitmapDescriptor;

    public MapMarker(double lat, double lng, BitmapDescriptor bitmapDescriptor) {
        mPosition = new LatLng(lat, lng);
        mBitmapDescriptor = bitmapDescriptor;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    public BitmapDescriptor getmBitmapDescriptor() {
        return mBitmapDescriptor;
    }
}