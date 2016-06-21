package org.binarybeats.quickie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.binarybeats.quickie.R;
import org.binarybeats.quickie.model.ChatMessage;
import org.binarybeats.quickie.model.UserType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChatDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<ChatMessage> mChatMessages;
    private Context mContext;

    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm");
    public static final int OUTGOING = 0;
    public static final int INCOMING = 1;

    public ChatDetailAdapter(ArrayList<ChatMessage> mChatMessages, Context mContext) {
        this.mChatMessages = mChatMessages;
        this.mContext = mContext;
    }

    @Override
    public int getItemCount() {
        return mChatMessages.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case OUTGOING:
                View outgoingView = inflater.inflate(R.layout.chat_detail_outgoing, parent, false);
                viewHolder =  new OutgoingMessageViewHolder(outgoingView);
                break;
            case INCOMING:
                View incomingView = inflater.inflate(R.layout.chat_detail_incoming, parent, false);
                viewHolder = new IncomingMessageViewHolder(incomingView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ChatMessage message = mChatMessages.get(position);

        switch (holder.getItemViewType()) {
            case OUTGOING:
                ((OutgoingMessageViewHolder) holder).
                        mMessage.setText(mChatMessages.get(position).getMessageText());
                ((OutgoingMessageViewHolder) holder).
                        mMessageTime.setText(SIMPLE_DATE_FORMAT.format(message.getMessageTime()));
                ((OutgoingMessageViewHolder) holder).mMessagePhoto.setImageResource(R.drawable.jsa);
                ((OutgoingMessageViewHolder) holder).mMessageStatus.
                        setImageResource(R.drawable.ic_done_black_24dp);
                break;
            case INCOMING:
                ((IncomingMessageViewHolder) holder).
                        mMessage.setText(mChatMessages.get(position).getMessageText());
                ((IncomingMessageViewHolder) holder).
                        mMessageTime.setText(SIMPLE_DATE_FORMAT.format(message.getMessageTime()));
                ((IncomingMessageViewHolder) holder).mMessagePhoto.setImageResource(R.drawable.jsa);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage message = mChatMessages.get(position);

        if (message.getUserType() == UserType.SELF) {
            return OUTGOING;
        } else if (message.getUserType() == UserType.OTHER) {
            return INCOMING;
        }

        return -1;
    }

    public class OutgoingMessageViewHolder extends RecyclerView.ViewHolder {
        public ImageView mMessagePhoto;
        public ImageView mMessageStatus;
        public TextView mMessage;
        public TextView mMessageTime;

        public OutgoingMessageViewHolder(View itemView) {
            super(itemView);

            mMessagePhoto = (ImageView) itemView.findViewById(R.id.outgoing_message_photo);
            mMessageStatus = (ImageView) itemView.findViewById(R.id.outgoing_reply_status);
            mMessage = (TextView) itemView.findViewById(R.id.outgoing_message);
            mMessageTime = (TextView) itemView.findViewById(R.id.outgoing_time);
        }
    }

    public class IncomingMessageViewHolder extends RecyclerView.ViewHolder {
        public ImageView mMessagePhoto;
        public ImageView mMessageStatus;
        public TextView mMessage;
        public TextView mMessageTime;

        public IncomingMessageViewHolder(View itemView) {
            super(itemView);

            mMessagePhoto = (ImageView) itemView.findViewById(R.id.incoming_message_photo);
            mMessage = (TextView) itemView.findViewById(R.id.incoming_message);
            mMessageTime = (TextView) itemView.findViewById(R.id.incoming_time);
        }
    }
}
