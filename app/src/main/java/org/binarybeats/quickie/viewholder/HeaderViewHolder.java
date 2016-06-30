package org.binarybeats.quickie.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.binarybeats.quickie.R;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    private TextView mHeader;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        mHeader = (TextView) itemView.findViewById(R.id.sub_header_title);
    }

    public TextView getHeader() {
        return mHeader;
    }
}