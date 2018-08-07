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
import java.util.Locale;

public class OldTownFragment extends android.support.v4.app.Fragment {

    public OldTownFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(R.string.clock_tower_title, R.string.clock_tower_detail, R.drawable.clock_tower, R.string.clock_tower_description, "46.219344", "24.793289"));
        attractions.add(new Attraction(R.string.monastery_church_title, R.string.monastery_church_detail, R.drawable.monestary_church, R.string.monastery_church_description, "46.2197002", "24.793396"));
        attractions.add(new Attraction(R.string.tanners_tower_title, R.string.tanners_tower_detail, R.drawable.tanners_tower, R.string.tanners_tower_description, "6.2181988", "24.7922641"));
        attractions.add(new Attraction(R.string.covered_staircase_title, R.string.covered_staircase_detail, R.drawable.covered_staircase, R.string.covered_staircase_description, "46.21891", "24.791583"));
        attractions.add(new Attraction(R.string.school_on_the_hill_title, R.string.school_on_the_hill_detail, R.drawable.school_on_the_hill, R.string.school_on_the_hill_description, "46.2177729", "24.7915265"));
        attractions.add(new Attraction(R.string.church_on_the_hill_title, R.string.church_on_the_hill_detail, R.drawable.church_on_the_hill, R.string.church_on_the_hill_description, "46.2176001", "24.7904342"));
        attractions.add(new Attraction(R.string.citadel_square_title, R.string.citadel_square_detail, R.drawable.citadel_sqare, R.string.citadel_square_description, "46.2196755", "24.7916055"));

        LocationAttractionAdapter adapter = new LocationAttractionAdapter(getActivity(), attractions, R.color.oldTownCategory);

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
