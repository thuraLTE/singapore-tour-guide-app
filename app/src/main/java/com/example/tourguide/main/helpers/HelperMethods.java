package com.example.tourguide.main.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.view.View;
import android.widget.ImageView;

import com.example.tourguide.R;

import java.text.DecimalFormat;

public class HelperMethods {

    // Check if the device is connected to the internet
    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return networkCapabilities != null && (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI));
    }

    // Format the styling of review count
    public static String formatReviewCount(int review) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(review);
    }

    // Decide the amount of rating stars based on rating value
    public static void calculateRatingStarLevel(double rating, ImageView star1, ImageView star2, ImageView star3, ImageView star4, ImageView star5) {
        if (rating == 0.5) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_half_star_24);
        } else if (rating == 1.0) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);
        } else if (rating == 1.5) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);

            star2.setVisibility(View.VISIBLE);
            star2.setImageResource(R.drawable.ic_half_star_24);
        } else if (rating == 2.0) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);

            star2.setVisibility(View.VISIBLE);
            star2.setImageResource(R.drawable.ic_full_star_24);
        } else if (rating == 2.5) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);

            star2.setVisibility(View.VISIBLE);
            star2.setImageResource(R.drawable.ic_full_star_24);

            star3.setVisibility(View.VISIBLE);
            star3.setImageResource(R.drawable.ic_half_star_24);
        } else if (rating == 3.0) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);

            star2.setVisibility(View.VISIBLE);
            star2.setImageResource(R.drawable.ic_full_star_24);

            star3.setVisibility(View.VISIBLE);
            star3.setImageResource(R.drawable.ic_full_star_24);
        } else if (rating == 3.5) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);

            star2.setVisibility(View.VISIBLE);
            star2.setImageResource(R.drawable.ic_full_star_24);

            star3.setVisibility(View.VISIBLE);
            star3.setImageResource(R.drawable.ic_full_star_24);

            star4.setVisibility(View.VISIBLE);
            star4.setImageResource(R.drawable.ic_half_star_24);
        } else if (rating == 4.0) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);

            star2.setVisibility(View.VISIBLE);
            star2.setImageResource(R.drawable.ic_full_star_24);

            star3.setVisibility(View.VISIBLE);
            star3.setImageResource(R.drawable.ic_full_star_24);

            star4.setVisibility(View.VISIBLE);
            star4.setImageResource(R.drawable.ic_full_star_24);
        } else if (rating == 4.5) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);

            star2.setVisibility(View.VISIBLE);
            star2.setImageResource(R.drawable.ic_full_star_24);

            star3.setVisibility(View.VISIBLE);
            star3.setImageResource(R.drawable.ic_full_star_24);

            star4.setVisibility(View.VISIBLE);
            star4.setImageResource(R.drawable.ic_full_star_24);

            star5.setVisibility(View.VISIBLE);
            star5.setImageResource(R.drawable.ic_half_star_24);
        } else if (rating == 5.0) {
            star1.setVisibility(View.VISIBLE);
            star1.setImageResource(R.drawable.ic_full_star_24);

            star2.setVisibility(View.VISIBLE);
            star2.setImageResource(R.drawable.ic_full_star_24);

            star3.setVisibility(View.VISIBLE);
            star3.setImageResource(R.drawable.ic_full_star_24);

            star4.setVisibility(View.VISIBLE);
            star4.setImageResource(R.drawable.ic_full_star_24);

            star5.setVisibility(View.VISIBLE);
            star5.setImageResource(R.drawable.ic_full_star_24);
        }
    }
}
