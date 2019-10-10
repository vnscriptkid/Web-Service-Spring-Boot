package com.example.webservicespringboot.service;

import java.util.List;

import com.example.webservicespringboot.entity.Location;
import com.example.webservicespringboot.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
  @Autowired
  LocationRepository locationRepository;

  public List<Location> retrieveLocations() {
    return (List<Location>) locationRepository.findAll();
  }
}