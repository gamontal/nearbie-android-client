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
import org.binarybeats.quickie.models.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);





        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view_chat);
        rv.setLayoutManager(new LinearLayoutManager(container.getContext()));


        ChatRecyclerViewAdapter adapter = new ChatRecyclerViewAdapter(getContext(), dummyUsers());

        rv.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getContext())
                        .marginProvider(adapter)
                        .build());



        rv.setAdapter(adapter);




        // Public Profile Dialog
//        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
//        FragmentManager fragmentManager = getChildFragmentManager();
//        customDialogFragment.show(fragmentManager, "dialog");

        return view;
    }

    private ArrayList<User> dummyUsers() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("http://www.sprigs.life/wp-content/uploads/2015/10/testimonials_2.jpg", "@johndoe", "I'm using Quickie."));
        }
        return users;
    }
}