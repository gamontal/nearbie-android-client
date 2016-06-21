package org.binarybeats.quickie.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.binarybeats.quickie.ChatDetailActivity;
import org.binarybeats.quickie.R;
import org.binarybeats.quickie.model.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment implements ChatRecyclerViewAdapter.OnItemClickListener {

    public static final String EXTRA_MESSAGE = null;

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


        ChatRecyclerViewAdapter adapter = new ChatRecyclerViewAdapter(getContext(), dummyUsers(), this);

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
            users.add(new User("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4qsLLMlZF1Yhzuh1wChjR6NSVH9gLp4j5aTwOshivs5NRajcW", "@luiscab", "Hey There! I am using Nearbie."));
            users.add(new User("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2D2yvEHyS9H5SenTEtpyQdqrZJkJJRux8I_FEhlZ1ZDmPT7HyDA", "@pepe_09", "Hey There! I am using Nearbie."));
            users.add(new User("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRNyJLOisPQFCFNQWpToQEaGowuHf931eU_wKq_zwVTXqCoE-fAFA", "@juanmolina", "Hey There! I am using Nearbie."));
            users.add(new User("http://www.sprigs.life/wp-content/uploads/2015/10/testimonials_2.jpg", "@edurd_45", "Hey There! I am using Nearbie."));

        return users;
    }

    @Override
    public void onItemClick(User user) {
        Intent intent = new Intent(getContext(), ChatDetailActivity.class);
        String message = user.getUsername();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}