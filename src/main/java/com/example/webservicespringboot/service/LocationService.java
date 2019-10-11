package com.example.webservicespringboot.service;

import java.util.List;

import com.example.webservicespringboot.entity.Location;

public interface LocationService {
  List<Location> retrieveLocations();

  Location retrieveLocation(long id);
}