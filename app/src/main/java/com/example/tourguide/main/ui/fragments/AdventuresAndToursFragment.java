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

public class AdventuresAndToursFragment extends Fragment implements PlaceRecyclerViewAdapter.OnPlaceItemClickListener {

    private RecyclerView adventureAndTourRv;
    private ArrayList<Place> adventureAndTourList;
    private PlaceRecyclerViewAdapter adventureAndTourAdapter;

    public AdventuresAndToursFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adventures_and_tours, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hookViewIds(view);
        createAListOfAdventureAndTourObjects();
        createAdventureAndTourAdapter();
    }

    private void hookViewIds(View view) {
        adventureAndTourRv = view.findViewById(R.id.boat_tour_rv);
    }

    private void createAListOfAdventureAndTourObjects() {
        releasePlaceListMemoryResources();

        adventureAndTourList = new ArrayList<Place>();
        adventureAndTourList.add(new Place(R.drawable.singapore_river_cruise, R.string.singapore_river, true, "1 p.m", "9 p.m", "10 a.m", "9 p.m", R.string.singapore_river_address, 4.5, 690));
        adventureAndTourList.add(new Place(R.drawable.royal_albatross, R.string.royal_albatross, true, "7 p.m", "11 p.m", "5 p.m", "7:30 p.m", "8:30 p.m", "11 p.m", R.string.royal_albatross_address, 4.5, 774));
        adventureAndTourList.add(new Place(R.drawable.singapore_ducktours, R.string.singapore_ducktours, false, "9 a.m", "6 p.m", R.string.singapore_ducktours_address, 4.5, 384));
        adventureAndTourList.add(new Place(R.drawable.kayah_fising_fever, R.string.kayah_fising_fever, false, "7 a.m", "6 p.m", R.string.kayah_fising_fever_address, 5.0, 230));
        adventureAndTourList.add(new Place(R.drawable.yacht_cruise, R.string.yacht_cruise, false, "8 a.m", "10 p.m", R.string.yacht_cruise_address, 4.5, 28));
        adventureAndTourList.add(new Place(R.drawable.big_bus_tour, R.string.big_bus_tours, false, "11:30 a.m", "6:30 p.m", R.string.big_bus_tours_address, 4.0, 423));
        adventureAndTourList.add(new Place(R.drawable.lion_city_bike_tour, R.string.lion_city_bike_tour, true, null, null, R.string.lion_city_bike_tour_address, 5.0, 227));
        adventureAndTourList.add(new Place(R.drawable.trishaw_uncle, R.string.trishaw_uncle, false, "11 a.m", "9 p.m", R.string.trishaw_uncle_address, 4.0, 77));
        adventureAndTourList.add(new Place(R.drawable.monster_day_tours, R.string.monster_day_tours, true, null, null, R.string.monster_day_tours_address, 5.0, 2353));
        adventureAndTourList.add(new Place(R.drawable.game_tour, R.string.game_tour, true, null, null, R.string.game_tour_address, 5.0, 140));
        adventureAndTourList.add(new Place(R.drawable.ifly, R.string.ifly, true, "9 a.m", "10 p.m", R.string.ifly_address, 4.5, 1289));
        adventureAndTourList.add(new Place(R.drawable.skypark_sentosa, R.string.skypark_sentosa, true, "1:30 p.m", "7 p.m", "12:30 p.m", "7 p.m", R.string.skypark_sentosa_address, 4.5, 707));
        adventureAndTourList.add(new Place(R.drawable.oride_minisegway, R.string.oride_mini_segway, true, "6:30 p.m", "10 p.m", "10 a.m", "10 p.m", R.string.oride_mini_segway_address, 5.0, 147));
    }

    private void createAdventureAndTourAdapter() {
        adventureAndTourAdapter = new PlaceRecyclerViewAdapter(requireContext(), adventureAndTourList, this);
        adventureAndTourRv.setAdapter(adventureAndTourAdapter);
        adventureAndTourRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void releasePlaceListMemoryResources() {
        if (adventureAndTourList != null) {
            if (!adventureAndTourList.isEmpty()) {
                adventureAndTourList.clear();
                adventureAndTourList = null;
                adventureAndTourAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onPlaceItemClicked(int position) {
        switch (position) {
            case 0: {
                takeUserToPlaceMainWebsite(R.string.singapore_river_link);
                break;
            }
            case 1: {
                takeUserToPlaceMainWebsite(R.string.royal_albatross_link);
                break;
            }
            case 2: {
                takeUserToPlaceMainWebsite(R.string.singapore_ducktours_link);
                break;
            }
            case 3: {
                takeUserToPlaceMainWebsite(R.string.kayah_fising_fever_link);
                break;
            }
            case 4: {
                takeUserToPlaceMainWebsite(R.string.yacht_cruise_link);
                break;
            }
            case 5: {
                takeUserToPlaceMainWebsite(R.string.big_bus_tours_link);
                break;
            }
            case 6: {
                takeUserToPlaceMainWebsite(R.string.lion_city_bike_tour_link);
                break;
            }
            case 7: {
                takeUserToPlaceMainWebsite(R.string.trishaw_uncle_link);
                break;
            }
            case 8: {
                takeUserToPlaceMainWebsite(R.string.monster_day_tours_link);
                break;
            }
            case 9: {
                takeUserToPlaceMainWebsite(R.string.game_tour_link);
                break;
            }
            case 10: {
                takeUserToPlaceMainWebsite(R.string.ifly_link);
                break;
            }
            case 11: {
                takeUserToPlaceMainWebsite(R.string.skypark_sentosa_link);
                break;
            }
            case 12: {
                takeUserToPlaceMainWebsite(R.string.oride_mini_segway_link);
                break;
            }
            default:
                throw new IllegalArgumentException();
        }
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