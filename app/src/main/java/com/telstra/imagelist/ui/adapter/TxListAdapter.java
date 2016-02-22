package com.telstra.imagelist.ui.adapter;

import com.telstra.imagelist.R;
import com.telstra.imagelist.network.TxNetworkManager;
import com.telstra.imagelist.network.model.SingleUserInfo;
import com.telstra.imagelist.common.util.TxStringUtils;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class TxListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<SingleUserInfo> userInfo;
    ImageLoader imageLoader = TxNetworkManager.getInstance().getImageLoader();

    public TxListAdapter(Activity activity, List<SingleUserInfo> userInfo) {
        this.activity = activity;
        this.userInfo = userInfo;
    }

    @Override
    public int getCount() {
        return userInfo.size();
    }

    @Override
    public Object getItem(int location) {
        return userInfo.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (inflater == null) {
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (imageLoader == null) {
            imageLoader = TxNetworkManager.getInstance().getImageLoader();
        }

        if (convertView == null) {
            holder = new ViewHolder();

            convertView = inflater.inflate(R.layout.list_row, parent, false);

            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.description = (TextView) convertView.findViewById(R.id.description);
            holder.thumbNailNetworkImage = (NetworkImageView) convertView
                    .findViewById(R.id.networkImage);
            holder.thumbNailImage = (ImageView) convertView
                    .findViewById(R.id.image);

            convertView.setTag(holder);
        } else {

            holder = (ViewHolder)convertView.getTag();
        }

        SingleUserInfo userInformation = userInfo.get(position);

        TxStringUtils txStringUtils = new TxStringUtils();

        if (txStringUtils.isStringDataAValid(userInformation.getImageHref())) {

            holder.thumbNailNetworkImage.setImageUrl(userInformation.getImageHref(), imageLoader);
        } else {
            holder.thumbNailImage.setVisibility(View.VISIBLE);
            holder.thumbNailNetworkImage.setVisibility(View.GONE);
        }

        if (txStringUtils.isStringDataAValid(String.valueOf(userInformation.getTitle()))) {
            holder.title.setText(userInformation.getTitle());
        }

        if (txStringUtils.isStringDataAValid(String.valueOf(userInformation.getDescription()))) {
            holder.description.setText(String.valueOf(userInformation.getDescription()));
        }
        return convertView;
    }

    private class ViewHolder {
        TextView title;
        TextView description;
        ImageView thumbNailImage;
        NetworkImageView thumbNailNetworkImage;
    }

}