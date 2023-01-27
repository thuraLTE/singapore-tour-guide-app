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

public class LuxuryHotelsFragment extends Fragment implements PlaceRecyclerViewAdapter.OnPlaceItemClickListener {

    private RecyclerView hotelRv;
    private ArrayList<Place> hotelList;
    private PlaceRecyclerViewAdapter hotelAdapter;

    public LuxuryHotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_luxury_hotels, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hookViewIds(view);
        createAListOfHotelObjects();
        createHotelAdapter();
    }

    private void hookViewIds(View view) {
        hotelRv = view.findViewById(R.id.hotel_rv);
    }

    private void createAListOfHotelObjects() {
        releasePlaceListMemoryResources();

        hotelList = new ArrayList<Place>();
        hotelList.add(new Place(R.drawable.marina_bay_sands_hotel, R.string.marina_bay_sands_hotel, "+65 6688 8888", "+65 6688 8868", R.string.marina_bay_sands_hotel_address, 5.0, 11323));
        hotelList.add(new Place(R.drawable.raffles_hotel, R.string.raffles_hotel, "+65 6412 1244", "+65 6337 1886", R.string.raffles_hotel_address, 5.0, 4009));
        hotelList.add(new Place(R.drawable.ritz_carlton_millenia, R.string.ritz_carlton_millenia, "+65 6337 8888", null, R.string.ritz_carlton_millenia_address, 5.0, 5169));
        hotelList.add(new Place(R.drawable.fullerton_bay_hotel, R.string.fullerton_bay_hotel, "+65 6333 8388", "+65 6333 8388", R.string.fullerton_bay_hotel_address, 5.0, 3492));
        hotelList.add(new Place(R.drawable.park_royal_collection, R.string.park_royal_collection, "+65 6845 1000", null, R.string.park_royal_collection_address, 5.0, 4577));
        hotelList.add(new Place(R.drawable.westin_hotel, R.string.westin, "+65 6922 6888", null, R.string.westin_address, 5.0, 1443));
        hotelList.add(new Place(R.drawable.st_regis, R.string.st_regis, "+65 6506 6888", null, R.string.st_regis_address, 5.0, 3182));
        hotelList.add(new Place(R.drawable.mandarin_oriental, R.string.mandarin_oriental, "+65 6885 3030", "+65 6338 0066", R.string.mandarin_oriental_address, 5.0, 5154));
        hotelList.add(new Place(R.drawable.capitol_kempinski, R.string.capitol_kempinski, "+65 6368 8888", "+65 6384 1929", R.string.capitol_kempinski_address, 5.0, 624));
        hotelList.add(new Place(R.drawable.clan_hotel, R.string.clan_hotel, "+65 6881 8888", "+65 6496 7699", R.string.clan_hotel_address, 5.0, 215));
        hotelList.add(new Place(R.drawable.fairmont_hotel, R.string.fairmont, "+65 6837 3883", "+65 6339 7777", R.string.fairmont_address, 5.0, 4723));
        hotelList.add(new Place(R.drawable.swissotel_hotel, R.string.hotel_swissotel, "+65 6338 8585 ", null, R.string.hotel_swissotel_address, 5.0, 5278));
        hotelList.add(new Place(R.drawable.andaz_singapore, R.string.andaz, "+65 6408 1234", null, R.string.andaz_address, 5.0, 2908));
        hotelList.add(new Place(R.drawable.four_seasons, R.string.four_seasons, "+65 6734 1110", "+65 6734 1110", R.string.four_seasons_address, 5.0, 2346));
        hotelList.add(new Place(R.drawable.sofitel, R.string.sofitel, "+65 6708 8310", "+65 6275 0228", R.string.sofitel_address, 5.0, 2911));
        hotelList.add(new Place(R.drawable.intercontinental_hotel, R.string.inter_continental, "+65 6825 1000", "+65 6338 7600", R.string.inter_continental_address, 5.0, 3506));
        hotelList.add(new Place(R.drawable.ascott_orchard, R.string.ascott_orchard, "+65 6500 3333", "+65 6500 3350", R.string.ascott_orchard_address, 4.0, 524));
        hotelList.add(new Place(R.drawable.jen_orchard_gateway, R.string.jen_singapore, "+65 6708 8888", null, R.string.jen_singapore_address, 4.0, 3237));
        hotelList.add(new Place(R.drawable.amoy, R.string.amoy_hotel, "+65 6881 8888", "+65 6580 2888", R.string.amoy_hotel_address, 4.0, 282));
        hotelList.add(new Place(R.drawable.w_singapore, R.string.w_singapore, "+65 6808 7288", null, R.string.w_singapore_address, 5.0, 2537));
        hotelList.add(new Place(R.drawable.beach_villas, R.string.beach_villas, "+65 6577 8888", null, R.string.beach_villas_address, 5.0, 125));
    }

    private void createHotelAdapter() {
        hotelAdapter = new PlaceRecyclerViewAdapter(requireContext(), hotelList, this);
        hotelRv.setAdapter(hotelAdapter);
        hotelRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void releasePlaceListMemoryResources() {
        if (hotelList != null) {
            if (!hotelList.isEmpty()) {
                hotelList.clear();
                hotelList = null;
                hotelAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onPlaceItemClicked(int position) {
        switch (position) {
            case 0: {
                takeUserToPlaceMainWebsite(R.string.marina_bay_sands_hotel_link);
                break;
            }
            case 1: {
                takeUserToPlaceMainWebsite(R.string.raffles_hotel_link);
                break;
            }
            case 2: {
                takeUserToPlaceMainWebsite(R.string.ritz_carlton_millenia_link);
                break;
            }
            case 3: {
                takeUserToPlaceMainWebsite(R.string.fullerton_bay_hotel_link);
                break;
            }
            case 4: {
                takeUserToPlaceMainWebsite(R.string.park_royal_collection_link);
                break;
            }
            case 5: {
                takeUserToPlaceMainWebsite(R.string.westin_link);
                break;
            }
            case 6: {
                takeUserToPlaceMainWebsite(R.string.st_regis_link);
                break;
            }
            case 7: {
                takeUserToPlaceMainWebsite(R.string.mandarin_oriental_link);
                break;
            }
            case 8: {
                takeUserToPlaceMainWebsite(R.string.capitol_kempinski_link);
                break;
            }
            case 9: {
                takeUserToPlaceMainWebsite(R.string.clan_hotel_link);
                break;
            }
            case 10: {
                takeUserToPlaceMainWebsite(R.string.fairmont_link);
                break;
            }
            case 11: {
                takeUserToPlaceMainWebsite(R.string.hotel_swissotel_link);
                break;
            }
            case 12: {
                takeUserToPlaceMainWebsite(R.string.andaz_link);
                break;
            }
            case 13: {
                takeUserToPlaceMainWebsite(R.string.four_seasons_link);
                break;
            }
            case 14: {
                takeUserToPlaceMainWebsite(R.string.sofitel_link);
                break;
            }
            case 15: {
                takeUserToPlaceMainWebsite(R.string.inter_continental_link);
                break;
            }
            case 16: {
                takeUserToPlaceMainWebsite(R.string.ascott_orchard_link);
                break;
            }
            case 17: {
                takeUserToPlaceMainWebsite(R.string.jen_singapore_link);
                break;
            }
            case 18: {
                takeUserToPlaceMainWebsite(R.string.amoy_hotel_link);
                break;
            }
            case 19: {
                takeUserToPlaceMainWebsite(R.string.w_singapore_link);
                break;
            }
            case 20: {
                takeUserToPlaceMainWebsite(R.string.beach_villas_link);
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