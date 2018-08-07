package com.example.android.sighisoaratour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BarsFragment extends android.support.v4.app.Fragment {

    public BarsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<Attraction>();
        attractions.add(new Attraction(R.string.medieval_cafe_title, R.string.medieval_cafe_detail, R.drawable.medieval_cafe, R.string.medieval_cafe_description, "46.2189", "24.792268"));
        attractions.add(new Attraction(R.string.the_bean_title, R.string.the_bean_detail, R.drawable.the_bean_coffe, R.string.the_bean_description, "46.2188414", "24.7941061"));
        attractions.add(new Attraction(R.string.casa_cositorarului_title, R.string.casa_cositorarului_detail, R.drawable.casa_cositorarului, R.string.casa_cositorarului_description, "46.2188966", "24.7919235"));
        attractions.add(new Attraction(R.string.voynich_title, R.string.voynich_detail, R.drawable.voynich, R.string.voynich_description, "46.219912", "24.7958301"));
        attractions.add(new Attraction(R.string.house_on_the_rock_title, R.string.house_on_the_rock_detail, R.drawable.house_on_the_rock, R.string.house_on_the_rock_description, "46.2201794", "24.7926638"));

        LocationAttractionAdapter adapter = new LocationAttractionAdapter(getActivity(), attractions, R.color.barsCategory);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //When the user clicks the list item the maps app will pe opend with the help on an intent.
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
