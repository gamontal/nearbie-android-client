package org.binarybeats.quickie.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.adapters.NearbyRecyclerViewAdapter;
import org.binarybeats.quickie.adapters.RecyclerItemClickListener;
import org.binarybeats.quickie.models.Event;
import org.binarybeats.quickie.models.Place;
import org.binarybeats.quickie.models.User;

import java.util.ArrayList;

public class NearbyFragment extends Fragment {

    public NearbyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment.
        View view = inflater.inflate(R.layout.fragment_nearby, container, false);

        RecyclerView mRecyclerViewNearby =
                (RecyclerView) view.findViewById(R.id.recycler_view_nearby);

        mRecyclerViewNearby.setLayoutManager(new LinearLayoutManager(container.getContext()));

        NearbyRecyclerViewAdapter adapter = new NearbyRecyclerViewAdapter(
                container.getContext(), dummyPlaces(), dummyEvents(), dummyUsers());

        mRecyclerViewNearby.addOnItemTouchListener(
                new RecyclerItemClickListener(container.getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // TODO Handle item click

                        if (position == 0 || position == 1 || position == 2 || position == 3 || position == 4) {

                        } else {

                            // Public Profile Dialog
                            CustomDialogFragment customDialogFragment = new CustomDialogFragment(getContext(), users.get(position-5));
                            FragmentManager fragmentManager = getChildFragmentManager();
                            customDialogFragment.show(fragmentManager, "dialog");

                        }


                    }
                })
        );

        mRecyclerViewNearby.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getContext())
                        .visibilityProvider(adapter)
                        .marginProvider(adapter)
                        .build());

        mRecyclerViewNearby.setAdapter(adapter);

        return view;
    }

    private ArrayList<Place> dummyPlaces() {
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("https://scontent-mia1-1.xx.fbcdn.net/hphotos-xat1/v/t1.0-9/11702846_424892831049220_4624221511639253749_n.jpg?oh=b2d15679e46d4d698757f28e89bcac28&oe=577CDDED", "Urbano Sport Bar"));
        places.add(new Place("http://www.shannonpub.com/ShannonPubGuinnessLogo1982.jpg", "Urbano Sport Bar"));
        places.add(new Place("https://pbs.twimg.com/profile_images/448787038/Brava_Icon.jpg", "Urbano Sport Bar"));
        places.add(new Place("http://4.bp.blogspot.com/_T_8NA6hW024/TJhL_6yymCI/AAAAAAAAABk/kDxcEKfhhC8/s1600/wild+heaven_logo.jpg", "Urbano Sport Bar"));
        places.add(new Place("http://www.fmdining.com/logos/Lucks%20logo_1.png", "Urbano Sport Bar"));
        places.add(new Place("http://static.dnaindia.com/sites/default/files/2015/05/30/341453-mcdonalds.jpg", "Urbano Sport Bar"));
        return places;
    }

    private ArrayList<Event> dummyEvents() {
        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("https://pbs.twimg.com/profile_images/661931868858658817/xV0fUYnn.png", "Hack Turabo", "86"));
        events.add(new Event("https://4.bp.blogspot.com/-WZAK-U8am6E/VwJe80A5PcI/AAAAAAAAEr4/o2-ul1F9GR8nzuWFL_to3rwsok-5lm2EA/s1600/justas%2Bmayaguez.jpg", "LAI 2016", "99"));
        return events;
    }

    ArrayList<User> users = new ArrayList<>();

    private ArrayList<User> dummyUsers() {

        users.add(new User("http://www.sprigs.life/wp-content/uploads/2015/10/testimonials_2.jpg", "@pedrito", "Hey There! I am using Nearbie."));
        users.add(new User("http://www.material-ui.com/images/chexee-128.jpg", "@valentina89", "Hey There! I am using Nearbie."));
        users.add(new User("http://www.material-ui.com/images/kolage-128.jpg", "@erick_34", "Hey There! I am using Nearbie."));
        users.add(new User("http://www.material-ui.com/images/uxceo-128.jpg", "@maria_vel", "Hey There! I am using Nearbie."));
        users.add(new User("http://www.material-ui.com/images/adhamdannaway-128.jpg", "@leo_mldo", "Hey There! I am using Nearbie."));
        users.add(new User("http://www.sprigs.life/wp-content/uploads/2015/10/testimonials_2.jpg", "@angel_jesus", "Hey There! I am using Nearbie."));

        return users;
    }
}