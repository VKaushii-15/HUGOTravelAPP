package com.example.HUGOTravelPlanner.model;

import java.util.List;

public class DayAttribute {
    private String date;
    private List<PlaceAttribute> places_attributes;

    // Getters and Setters

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<PlaceAttribute> getPlaces_attributes() {
        return places_attributes;
    }

    public void setPlaces_attributes(List<PlaceAttribute> places_attributes) {
        this.places_attributes = places_attributes;
    }
}
