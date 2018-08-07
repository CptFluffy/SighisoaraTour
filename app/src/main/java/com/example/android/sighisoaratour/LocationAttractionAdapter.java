package com.example.android.sighisoaratour;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//This Adapter is used for the location list and uses the list_item_location.xml as a layout. This way a location icon will appear on the screen, signaling the user that the view is clickable.
public class LocationAttractionAdapter extends ArrayAdapter<Attraction> {

    private int mColorResourceId;

    private static final String LOG_TAG = AttractionAdapter.class.getSimpleName();

    public LocationAttractionAdapter(Activity context, ArrayList<Attraction> attractions, int colorResoureceId) {
        super(context, 0, attractions);
        mColorResourceId = colorResoureceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_location, parent, false);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        Attraction currentAttraction = getItem(position);

        ImageView resourseImageview = (ImageView) listItemView.findViewById(R.id.image_id);

        if (currentAttraction.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            resourseImageview.setImageResource(currentAttraction.getImageResourceId());
            // Make sure the view is visible
            resourseImageview.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            resourseImageview.setVisibility(View.GONE);
        }

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentAttraction.getAttractionTitle());

        TextView detailTextView = (TextView) listItemView.findViewById(R.id.detail_text_view);
        detailTextView.setText(currentAttraction.getAttractionDetail());

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        descriptionTextView.setText(currentAttraction.getAttractionDescription());

        return listItemView;
    }
}
