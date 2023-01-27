package com.example.tourguide.main.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tourguide.R;
import com.example.tourguide.main.adapters.PlaceRecyclerViewAdapter;
import com.example.tourguide.main.models.Place;

import java.util.ArrayList;

public class AmusementsFragment extends Fragment implements PlaceRecyclerViewAdapter.OnPlaceItemClickListener {

    private RecyclerView amusementRv;
    private ArrayList<Place> amusementList;
    private PlaceRecyclerViewAdapter amusementAdapter;

    public AmusementsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amusements, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hookViewIds(view);
        createAListOfAmusementObjects();
        createAmusementAdapter();
    }

    private void hookViewIds(View view) {
        amusementRv = view.findViewById(R.id.amusement_rv);
    }

    private void createAListOfAmusementObjects() {
        releasePlaceListMemoryResources();

        amusementList = new ArrayList<Place>();
        amusementList.add(new Place(R.drawable.singapore_zoo, R.string.singapore_zoo, false, "8:30 a.m", "6 p.m", R.string.singapore_zoo_address, 4.5, 36619));
        amusementList.add(new Place(R.drawable.universal_stuidos, R.string.universal_studios, false, "11 a.m", "6 p.m", R.string.universal_studios_address, 4.5, 81145));
        amusementList.add(new Place(R.drawable.singapore_flyer, R.string.singapore_flyer, false, "2 p.m", "10 p.m", R.string.singapore_flyer_address, 4.5, 16055));
        amusementList.add(new Place(R.drawable.singapore_cable_car, R.string.singapore_cable_car, false, "8:45 a.m", "8:30 p.m", R.string.singapore_cable_car_address, 4.5, 784));
        amusementList.add(new Place(R.drawable.artscience_museum, R.string.artscience_museum, false, "10 a.m", "7 p.m", R.string.artscience_museum_address, 4.5, 10909));
        amusementList.add(new Place(R.drawable.night_safari, R.string.night_safari, false, "6:30 p.m", "12 a.m", R.string.night_safari_address, 4.5, 24880));
        amusementList.add(new Place(R.drawable.jurong_bird_park, R.string.jurong_bird_park, false, "8:30 a.m", "6 p.m", R.string.jurong_bird_park_address, 4.5, 19541));
        amusementList.add(new Place(R.drawable.marine_life_park, R.string.marine_life_park, false, "10 a.m", "5 p.m", R.string.marine_life_park_address, 4.5, 537));
        amusementList.add(new Place(R.drawable.river_wonders, R.string.river_wonders, false, "10 a.m", "7 p.m", R.string.river_wonders_address, 4.5, 8374));
        amusementList.add(new Place(R.drawable.wild_wild_wet, R.string.wild_wild_wet, false, "12 p.m", "6 p.m", R.string.wild_wild_wet_address, 4.5, 3344));
        amusementList.add(new Place(R.drawable.trapped_escape_room, R.string.trapped_escape_room, false, "11 a.m", "10:30 p.m", R.string.trapped_escape_room_address, 5.0, 2480));
        amusementList.add(new Place(R.drawable.skypark_observation_deck, R.string.skypark_observation_deck, false, "11 a.m", "9 p.m", R.string.skypark_observation_deck_address, 4.5, 7052));
        amusementList.add(new Place(R.drawable.esplanade_theatres_on_the_bay, R.string.esplanade_theatres_on_the_bay, false, "8 a.m", "2 a.m", R.string.esplanade_theatres_on_the_bay_address, 4.5, 16655));
        amusementList.add(new Place(R.drawable.singapore_art_museum, R.string.singapore_art_museum, false, "10 a.m", "7 p.m", R.string.singapore_art_museum_address, 4.0, 517));
        amusementList.add(new Place(R.drawable.asian_civilisations_museum, R.string.asian_civilisations_museum, false, "10 a.m", "7 p.m", R.string.asian_civilisations_museum_address, 4.5, 4131));
        amusementList.add(new Place(R.drawable.national_gallery_singapore, R.string.national_gallery, false, "10 a.m", "7 p.m", R.string.national_gallery_address, 4.5, 11285));
    }

    private void createAmusementAdapter() {
        amusementAdapter = new PlaceRecyclerViewAdapter(requireContext(), amusementList, this);
        amusementRv.setAdapter(amusementAdapter);
        amusementRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void releasePlaceListMemoryResources() {
        if (amusementList != null) {
            if (!amusementList.isEmpty()) {
                amusementList.clear();
                amusementList = null;
                amusementAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onPlaceItemClicked(int position) {
        switch (position) {
            case 0: {
                takeUserToWikipedia(R.string.singapore_zoo);
                break;
            }
            case 1: {
                takeUserToWikipedia(R.string.universal_studios);
                break;
            }
            case 2: {
                takeUserToWikipedia(R.string.singapore_flyer);
                break;
            }
            case 3: {
                takeUserToWikipedia(R.string.singapore_cable_car);
                break;
            }
            case 4: {
                takeUserToWikipedia(R.string.artscience_museum);
                break;
            }
            case 5: {
                takeUserToWikipedia(R.string.night_safari);
                break;
            }
            case 6: {
                takeUserToWikipedia(R.string.jurong_bird_park);
                break;
            }
            case 7: {
                takeUserToWikipedia(R.string.marine_life_park);
                break;
            }
            case 8: {
                takeUserToWikipedia(R.string.river_wonders);
                break;
            }
            case 9: {
                takeUserToWikipedia(R.string.wild_wild_wet);
                break;
            }
            case 10: {
                takeUserToPlaceMainWebsite(R.string.trapped_escape_room_link);
                break;
            }
            case 11: {
                takeUserToPlaceMainWebsite(R.string.skypark_observation_deck_link);
                break;
            }
            case 12: {
                takeUserToWikipedia(R.string.esplanade_theatres_on_the_bay);
                break;
            }
            case 13: {
                takeUserToWikipedia(R.string.singapore_art_museum);
                break;
            }
            case 14: {
                takeUserToWikipedia(R.string.asian_civilisations_museum);
                break;
            }
            case 15: {
                takeUserToWikipedia(R.string.national_gallery);
                break;
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    // Allow users to browse detailed information on the selected place item
    private void takeUserToWikipedia(int placeName) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.placeholder_wiki_link, getString(placeName))));
        startActivity(intent);
    }

    private void takeUserToPlaceMainWebsite(int placeWebLink) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(placeWebLink)));
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        releasePlaceListMemoryResources();
    }
}