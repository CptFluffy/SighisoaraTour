package com.example.android.sighisoaratour;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends android.support.v4.app.Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(R.string.alte_post_title, R.string.alte_post_cafe_detail, R.drawable.alte_post, R.string.alte_post_cafe_description, "46.2172115", "4d24.7930057"));
        attractions.add(new Attraction(R.string.georgius_krauss_house_title, R.string.georgius_krauss_detail, R.drawable.georgius_krauss, R.string.georgius_krauss_description, "46.2209528", "24.7926638"));
        attractions.add(new Attraction(R.string.la_perla_title, R.string.la_perla_detail, R.drawable.la_perla, R.string.la_perla_description, "46.2179306", "24.794373"));
        attractions.add(new Attraction(R.string.concordia_title, R.string.concordia_detail, R.drawable.condordia, R.string.concordia_description, "46.2183099", "24.7934859"));
        attractions.add(new Attraction(R.string.house_with_the_stag_title, R.string.house_with_the_stag_detail, R.drawable.house_with_the_stag, R.string.house_with_the_stag_description, "46.2197481", "24.79242"));
        attractions.add(new Attraction(R.string.quattro_amicii_title, R.string.quattro_amicii_detail, R.drawable.quattro_amicii, R.string.quattro_amicii_description, "46.219789", "24.7957121"));


        LocationAttractionAdapter adapter = new LocationAttractionAdapter(getActivity(), attractions, R.color.restaurantsCategory);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Attraction attraction = attractions.get(position);

                //When the user clicks the list item the maps app will pe opend with the help on an intent.
                String uri = "http://maps.google.com/maps?daddr=" + attraction.getLatitude() + "," + attraction.getLongitude();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        return rootView;
    }
}
