package com.example.tourguide.main.adapters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tourguide.main.ui.fragments.AmusementsFragment;
import com.example.tourguide.main.ui.fragments.AdventuresAndToursFragment;
import com.example.tourguide.main.ui.fragments.FineDiningRestaurantsFragment;
import com.example.tourguide.main.ui.fragments.LuxuryHotelsFragment;
import com.example.tourguide.main.ui.fragments.PublicAttractionFragment;
import com.example.tourguide.main.ui.fragments.ShoppingMallsFragment;

public class CustomFragmentStateAdapter extends FragmentStateAdapter {

    public CustomFragmentStateAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: {
                return new PublicAttractionFragment();
            }
            case 1: {
                return new AmusementsFragment();
            }
            case 2: {
                return new FineDiningRestaurantsFragment();
            }
            case 3: {
                return new LuxuryHotelsFragment();
            }
            case 4: {
                return new ShoppingMallsFragment();
            }
            case 5: {
                return new AdventuresAndToursFragment();
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
