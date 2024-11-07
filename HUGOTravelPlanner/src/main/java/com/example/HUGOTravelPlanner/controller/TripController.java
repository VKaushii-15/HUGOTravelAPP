package com.example.HUGOTravelPlanner.controller;

import com.example.HUGOTravelPlanner.model.Day;
import com.example.HUGOTravelPlanner.model.Place;
import com.example.HUGOTravelPlanner.model.Trip;
import com.example.HUGOTravelPlanner.model.TripData;
import com.example.HUGOTravelPlanner.repository.UserRepository;
//import com.example.HUGOTravelPlanner.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TripController {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @PostMapping("/trips")
    public ResponseEntity<String> createTrip(@RequestBody Trip tripData) {
        try {
            System.out.println("Received Trip: " + tripData.toString());
            Trip trip = new Trip();

            trip.setCity(tripData.getCity());
            trip.setLat(tripData.getLat());
            trip.setLng(tripData.getLng());
            trip.setDays(tripData.getDays());

            // Log received trip data
            System.out.println("Received Trip: " + trip.toString());
            System.out.println("City: " + trip.getCity());
            System.out.println("Latitude: " + trip.getLat());
            System.out.println("Longitude: " + trip.getLng());
            System.out.println("Days: " + trip.getDays());

            // Convert days to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String daysJson = objectMapper.writeValueAsString(trip.getDays_attributes());
            trip.setDays(daysJson);

            // Save trip to the database
            //userRepository.insertItenerary(trip);

            return ResponseEntity.ok("Itinerary inserted");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving trip data");
        }
    }
}


