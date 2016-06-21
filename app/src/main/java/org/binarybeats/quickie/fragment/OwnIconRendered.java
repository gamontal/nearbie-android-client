package org.binarybeats.quickie.fragment;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import org.binarybeats.quickie.model.MapMarker;

public class OwnIconRendered extends DefaultClusterRenderer<MapMarker> {

    public OwnIconRendered(Context context, GoogleMap map, ClusterManager<MapMarker> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(MapMarker item, MarkerOptions markerOptions) {
//        super.onBeforeClusterItemRendered(item, markerOptions);

        markerOptions.icon(item.getmBitmapDescriptor());
    }
}
