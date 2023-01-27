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

public class ShoppingMallsFragment extends Fragment implements PlaceRecyclerViewAdapter.OnPlaceItemClickListener {

    private RecyclerView shoppingMallRv;
    private ArrayList<Place> shoppingMallList;
    private PlaceRecyclerViewAdapter shoppingMallAdapter;

    public ShoppingMallsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shopping_malls, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hookViewIds(view);
        createAListOfShoppingMallObjects();
        createShoppingMallAdapter();
    }

    private void hookViewIds(View view) {
        shoppingMallRv = view.findViewById(R.id.shopping_mall_rv);
    }

    private void createAListOfShoppingMallObjects() {
        releasePlaceListMemoryResources();

        shoppingMallList = new ArrayList<Place>();
        shoppingMallList.add(new Place(R.drawable.plaza_singapura, R.string.plaza_singapura, false, "10 a.m", "10 p.m", R.string.plaza_singapura_address, 4.5, 18812));
        shoppingMallList.add(new Place(R.drawable.ion_orchard, R.string.ion_orchard, false, "10 a.m", "10 p.m", R.string.ion_orchard_address, 4.5, 24591));
        shoppingMallList.add(new Place(R.drawable.vivo_city, R.string.vivo_city, false, "10 a.m", "10 p.m", R.string.vivo_city_address, 4.5, 44640));
        shoppingMallList.add(new Place(R.drawable.shoppes_marina_bay_sands, R.string.shoppes_at_marina_bay_sands, false, "10:30 a.m", "11 p.m", R.string.shoppes_at_marina_bay_sands_address, 4.5, 17523));
        shoppingMallList.add(new Place(R.drawable.mustafa_centre, R.string.mustafa_centre, false, "9:30 a.m", "2 a.m", R.string.mustafa_centre_address, 4.5, 3315));
        shoppingMallList.add(new Place(R.drawable.bugis_junction, R.string.bugis_junction, false, "10 a.m", "10 p.m", R.string.bugis_junction_address, 4.5, 12570));
        shoppingMallList.add(new Place(R.drawable.mandarin_gallery, R.string.mandarin_gallery, false, "11 a.m", "10 p.m", R.string.mandarin_gallery_address, 4.5, 2819));
        shoppingMallList.add(new Place(R.drawable.ngee_ann_city, R.string.ngee_ann_city, false, "10 a.m", "9:30 p.m", R.string.ngee_ann_city_address, 4.5, 14503));
        shoppingMallList.add(new Place(R.drawable.suntec_city, R.string.suntec_city, false, "10 a.m", "10 p.m", R.string.suntec_city_address, 4.5, 22683));
        shoppingMallList.add(new Place(R.drawable.far_east_plaza, R.string.far_east_plaza, false, "10 a.m", "10 p.m", R.string.far_east_plaza_address, 4.0, 5344));
        shoppingMallList.add(new Place(R.drawable.city_square_mall, R.string.city_square_mall, false, "10 a.m", "10 p.m", R.string.city_square_mall_address, 4.5, 19007));
        shoppingMallList.add(new Place(R.drawable.clarke_quay_central, R.string.clarke_quay_central, false, "11 a.m", "10 p.m", R.string.clarke_quay_central_address, 4.5, 9630));
        shoppingMallList.add(new Place(R.drawable.marine_square, R.string.marine_square, false, "10 a.m", "10 p.m", R.string.marine_square_address, 4.5, 15107));
        shoppingMallList.add(new Place(R.drawable.nex, R.string.nex, false, "10:30 a.m", "10:30 p.m", R.string.nex_address, 4.5, 19000));
        shoppingMallList.add(new Place(R.drawable.paragon, R.string.paragon, false, "10 a.m", "10 p.m", R.string.paragon_address, 4.5, 11900));
        shoppingMallList.add(new Place(R.drawable.raffles_city, R.string.raffles_city, false, "10 a.m", "10 p.m", R.string.raffles_city_address, 4.5, 1785));
        shoppingMallList.add(new Place(R.drawable.funan, R.string.funan, false, "10 a.m", "10 p.m", R.string.funan_address, 4.5, 5609));
        shoppingMallList.add(new Place(R.drawable.kallang_wave_mall, R.string.kallang_wave_mall, false, "10 a.m", "10 p.m", R.string.kallang_wave_mall_address, 4.0, 7989));
        shoppingMallList.add(new Place(R.drawable.the_centrepoint, R.string.centrepoint, false, "10 a.m", "10 p.m", R.string.centrepoint_address, 4.0, 4636));
    }

    private void createShoppingMallAdapter() {
        shoppingMallAdapter = new PlaceRecyclerViewAdapter(requireContext(), shoppingMallList, this);
        shoppingMallRv.setAdapter(shoppingMallAdapter);
        shoppingMallRv.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void releasePlaceListMemoryResources() {
        if (shoppingMallList != null) {
            if (!shoppingMallList.isEmpty()) {
                shoppingMallList.clear();
                shoppingMallList = null;
                shoppingMallAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onPlaceItemClicked(int position) {
        switch (position) {
            case 0: {
                takeUserToPlaceMainWebsite(R.string.plaza_singapura_link);
                break;
            }
            case 1: {
                takeUserToPlaceMainWebsite(R.string.ion_orchard_link);
                break;
            }
            case 2: {
                takeUserToPlaceMainWebsite(R.string.vivo_city_link);
                break;
            }
            case 3: {
                takeUserToPlaceMainWebsite(R.string.shoppes_at_marina_bay_sands_link);
                break;
            }
            case 4: {
                takeUserToPlaceMainWebsite(R.string.mustafa_centre_link);
                break;
            }
            case 5: {
                takeUserToPlaceMainWebsite(R.string.bugis_junction_link);
                break;
            }
            case 6: {
                takeUserToPlaceMainWebsite(R.string.mandarin_gallery_link);
                break;
            }
            case 7: {
                takeUserToPlaceMainWebsite(R.string.ngee_ann_city_link);
                break;
            }
            case 8: {
                takeUserToPlaceMainWebsite(R.string.suntec_city_link);
                break;
            }
            case 9: {
                takeUserToPlaceMainWebsite(R.string.far_east_plaza_link);
                break;
            }
            case 10: {
                takeUserToPlaceMainWebsite(R.string.city_square_mall_link);
                break;
            }
            case 11: {
                takeUserToPlaceMainWebsite(R.string.clarke_quay_central_link);
                break;
            }
            case 12: {
                takeUserToPlaceMainWebsite(R.string.marine_square_link);
                break;
            }
            case 13: {
                takeUserToPlaceMainWebsite(R.string.nex_link);
                break;
            }
            case 14: {
                takeUserToPlaceMainWebsite(R.string.paragon_link);
                break;
            }
            case 15: {
                takeUserToPlaceMainWebsite(R.string.raffles_city_link);
                break;
            }
            case 16: {
                takeUserToPlaceMainWebsite(R.string.funan_link);
                break;
            }
            case 17: {
                takeUserToPlaceMainWebsite(R.string.kallang_wave_mall_link);
                break;
            }
            case 18: {
                takeUserToPlaceMainWebsite(R.string.centrepoint_link);
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