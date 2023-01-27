package com.example.tourguide.main.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tourguide.R;
import com.example.tourguide.main.adapters.CustomFragmentStateAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private TabLayoutMediator mediator;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        createCustomToolbar(view);

        bindViewIds(view);
        createViewPager2Adapter();

        detachTabLayoutMediator();
        attachTabLayoutMediator();
    }

    private void createCustomToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    private void bindViewIds(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager2 = view.findViewById(R.id.viewPager2);
    }

    private void createViewPager2Adapter() {
        viewPager2.setAdapter(new CustomFragmentStateAdapter(this));
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }

    private void attachTabLayoutMediator() {
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setIcon(getTabIcon(position));
            tab.setText(getTabTitle(position));
        });
        mediator.attach();
    }

    private int getTabIcon(int position) {
        switch (position) {
            case 0: {
                return R.drawable.ic_public;
            }
            case 1: {
                return R.drawable.ic_amusement;
            }
            case 2: {
                return R.drawable.ic_restaurant;
            }
            case 3: {
                return R.drawable.ic_hotel;
            }
            case 4: {
                return R.drawable.ic_shopping;
            }
            case 5: {
                return R.drawable.ic_adventure;
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    private String getTabTitle(int position) {
        switch (position) {
            case 0: {
                return getString(R.string.public_attractions);
            }
            case 1: {
                return getString(R.string.amusements);
            }
            case 2: {
                return getString(R.string.fine_dining_restaurants);
            }
            case 3: {
                return getString(R.string.luxury_hotels);
            }
            case 4: {
                return getString(R.string.shopping_malls);
            }
            case 5: {
                return getString(R.string.adventures_and_tours);
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    // Detach the TabLayout Mediator
    private void detachTabLayoutMediator() {
        if (mediator != null) {
            if (mediator.isAttached()) {
                mediator.detach();
                mediator = null;
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        detachTabLayoutMediator();
    }
}