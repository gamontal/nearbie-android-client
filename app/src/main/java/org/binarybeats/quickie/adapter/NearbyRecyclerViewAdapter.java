package org.binarybeats.quickie.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.yqritc.recyclerviewflexibledivider.FlexibleDividerDecoration;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.model.Event;
import org.binarybeats.quickie.model.Place;
import org.binarybeats.quickie.model.User;
import org.binarybeats.quickie.viewholder.EventViewHolder;
import org.binarybeats.quickie.viewholder.HeaderViewHolder;
import org.binarybeats.quickie.viewholder.PlaceViewHolder;
import org.binarybeats.quickie.viewholder.UserViewHolder;

import java.util.ArrayList;

public class NearbyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
        implements FlexibleDividerDecoration.VisibilityProvider,
        HorizontalDividerItemDecoration.MarginProvider {

    private final int PLACE_HEADER_POSITION = 0;
    private final int PLACE_RECYCLER_VIEW_POSITION = 1;
    private final int EVENT_HEADER_POSITION = 2;
    private final int EVENT_RECYCLER_VIEW_POSITION = 3;
    private final int USER_HEADER_POSITION = 4;

    private final int PLACE_HEADER = 0;
    private final int PLACE = 1;
    private final int EVENT_HEADER = 2;
    private final int EVENT = 3;
    private final int USER_HEADER = 4;
    private final int USER = 5;

    private Context mContext;
    private ArrayList<Place> mPlaces;
    private ArrayList<Event> mEvents;
    private ArrayList<User> mUsers;

    public NearbyRecyclerViewAdapter(Context context, ArrayList<Place> places,
                                     ArrayList<Event> events, ArrayList<User> users) {

        mContext = context;
        mPlaces = places;
        mEvents = events;
        mUsers = users;
    }

    @Override
    public int getItemViewType(int position) {

        switch (position) {
            case PLACE_HEADER_POSITION:
                return PLACE_HEADER;
            case PLACE_RECYCLER_VIEW_POSITION:
                return PLACE;
            case EVENT_HEADER_POSITION:
                return EVENT_HEADER;
            case EVENT_RECYCLER_VIEW_POSITION:
                return EVENT;
            case USER_HEADER_POSITION:
                return USER_HEADER;
            default:
                return USER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case PLACE_HEADER:
                View headerPlaceView = inflater.inflate(R.layout.item_header, parent, false);
                viewHolder = new HeaderViewHolder(headerPlaceView);
                break;
            case PLACE:
                View placeView = inflater.inflate(R.layout.layout_place, parent, false);
                viewHolder = new PlaceViewHolder(placeView);
                break;
            case EVENT_HEADER:
                View headerEventView = inflater.inflate(R.layout.item_header, parent, false);
                viewHolder = new HeaderViewHolder(headerEventView);
                break;
            case EVENT:
                View eventView = inflater.inflate(R.layout.layout_event, parent, false);
                viewHolder = new EventViewHolder(eventView);
                break;
            case USER_HEADER:
                View headerUserView = inflater.inflate(R.layout.item_header, parent, false);
                viewHolder = new HeaderViewHolder(headerUserView);
                break;
            case USER:
                View userView = inflater.inflate(R.layout.item_user, parent, false);
                viewHolder = new UserViewHolder(userView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case PLACE_HEADER:
                HeaderViewHolder headerPlaceViewHolder = (HeaderViewHolder) holder;
                headerPlaceViewHolder.getHeader().setText("Places");
                break;
            case PLACE:
                PlaceViewHolder placeViewHolder = (PlaceViewHolder) holder;
                LinearLayoutManager placeLayout = new LinearLayoutManager(mContext);
                placeLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
                placeViewHolder.getPlaceRecyclerView().setLayoutManager(placeLayout);
                placeViewHolder.getPlaceRecyclerView()
                        .setAdapter(new PlaceRecyclerViewAdapter(mContext, mPlaces));
                break;
            case EVENT_HEADER:
                HeaderViewHolder headerEventViewHolder = (HeaderViewHolder) holder;
                headerEventViewHolder.getHeader().setText("Events");
                break;
            case EVENT:
                EventViewHolder eventViewHolder = (EventViewHolder) holder;
                LinearLayoutManager eventLayout = new LinearLayoutManager(mContext);
                eventLayout.setOrientation(LinearLayoutManager.HORIZONTAL);
                eventViewHolder.getEventRecyclerView().setLayoutManager(eventLayout);
                eventViewHolder.getEventRecyclerView()
                        .setAdapter(new EventRecyclerViewAdapter(mContext, mEvents));
                break;
            case USER_HEADER:
                HeaderViewHolder headerUserViewHolder = (HeaderViewHolder) holder;
                headerUserViewHolder.getHeader().setText("Users");
                break;
            case USER:
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                Picasso.with(mContext)
                        .load(mUsers.get(position - 5).getProfileImage())
                        .fit()
                        .centerCrop()
                        .placeholder(R.mipmap.ic_launcher)
                        .into(userViewHolder.getProfileImage());
                userViewHolder.getUsername().setText(mUsers.get(position - 5).getUsername());
                userViewHolder.getStatus().setText(mUsers.get(position - 5).getStatus());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return itemsCount();
    }

    private int itemsCount() {

        // Simplificar...

        if (mPlaces.isEmpty() && mEvents.isEmpty() && !mUsers.isEmpty()) {
            return mUsers.size() + 1;
        } else if (mPlaces.isEmpty() && !mEvents.isEmpty() && mUsers.isEmpty()) {
            return 2;
        } else if (!mPlaces.isEmpty() && mEvents.isEmpty() && mUsers.isEmpty()) {
            return 2;
        } else if (mPlaces.isEmpty() && !mEvents.isEmpty() && !mUsers.isEmpty()) {
            return mUsers.size() + 1 + 2;
        } else if (!mPlaces.isEmpty() && mEvents.isEmpty() && !mUsers.isEmpty()) {
            return mUsers.size() + 1 + 2;
        } else if (!mPlaces.isEmpty() && !mEvents.isEmpty() && mUsers.isEmpty()) {
            return 2 + 2;
        } else if (!mPlaces.isEmpty() && !mEvents.isEmpty() && !mUsers.isEmpty()) {
            return mUsers.size() + 1 + 2 + 2;
        } else if (mPlaces.isEmpty() && mEvents.isEmpty() && mUsers.isEmpty()) {
            return 0;
        }
        return -1;
    }

    @Override
    public boolean shouldHideDivider(int position, RecyclerView parent) {
        switch (position) {
            case PLACE_HEADER_POSITION:
                return true;

            case 1:
                return true;
            case EVENT_HEADER_POSITION:
                return true;
            case 3:
                return true;
            case USER_HEADER_POSITION:
                return true;
        }

        return false;
    }

    @Override
    public int dividerLeftMargin(int position, RecyclerView parent) {
        switch (position) {
            case PLACE_RECYCLER_VIEW_POSITION:
                return 0;
            case EVENT_RECYCLER_VIEW_POSITION:
                return 0;
        }
        return (int) parent.getContext().getResources().getDimension(R.dimen.item_left_padding);
    }

    @Override
    public int dividerRightMargin(int position, RecyclerView parent) {
        return 0;
    }
}