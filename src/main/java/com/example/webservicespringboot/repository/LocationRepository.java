package com.example.webservicespringboot.repository;

import com.example.webservicespringboot.entity.Location;

import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}