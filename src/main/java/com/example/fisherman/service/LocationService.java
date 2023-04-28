package com.example.fisherman.service;

import com.example.fisherman.DTO.LocationDTO;
import com.example.fisherman.model.Location;

import java.util.List;

public interface LocationService {

  void addLocation(Location location);
  Location deleteLocationById(long id);
  Location updateLocation(long id,Location location);
   List<Location> findLocationByName(String name);
    List<Location> getAll();
}
