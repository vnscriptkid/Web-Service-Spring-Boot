package com.example.webservicespringboot.web;

import java.util.List;

import com.example.webservicespringboot.entity.Location;
import com.example.webservicespringboot.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
  private LocationService locationService;

  @Autowired
  public void setLocationService(LocationService locationService) {
    this.locationService = locationService;
  }

  @GetMapping("/locations")
  public ResponseEntity<List<Location>> getAllLocations() {
    List<Location> list = locationService.retrieveLocations();
    return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
  }

  @GetMapping("/locations/{id}")
  public ResponseEntity<Location> getLocation(@PathVariable("id") long id) {
    Location location = locationService.retrieveLocation(id);
    return new ResponseEntity<Location>(location, HttpStatus.OK);
  }
}