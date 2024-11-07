package com.example.HUGOTravelPlanner.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Embeddable
@Table(name = "trips")
public class Trip {
    @Id
    private Long id;
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "latitude")
    private Double lat;

    @Column(name = "longitude")
    private Double lng;

    @Column(columnDefinition = "json")
    private String days;

    // Getters and Setters

    public List<DayAttribute> getDays_attributes() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(days, new TypeReference<List<DayAttribute>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>(); // Return empty list on error
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
    public String toString() {
        return "Trip{" +
                "city='" + city + '\'' +
                ", latitude=" + lat +
                ", longitude=" + lng +
                ", days='" + days + '\'' +
                '}';
    }
}
