package org.binarybeats.quickie.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.adapter.MainAdapter;
import org.binarybeats.quickie.model.Event;
import org.binarybeats.quickie.model.Place;
import org.binarybeats.quickie.model.User;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment.
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        mAdapter = new MainAdapter(getContext(), dummyPlaces(), dummyEvents(), dummyUsers());
        mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext())
                        .visibilityProvider(mAdapter)
                        .marginProvider(mAdapter)
                        .build());
        mRecyclerView.setAdapter(mAdapter);

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
        events.add(new Event("https://pbs.twimg.com/profile_images/580926474896605184/M3T2Y5df_400x400.png", "H3 Tech Conference", "99"));
        return events;
    }

    private ArrayList<User> dummyUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("http://www.sprigs.life/wp-content/uploads/2015/10/testimonials_2.jpg", "@pedrito", "Hey There! I am using Nearbie."));
        users.add(new User("http://www.material-ui.com/images/chexee-128.jpg", "@valentina89", "Lets go hang!"));
        users.add(new User("http://www.material-ui.com/images/kolage-128.jpg", "@erick_34", "Hey There! I am using Nearbie."));
        users.add(new User("http://www.material-ui.com/images/uxceo-128.jpg", "@maria_vel", "Wanna party tonight?"));
        users.add(new User("http://www.material-ui.com/images/adhamdannaway-128.jpg", "@leo_mldo", "Hey There! I am using Nearbie."));
        users.add(new User("http://www.sprigs.life/wp-content/uploads/2015/10/testimonials_2.jpg", "@angel_jesus", "Hey There! I am using Nearbie."));
        return users;
    }
}