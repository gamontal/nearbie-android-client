package org.binarybeats.quickie.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.binarybeats.quickie.R;

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


        CustomDialogFragment customDialogFragment = new CustomDialogFragment();

        FragmentManager fragmentManager = getChildFragmentManager();

        // The device is using a large layout, so show the fragment as a dialog
        customDialogFragment.show(fragmentManager, "dialog");

        return view;
    }
}