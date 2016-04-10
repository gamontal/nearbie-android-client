package org.binarybeats.quickie.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import org.binarybeats.quickie.R;

/**
 * Created by Leamsy on 4/10/2016.
 */
public class CustomDialogFragment extends DialogFragment {

    public CustomDialogFragment() {
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        return super.onCreateDialog(savedInstanceState);

//        Dialog dialog = super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //To hide action bar from layout
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Declaration of controls
        View v = getActivity().getLayoutInflater().inflate(R.layout.custom_dialog_layout, null);
        builder.setView(v);

        //My code

        return builder.create();
    }
}