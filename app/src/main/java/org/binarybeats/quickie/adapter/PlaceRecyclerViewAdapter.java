package org.binarybeats.quickie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.model.Place;

import java.util.ArrayList;

public class PlaceRecyclerViewAdapter extends RecyclerView.Adapter<PlaceRecyclerViewAdapter.PlaceRecyclerViewViewHolder> {

    private Context mContext;
    private ArrayList<Place> mPlaces;

    public PlaceRecyclerViewAdapter(Context context, ArrayList<Place> places) {
        mContext = context;
        mPlaces = places;
    }

    @Override
    public PlaceRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_place, parent, false);
        return new PlaceRecyclerViewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceRecyclerViewViewHolder holder, int position) {
//        Picasso.with(mContext)
//                .load(mPlaces.get(position).getPlaceImage())
//                .fit()
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .into(holder.mPlaceImage);
    }

    @Override
    public int getItemCount() {
        return mPlaces.size();
    }

    public class PlaceRecyclerViewViewHolder extends RecyclerView.ViewHolder {

        private ImageView mPlaceImage;

        public PlaceRecyclerViewViewHolder(View itemView) {
            super(itemView);
            mPlaceImage = (ImageView) itemView.findViewById(R.id.place_image);
        }
    }
}