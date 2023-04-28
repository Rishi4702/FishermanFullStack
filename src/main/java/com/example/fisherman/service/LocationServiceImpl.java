package com.example.fisherman.service;

import com.example.fisherman.DTO.LocationDTO;
import com.example.fisherman.model.Location;
import com.example.fisherman.repository.LocationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Location deleteLocationById(long id) {
        Optional<Location> c = locationRepository.findById(id);
        c.ifPresent(course -> locationRepository.deleteById(id));
        return c.get();
    }

    @Override
    public Location updateLocation(long id,Location location) {
        Optional<Location> c = locationRepository.findById(id);
        if (c.isEmpty()) {
            System.out.println("value was not present");
            return null;
        }else{
            System.out.println(c.get().toString());
        }
        Location personToUpdate = c.get();

        if (location.getName() != null) {
            personToUpdate.setName(location.getName());
        }
        if (location.getDescription() != null) {
            personToUpdate.setDescription(location.getDescription());
        }
        if (location.getSpotType() != null) {
            personToUpdate.setSpotType(location.getSpotType());
        }
        if (location.getLatitude() != 0) {
            personToUpdate.setLatitude(location.getLatitude());
        }
        if (location.getLongitude() != 0) {
            personToUpdate.setLongitude(location.getLongitude());
        }
        Location up = locationRepository.save(personToUpdate);
        return up;
    }


    @Override
    public List<Location> findLocationByName(String name) {
        return locationRepository.findByName(name);
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }
}
