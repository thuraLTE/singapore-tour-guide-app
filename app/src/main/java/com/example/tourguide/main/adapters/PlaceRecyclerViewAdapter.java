package com.example.tourguide.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourguide.R;
import com.example.tourguide.main.helpers.HelperMethods;
import com.example.tourguide.main.models.Place;
import com.example.tourguide.main.ui.activities.MainActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PlaceRecyclerViewAdapter extends RecyclerView.Adapter<PlaceRecyclerViewAdapter.PlaceViewHolder> {

    private final Context context;
    private final ArrayList<Place> placeList;
    private final OnPlaceItemClickListener clickListener;

    public PlaceRecyclerViewAdapter(@NonNull Context context, @NonNull ArrayList<Place> placeList, @NonNull OnPlaceItemClickListener clickListener) {
        this.context = context;
        this.placeList = placeList;
        this.clickListener = clickListener;
    }

    public Context getContext() {
        return context;
    }

    public ArrayList<Place> getPlaceList() {
        return placeList;
    }

    // Create a custom interface for recycler view's on item click listener
    public interface OnPlaceItemClickListener {
        void onPlaceItemClicked(int position);
    }

    public class PlaceViewHolder extends RecyclerView.ViewHolder {
        private final View parentView;
        private final ImageView placeImage;
        private final TextView placeName;
        private final ImageView operatingHourIcon;
        private final TextView placeOperatingHours;
        private final TextView placeAddress;
        private final TextView placeReviewCount;
        private final ImageView star1;
        private final ImageView star2;
        private final ImageView star3;
        private final ImageView star4;
        private final ImageView star5;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            parentView = ((MainActivity) getContext()).findViewById(R.id.fragment_parent_view);
            placeImage = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.place_name);
            operatingHourIcon = itemView.findViewById(R.id.ic_operating_hours);
            placeOperatingHours = itemView.findViewById(R.id.place_operating_hours);
            placeAddress = itemView.findViewById(R.id.place_address);
            placeReviewCount = itemView.findViewById(R.id.place_review_count);
            star1 = itemView.findViewById(R.id.first_star);
            star2 = itemView.findViewById(R.id.second_star);
            star3 = itemView.findViewById(R.id.third_star);
            star4 = itemView.findViewById(R.id.fourth_star);
            star5 = itemView.findViewById(R.id.fifth_star);

            // Check if there's an internet connectivity, otherwise show a snackbar to user
            itemView.setOnClickListener(view -> {
                if (HelperMethods.isConnectedToInternet(getContext()))
                    clickListener.onPlaceItemClicked(getAdapterPosition());
                else {
                    Snackbar snackbar = Snackbar.make(parentView, "Internet Connection Required!", Snackbar.LENGTH_SHORT);
                    snackbar.setAction("Connect", view2 -> {
                        Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        getContext().startActivity(intent);
                    });
                    snackbar.show();
                }
            });
        }

        public ImageView getPlaceImage() {
            return placeImage;
        }

        public TextView getPlaceName() {
            return placeName;
        }

        public ImageView getOperatingHourIcon() {
            return operatingHourIcon;
        }

        public TextView getPlaceOperatingHours() {
            return placeOperatingHours;
        }

        public TextView getPlaceAddress() {
            return placeAddress;
        }

        public TextView getPlaceReviewCount() {
            return placeReviewCount;
        }

        public ImageView getStar1() {
            return star1;
        }

        public ImageView getStar2() {
            return star2;
        }

        public ImageView getStar3() {
            return star3;
        }

        public ImageView getStar4() {
            return star4;
        }

        public ImageView getStar5() {
            return star5;
        }
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tour_list_items, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        Place currentPlace = getPlaceList().get(position);

        holder.getPlaceImage().setImageResource(currentPlace.getImageId());
        holder.getPlaceName().setText(currentPlace.getName());
        // Check if the place is opened 24 hours
        if (currentPlace.is24hrOpened())
            holder.getPlaceOperatingHours().setText(R.string.twenty_four_hour_open);
        else {
            holder.getPlaceOperatingHours().setText(context.getString(R.string.placeholder_one_time_operating_hours, currentPlace.getFirstOpeningTime(), currentPlace.getFirstClosingTime()));
        }
        // Check if the place has two-shift operating hours
        if (currentPlace.isTwoTimeSeparated())
            holder.getPlaceOperatingHours().setText(context.getString(R.string.placeholder_two_time_operating_hours, currentPlace.getFirstOpeningTime(), currentPlace.getFirstClosingTime(), currentPlace.getSecondOpeningTime(), currentPlace.getSecondClosingTime()));
        // Check if the place has three-shift operating hours
        if (currentPlace.isThreeTimeSeparated())
            holder.getPlaceOperatingHours().setText(context.getString(R.string.placeholder_three_time_operating_hours, currentPlace.getFirstOpeningTime(), currentPlace.getFirstClosingTime(), currentPlace.getSecondOpeningTime(), currentPlace.getSecondClosingTime(), currentPlace.getThirdOpeningTime(), currentPlace.getThirdClosingTime()));
        // Check if the place has contact phone numbers
        if (currentPlace.getPrimaryPhoneNumber() != null) {
            holder.getOperatingHourIcon().setImageResource(R.drawable.ic_telephone);
            holder.getPlaceOperatingHours().setText(currentPlace.getPrimaryPhoneNumber());
            if (currentPlace.getSecondaryPhoneNumber() != null)
                holder.getPlaceOperatingHours().setText(context.getString(R.string.placeholder_place_phone_number, currentPlace.getPrimaryPhoneNumber(), currentPlace.getSecondaryPhoneNumber()));
        }
        holder.getPlaceAddress().setText(currentPlace.getAddress());
        holder.getPlaceReviewCount().setText(HelperMethods.formatReviewCount(currentPlace.getReview()));
        HelperMethods.calculateRatingStarLevel(currentPlace.getRating(), holder.getStar1(), holder.getStar2(), holder.getStar3(), holder.getStar4(), holder.getStar5());
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }


}
