package org.binarybeats.quickie.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.binarybeats.quickie.R;

/**
 * Created by Leamsy on 4/6/2016.
 */
public class UserViewHolder extends RecyclerView.ViewHolder {

    private ImageView mProfileImage;
    private TextView mUsername;
    private TextView mStatus;

    public UserViewHolder(View itemView) {
        super(itemView);
        mProfileImage = (ImageView) itemView.findViewById(R.id.profile_image);
        mUsername = (TextView) itemView.findViewById(R.id.username);
        mStatus = (TextView) itemView.findViewById(R.id.status);
    }

    public ImageView getProfileImage() {
        return mProfileImage;
    }

    public TextView getUsername() {
        return mUsername;
    }

    public TextView getStatus() {
        return mStatus;
    }
}