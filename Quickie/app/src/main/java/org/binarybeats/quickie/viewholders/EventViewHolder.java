package org.binarybeats.quickie.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.binarybeats.quickie.R;

/**
 * Created by Leamsy on 4/6/2016.
 */
public class EventViewHolder extends RecyclerView.ViewHolder {

    private RecyclerView mEventRecyclerView;

    public EventViewHolder(View itemView) {
        super(itemView);
        mEventRecyclerView = (RecyclerView) itemView.findViewById(R.id.recycler_view_event);
    }

    public RecyclerView getEventRecyclerView() {
        return mEventRecyclerView;
    }
}