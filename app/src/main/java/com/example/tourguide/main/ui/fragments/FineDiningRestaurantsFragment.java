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

public class FineDiningRestaurantsFragment extends Fragment implements PlaceRecyclerViewAdapter.OnPlaceItemClickListener {

    private RecyclerView restaurantRv;
    private ArrayList<Place> restaurantList;
    private PlaceRecyclerViewAdapter restaurantAdapter;

    public FineDiningRestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fine_dining_restaurants, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hookViewIds(view);
        createAListOfRestaurantObjects();
        createRestaurantAdapter();
    }

    private void hookViewIds(View view) {
        restaurantRv = view.findViewById(R.id.restaurants_rv);
    }

    private void createAListOfRestaurantObjects() {
        releasePlaceListMemoryResources();

        restaurantList = new ArrayList<Place>();
        restaurantList.add(new Place(R.drawable.odette, R.string.odette, true, "12 p.m", "1:15 p.m", "6:30 p.m", "8:15 p.m", R.string.odette_address, 4.5, 724));
        restaurantList.add(new Place(R.drawable.cut_by_wolfgang_puck, R.string.cut_by_wolfgang_puck, false, "5 p.m", "10 p.m", R.string.cut_by_wolfgang_puck_address, 4.5, 1045));
        restaurantList.add(new Place(R.drawable.jaan_by_kirk_westaway, R.string.jaan_by_kirk_westaway, true, "11:45 a.m", "2:30 p.m", "6:30 p.m", "10:45 p.m", R.string.jaan_by_kirk_westaway_address, 4.5, 429));
        restaurantList.add(new Place(R.drawable.basque_kitchen_by_aitor, R.string.basque_kitchen_by_aitor, true, "12 p.m", "4 p.m", "6:30 p.m", "11 p.m", R.string.basque_kitchen_by_aitor_address, 4.5, 165));
        restaurantList.add(new Place(R.drawable.restaurant_labyrinth, R.string.restaurant_labyrinth, true, "12 p.m", "2:30 p.m", "6:30 p.m", "11 p.m", R.string.restaurant_labyrinth_address, 4.5, 325));
        restaurantList.add(new Place(R.drawable.flutes, R.string.flutes, true, "11:30 a.m", "2 p.m", "6 p.m", "10 p.m", R.string.flutes_address, 4.5, 380));
        restaurantList.add(new Place(R.drawable.corner_house, R.string.corner_house, true, "12 p.m", "3 p.m", "6:30 p.m", "11 p.m", R.string.corner_house_address, 4.5, 518));
        restaurantList.add(new Place(R.drawable.whitegrass_restaurant, R.string.whitegrass_restaurant, true, "12 p.m", "2:30 p.m", "6 p.m", "10:30 p.m", R.string.whitegrass_restaurant_address, 4.5, 306));
        restaurantList.add(new Place(R.drawable.naeum_restaurant, R.string.naeum_restaurant, false, "6 p.m", "10:30 p.m", R.string.naeum_restaurant_address, 5.0, 68));
        restaurantList.add(new Place(R.drawable.monti, R.string.monti, false, "11 a.m", "11:30 p.m", R.string.monti_address, 4.5, 1129));
        restaurantList.add(new Place(R.drawable.skai, R.string.skai, true, "11:30 a.m", "2:30 p.m", "3 p.m", "5 p.m", "6 p.m", "10:30 p.m", R.string.skai_address, 4.5, 1009));
        restaurantList.add(new Place(R.drawable.alma_by_juan_amador, R.string.alma_by_juan_amado, true, "12 p.m", "2:30 p.m", "6 p.m", "10:30 p.m", R.string.alma_by_juan_amado_address, 4.5, 412));
        restaurantList.add(new Place(R.drawable.les_amis, R.string.les_amis, true, "12 p.m", "2 p.m", "7 p.m", "9 p.m", R.string.les_amis_address, 4.5, 584));
        restaurantList.add(new Place(R.drawable.preludio, R.string.preludio, true, "11:30 a.m", "2:30 p.m", "6 p.m", "10:30 p.m", R.string.preludio_address, 4.5, 194));
        restaurantList.add(new Place(R.drawable.ocean_restaurant, R.string.ocean, true, "11:30 a.m", "3 p.m", "6 p.m", "10:30 p.m", R.string.ocean_address, 4.0, 492));
        restaurantList.add(new Place(R.drawable.colony_restaurant, R.string.colony, true, "12 p.m", "2:30 p.m", "3:30 p.m", "5:30 p.m", "6:30 p.m", "11:30 p.m", R.string.colony_address, 4.5, 1208));
        restaurantList.add(new Place(R.drawable.thevar_restaurant, R.string.thevar, false, "5:30 p.m", "11 p.m", R.string.thevar_address, 4.5, 254));
        restaurantList.add(new Place(R.drawable.braci_restaurant, R.string.braci, true, "12 p.m", "1:30 p.m", "6 p.m", "11 p.m", R.string.braci_address, 4.5, 353));
        restaurantList.add(new Place(R.drawable.nox_dine_in_the_dark, R.string.nox_dine_in_the_dark, false, "6 p.m", "10:30 p.m", R.string.nox_dine_in_the_dark_address, 4.5, 833));
    }

    private void createRestaurantAdapter() {
        restaurantAdapter = new PlaceRecyclerViewAdapter(requireContext(), restaurantList, this);
        restaurantRv.setAdapter(restaurantAdapter);
        restaurantRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void releasePlaceListMemoryResources() {
        if (restaurantList != null) {
            if (!restaurantList.isEmpty()) {
                restaurantList.clear();
                restaurantList = null;
                restaurantAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onPlaceItemClicked(int position) {
        switch (position) {
            case 0: {
                takeUserToPlaceMainWebsite(R.string.odette_link);
                break;
            }
            case 1: {
                takeUserToPlaceMainWebsite(R.string.cut_by_wolfgang_puck_link);
                break;
            }
            case 2: {
                takeUserToPlaceMainWebsite(R.string.jaan_by_kirk_westaway_link);
                break;
            }
            case 3: {
                takeUserToPlaceMainWebsite(R.string.basque_kitchen_by_aitor_link);
                break;
            }
            case 4: {
                takeUserToPlaceMainWebsite(R.string.restaurant_labyrinth_link);
                break;
            }
            case 5: {
                takeUserToPlaceMainWebsite(R.string.flutes_link);
                break;
            }
            case 6: {
                takeUserToPlaceMainWebsite(R.string.corner_house_link);
                break;
            }
            case 7: {
                takeUserToPlaceMainWebsite(R.string.whitegrass_restaurant_link);
                break;
            }
            case 8: {
                takeUserToPlaceMainWebsite(R.string.naeum_restaurant_link);
                break;
            }
            case 9: {
                takeUserToPlaceMainWebsite(R.string.monti_link);
                break;
            }
            case 10: {
                takeUserToPlaceMainWebsite(R.string.skai_link);
                break;
            }
            case 11: {
                takeUserToPlaceMainWebsite(R.string.alma_by_juan_amado_link);
                break;
            }
            case 12: {
                takeUserToPlaceMainWebsite(R.string.les_amis_link);
                break;
            }
            case 13: {
                takeUserToPlaceMainWebsite(R.string.preludio_link);
                break;
            }
            case 14: {
                takeUserToPlaceMainWebsite(R.string.ocean_link);
                break;
            }
            case 15: {
                takeUserToPlaceMainWebsite(R.string.colony_link);
                break;
            }
            case 16: {
                takeUserToPlaceMainWebsite(R.string.thevar_link);
                break;
            }
            case 17: {
                takeUserToPlaceMainWebsite(R.string.braci_link);
                break;
            }
            case 18: {
                takeUserToPlaceMainWebsite(R.string.nox_dine_in_the_dark_link);
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