package com.example.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.entity.Location;
import com.example.exception.LocationNotFoundException;
import com.example.repository.LocationRepository;

import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
  private LocationRepository locationRepository;

  public Query(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public Iterable<Location> findAllLocations() {
    return this.locationRepository.findAll();
  }

  public Location findLocationById(Long id) {
    Optional<Location> optional = this.locationRepository.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    }
    throw new LocationNotFoundException("Location not found", id);
  }

}