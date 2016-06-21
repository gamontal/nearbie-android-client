package org.binarybeats.quickie.fragment;

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
import org.binarybeats.quickie.model.User;

import java.util.ArrayList;

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder>
        implements HorizontalDividerItemDecoration.MarginProvider {

    private Context mContext;
    private ArrayList<User> mUsers;

    protected OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        public void onItemClick(User user);
    }

    public ChatRecyclerViewAdapter(Context context, ArrayList<User> users,  OnItemClickListener onItemClickListener) {
        mContext = context;
        mUsers = users;
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_user, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Picasso.with(mContext)
                .load(mUsers.get(position).getProfileImage())
                .fit()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.mUserImage);
        holder.mUsername.setText(mUsers.get(position).getUsername());

        // TODO: This is for presentation purposes delete in production
        if(position == 0 || position == 1) {
            holder.mIcon.setColorFilter(Color.parseColor("#009688"));
        } else {
            holder.mIcon.setAlpha((float) 0.38);
        }

        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(mUsers.get(position));
            }
        });
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


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mUserImage;
        private TextView mUsername;
        private ImageView mIcon;

        public void setOnClickListener(View.OnClickListener listener) {
            itemView.setOnClickListener(listener);
        }

        public ViewHolder(View itemView) {
            super(itemView);
            mUserImage = (ImageView) itemView.findViewById(R.id.profile_image_chat);
            mUsername = (TextView) itemView.findViewById(R.id.username_chat);
            mIcon = (ImageView) itemView.findViewById(R.id.chat_list_icon);
        }
    }
}
