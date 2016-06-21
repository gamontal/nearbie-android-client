package org.binarybeats.quickie.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.model.User;

/**
 * Created by Leamsy on 4/10/2016.
 */
public class CustomDialogFragment extends DialogFragment {

    private Context mContext;
    private User user;

    public CustomDialogFragment(Context ctx, User u) {
        mContext = ctx;
        user = u;
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

        ImageView imgDialog = (ImageView) v.findViewById(R.id.dialog_image);

        Picasso.with(mContext)
                .load(user.getProfileImage())
                .fit()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(imgDialog);

        TextView txtUsernameDialog = (TextView) v.findViewById(R.id.dialog_username);
        txtUsernameDialog.setText(user.getUsername());

        TextView txtStatusDialog = (TextView) v.findViewById(R.id.dialog_status);
        txtStatusDialog.setText(user.getStatus());


        builder.setView(v);

        return builder.create();
    }
}