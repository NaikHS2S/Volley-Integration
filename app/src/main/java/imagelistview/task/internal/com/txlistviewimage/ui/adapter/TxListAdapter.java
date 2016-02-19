package imagelistview.task.internal.com.txlistviewimage.ui.adapter;

import imagelistview.task.internal.com.txlistviewimage.R;
import manager.request_queue_manager.TxNetworkManager;
import manager.response.SingleUserInfo;

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

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = TxNetworkManager.getInstance().getImageLoader();

        SingleUserInfo userInformation = userInfo.get(position);

        NetworkImageView thumbNailNetworkImage = (NetworkImageView) convertView
                .findViewById(R.id.networkImage);
        if (isaNullImageUrl(userInformation.getImageHref())) {

            thumbNailNetworkImage.setImageUrl(userInformation.getImageHref(), imageLoader);
        } else {
            ImageView thumbNailImage = (ImageView) convertView
                    .findViewById(R.id.image);
            thumbNailImage.setVisibility(View.VISIBLE);
            thumbNailNetworkImage.setVisibility(View.GONE);
        }


        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.description);

        title.setText(userInformation.getTitle());

        description.setText(String.valueOf(userInformation.getDescription()));


        return convertView;
    }

    private boolean isaNullImageUrl(String url) {
        return url != null && !url.equalsIgnoreCase("null") && !url.trim().equalsIgnoreCase("");
    }


}