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
import java.util.Objects;

public class PublicAttractionFragment extends Fragment implements PlaceRecyclerViewAdapter.OnPlaceItemClickListener {

    private RecyclerView publicAttractionRv;
    private ArrayList<Place> publicAttractionList;
    private PlaceRecyclerViewAdapter publicAttractionAdapter;

    public PublicAttractionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_public_attraction, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hookViewIds(view);
        createAListOfPublicAttractionObjects();
        createPublicAttractionAdapter();
    }

    private void hookViewIds(View view) {
        publicAttractionRv = view.findViewById(R.id.public_attraction_rv);
    }

    private void createAListOfPublicAttractionObjects() {
        releasePlaceListMemoryResources();

        publicAttractionList = new ArrayList<Place>();
        publicAttractionList.add(new Place(R.drawable.marina_bay_sands, R.string.marina_bay_sands, false, "10 a.m", "12 p.m", R.string.marina_bay_sands_address, 4.5, 29571));
        publicAttractionList.add(new Place(R.drawable.botanic_gardens, R.string.botanic_gardens, false, "5 a.m", "12 a.m", R.string.botanic_gardens_address, 4.5, 19847));
        publicAttractionList.add(new Place(R.drawable.merlion_park, R.string.merlion_park, true, null, null, R.string.botanic_gardens_address, 4.0, 9560));
        publicAttractionList.add(new Place(R.drawable.clarke_quay, R.string.clarke_quay, false, "10 a.m", "10 p.m", R.string.clarke_quay_address, 4.5, 3387));
        publicAttractionList.add(new Place(R.drawable.orchard_road, R.string.orchard_road, true, null, null, R.string.orchard_road_address, 4.0, 13516));
        publicAttractionList.add(new Place(R.drawable.helix_bridge, R.string.helix_bridge, true, null, null, R.string.helix_bridge_address, 4.5, 2898));
        publicAttractionList.add(new Place(R.drawable.southern_ridges, R.string.southern_ridges, true, null, null, R.string.southern_ridges_address, 4.5, 1173));
        publicAttractionList.add(new Place(R.drawable.fort_canning_park, R.string.fort_canning_park, true, null, null, R.string.fort_canning_park_address, 4.0, 1087));
        publicAttractionList.add(new Place(R.drawable.east_coast_park, R.string.east_coast_park, true, null, null, R.string.east_coast_park_address, 4.5, 1226));
        publicAttractionList.add(new Place(R.drawable.china_town, R.string.china_town, false, "8 a.m", "12 a.m", R.string.china_town_address, 4.0, 14422));
        publicAttractionList.add(new Place(R.drawable.sultan_mosque, R.string.sultan_mosque, false, "9:30 a.m", "4 p.m", R.string.sultan_mosque_address, 4.0, 1066));
    }

    private void createPublicAttractionAdapter() {
        publicAttractionAdapter = new PlaceRecyclerViewAdapter(requireContext(), publicAttractionList, this);
        publicAttractionRv.setAdapter(publicAttractionAdapter);
        publicAttractionRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void releasePlaceListMemoryResources() {
        if (publicAttractionList != null) {
            if (!publicAttractionList.isEmpty()) {
                publicAttractionList.clear();
                publicAttractionList = null;
                publicAttractionAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onPlaceItemClicked(int position) {
        switch (position) {
            case 0: {
                takeUserToWikipedia(R.string.marina_bay_sands);
                break;
            }
            case 1: {
                takeUserToWikipedia(R.string.botanic_gardens);
                break;
            }
            case 2: {
                takeUserToWikipedia(R.string.merlion_park);
                break;
            }
            case 3: {
                takeUserToWikipedia(R.string.clarke_quay);
                break;
            }
            case 4: {
                takeUserToWikipedia(R.string.orchard_road);
                break;
            }
            case 5: {
                takeUserToWikipedia(R.string.helix_bridge);
                break;
            }
            case 6: {
                takeUserToWikipedia(R.string.southern_ridges);
                break;
            }
            case 7: {
                takeUserToWikipedia(R.string.fort_canning_park);
                break;
            }
            case 8: {
                takeUserToWikipedia(R.string.east_coast_park);
                break;
            }
            case 9: {
                takeUserToWikipedia(R.string.china_town);
                break;
            }
            case 10: {
                takeUserToWikipedia(R.string.sultan_mosque);
                break;
            }
            case 11: {
                takeUserToPlaceMainWebsite(R.string.siloso_beach_resort_link);
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