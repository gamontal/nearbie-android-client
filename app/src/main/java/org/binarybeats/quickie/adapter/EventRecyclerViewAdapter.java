package org.binarybeats.quickie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.model.Event;

import java.util.ArrayList;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.EventRecyclerViewViewHolder> {

    private Context mContext;
    private ArrayList<Event> mEvents;

    public EventRecyclerViewAdapter(Context context, ArrayList<Event> events) {
        mContext = context;
        mEvents = events;
    }

    @Override
    public EventRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventRecyclerViewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EventRecyclerViewViewHolder holder, int position) {
//        Picasso.with(mContext)
//                .load(mEvents.get(position).getEventImage())
//                .fit()
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .into(holder.mEventImage);
//        holder.mEventName.setText(mEvents.get(position).getEventName());
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class EventRecyclerViewViewHolder extends RecyclerView.ViewHolder {

        private ImageView mEventImage;
        private TextView mEventName;

        public EventRecyclerViewViewHolder(View itemView) {
            super(itemView);
            mEventImage = (ImageView) itemView.findViewById(R.id.event_image);
            mEventName = (TextView) itemView.findViewById(R.id.event_name);
        }
    }
}