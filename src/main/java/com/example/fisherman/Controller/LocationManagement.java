package com.example.fisherman.Controller;

import com.example.fisherman.DTO.LocationDTO;
import com.example.fisherman.api.LocationManagementApi;
import com.example.fisherman.model.Location;
import com.example.fisherman.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class LocationManagement implements LocationManagementApi {
    @Autowired
    LocationService ls;
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return LocationManagementApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<LocationDTO>> locationsGet(String name) {
        if(Objects.equals(name, ".")){
            List<Location> s = ls.getAll();
            List<LocationDTO> dtoList = s.stream().map(location -> location.toDTO()).collect(Collectors.toList());
            return new ResponseEntity<>(dtoList, HttpStatus.OK);
        }
        List<Location> s = ls.findLocationByName(name);
        List<LocationDTO> dtoList = s.stream().map(location -> location.toDTO()).collect(Collectors.toList());

        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> locationsIdDelete(String id) {
        ls.deleteLocationById(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> locationsIdPut(String id, LocationDTO body) {
       ls.updateLocation(Long.parseLong(id),body.toModel());
       return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> locationsPost(LocationDTO body) {
      Location l = body.toModel();
      ls.addLocation(l);
      return ResponseEntity.ok().build();
    }
}
