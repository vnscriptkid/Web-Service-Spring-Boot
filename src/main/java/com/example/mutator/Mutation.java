package com.example.mutator;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.entity.Location;
import com.example.exception.LocationNotFoundException;
import com.example.repository.LocationRepository;

import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
  private LocationRepository locationRepository;

  public Mutation(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }

  public Location newLocation(String name, String address) {
    return this.locationRepository.save(new Location(name, address));
  }

  public boolean deleteLocation(Long id) {
    this.locationRepository.deleteById(id);
    return true;
  }

  public Location updateLocationName(String newName, Long id) {
    Optional<Location> optional = this.locationRepository.findById(id);
    if (optional.isPresent()) {
      Location location = optional.get();
      location.setName(newName);
      this.locationRepository.save(location);
      return location;
    } else {
      throw new LocationNotFoundException("Location not found", id);
    }
  }
}