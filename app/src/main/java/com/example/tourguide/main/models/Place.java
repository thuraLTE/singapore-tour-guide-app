package com.example.tourguide.main.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

public class Place {
    private final int imageId;
    private final int name;
    private boolean is24hrOpened;
    private boolean isTwoTimeSeparated;
    private boolean isThreeTimeSeparated;
    private String firstOpeningTime;
    private String firstClosingTime;
    private String secondOpeningTime;
    private String secondClosingTime;
    private String thirdOpeningTime;
    private String thirdClosingTime;
    private String primaryPhoneNumber;
    private String secondaryPhoneNumber;
    private final int address;
    private final double rating;
    private final int review;

    public Place(int imageId, int name, @NonNull String primaryPhoneNumber, @Nullable String secondaryPhoneNumber, int address, double rating, int review) {
        this.imageId = imageId;
        this.name = name;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.address = address;
        this.rating = rating;
        this.review = review;
    }

    public Place(int imageId, int name, boolean is24hrOpened, @Nullable String firstOpeningTime, @Nullable String firstClosingTime, int address, double rating, int review) {
        this.imageId = imageId;
        this.name = name;
        this.is24hrOpened = is24hrOpened;
        this.firstOpeningTime = firstOpeningTime;
        this.firstClosingTime = firstClosingTime;
        this.address = address;
        this.rating = rating;
        this.review = review;
    }

    public Place(int imageId, int name, boolean isTwoTimeSeparated, @NotNull String firstOpeningTime, @NotNull String firstClosingTime, @Nullable String secondOpeningTime, @Nullable String secondClosingTime, int address, double rating, int review) {
        this.imageId = imageId;
        this.name = name;
        this.isTwoTimeSeparated = isTwoTimeSeparated;
        this.firstOpeningTime = firstOpeningTime;
        this.firstClosingTime = firstClosingTime;
        this.secondOpeningTime = secondOpeningTime;
        this.secondClosingTime = secondClosingTime;
        this.address = address;
        this.rating = rating;
        this.review = review;
    }

    public Place(int imageId, int name, boolean isThreeTimeSeparated, @NonNull String firstOpeningTime, @NonNull String firstClosingTime, @NonNull String secondOpeningTime, @NonNull String secondClosingTime, @Nullable String thirdOpeningTime, @Nullable String thirdClosingTime, int address, double rating, int review) {
        this.imageId = imageId;
        this.name = name;
        this.isThreeTimeSeparated = isThreeTimeSeparated;
        this.firstOpeningTime = firstOpeningTime;
        this.firstClosingTime = firstClosingTime;
        this.secondOpeningTime = secondOpeningTime;
        this.secondClosingTime = secondClosingTime;
        this.thirdOpeningTime = thirdOpeningTime;
        this.thirdClosingTime = thirdClosingTime;
        this.address = address;
        this.rating = rating;
        this.review = review;
    }

    public int getImageId() {
        return imageId;
    }

    public int getName() {
        return name;
    }

    public boolean is24hrOpened() {
        return is24hrOpened;
    }

    public boolean isTwoTimeSeparated() {
        return isTwoTimeSeparated;
    }

    public boolean isThreeTimeSeparated() {
        return isThreeTimeSeparated;
    }

    public String getFirstOpeningTime() {
        return firstOpeningTime;
    }

    public String getFirstClosingTime() {
        return firstClosingTime;
    }

    public String getSecondOpeningTime() {
        return secondOpeningTime;
    }

    public String getSecondClosingTime() {
        return secondClosingTime;
    }

    public String getThirdOpeningTime() {
        return thirdOpeningTime;
    }

    public String getThirdClosingTime() {
        return thirdClosingTime;
    }

    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public int getAddress() {
        return address;
    }

    public double getRating() {
        return rating;
    }

    public int getReview() {
        return review;
    }
}
