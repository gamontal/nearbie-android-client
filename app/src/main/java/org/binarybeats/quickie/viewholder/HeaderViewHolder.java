package org.binarybeats.quickie.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.binarybeats.quickie.R;

/**
 * Created by Leamsy on 4/7/2016.
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {

    private TextView mHeader;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        mHeader = (TextView) itemView.findViewById(R.id.header);
    }

    public TextView getHeader() {
        return mHeader;
    }
}