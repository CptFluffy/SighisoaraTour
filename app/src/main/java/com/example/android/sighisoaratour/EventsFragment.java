package com.example.android.sighisoaratour;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsFragment extends android.support.v4.app.Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.attraction_list, container, false);

        final ArrayList<Attraction> attractions = new ArrayList<>();
        attractions.add(new Attraction(R.string.german_culture_title, R.string.german_culture_detail, R.drawable.german_culture_days, R.string.german_culture_description));
        attractions.add(new Attraction(R.string.christmas_fair_title, R.string.christmas_fair_detail, R.drawable.christmas_fair, R.string.christmas_fair_description));
        attractions.add(new Attraction(R.string.blues_festival_title, R.string.blues_festival_detail, R.drawable.blues_fest, R.string.blues_festival_description));
        attractions.add(new Attraction(R.string.brass_band_fest_title, R.string.brass_band_fest_detail, R.drawable.brass_band_fest, R.string.brass_band_fest_description));
        attractions.add(new Attraction(R.string.proetnica_title, R.string.proetnica_detail, R.drawable.proetnica, R.string.proetnica_description));
        attractions.add(new Attraction(R.string.medieval_festival_title, R.string.medieval_festival_detail, R.drawable.medieva_festival, R.string.medieval_festival_description));
        attractions.add(new Attraction(R.string.craftsman_fair_title, R.string.craftsman_fair_detail, R.drawable.craftman_fair, R.string.craftsman_fair_description));

        AttractionAdapter adapter = new AttractionAdapter(getActivity(), attractions, R.color.eventsCategory);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
