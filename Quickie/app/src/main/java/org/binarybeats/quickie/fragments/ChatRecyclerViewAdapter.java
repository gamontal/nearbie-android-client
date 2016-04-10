package org.binarybeats.quickie.fragments;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.models.User;

import java.util.ArrayList;

/**
 * Created by Leamsy on 4/10/2016.
 */
public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ChatRecyclerViewViewHolder>
implements HorizontalDividerItemDecoration.MarginProvider {

    private Context mContext;
    private ArrayList<User> mUsers;

    public ChatRecyclerViewAdapter(Context context, ArrayList<User> users) {
        mContext = context;
        mUsers = users;
    }

    @Override
    public ChatRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_user, parent, false);
        return new ChatRecyclerViewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatRecyclerViewViewHolder holder, int position) {
        Picasso.with(mContext)
                .load(mUsers.get(position).getProfileImage())
                .fit()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mUserImage);
        holder.mUsername.setText(mUsers.get(position).getUsername());

        if(position == 0 || position == 1) {
            holder.mIcon.setColorFilter(Color.parseColor("#009688"));
        } else {
            holder.mIcon.setAlpha((float) 0.38);
        }
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    @Override
    public int dividerLeftMargin(int position, RecyclerView parent) {
        return (int) parent.getContext().getResources().getDimension(R.dimen.item_left_padding);
    }

    @Override
    public int dividerRightMargin(int position, RecyclerView parent) {
        return 0;
    }


    public class ChatRecyclerViewViewHolder extends RecyclerView.ViewHolder {

        private ImageView mUserImage;
        private TextView mUsername;
        private ImageView mIcon;

        public ChatRecyclerViewViewHolder(View itemView) {
            super(itemView);
            mUserImage = (ImageView) itemView.findViewById(R.id.profile_image_chat);
            mUsername = (TextView) itemView.findViewById(R.id.username_chat);
            mIcon = (ImageView) itemView.findViewById(R.id.chat_list_icon);
        }
    }
}
