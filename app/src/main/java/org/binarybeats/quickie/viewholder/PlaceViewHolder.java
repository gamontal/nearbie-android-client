package org.binarybeats.quickie.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.binarybeats.quickie.R;

public class PlaceViewHolder extends RecyclerView.ViewHolder {

    private RecyclerView mPlaceRecyclerView;

    public PlaceViewHolder(View itemView) {
        super(itemView);
        mPlaceRecyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_place);
    }

    public RecyclerView getPlaceRecyclerView() {
        return mPlaceRecyclerView;
    }
}