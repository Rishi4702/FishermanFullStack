package com.example.fisherman.repository;

import com.example.fisherman.DTO.LocationDTO;
import com.example.fisherman.model.Fisherman;
import com.example.fisherman.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Long> {
    List<Location> findByName(String name);
}
