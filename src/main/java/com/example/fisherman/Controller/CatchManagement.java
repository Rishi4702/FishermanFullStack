package com.example.fisherman.Controller;

import com.example.fisherman.DTO.LocationDTO;
import com.example.fisherman.DTO.ModelCatchDTO;
import com.example.fisherman.api.CatchManagementApi;
import com.example.fisherman.model.FishSpecies;
import com.example.fisherman.model.Fisherman;
import com.example.fisherman.model.Location;
import com.example.fisherman.model.ModelCatch;
import com.example.fisherman.repository.FishSpeciesRepository;
import com.example.fisherman.repository.FishermanRepository;
import com.example.fisherman.repository.LocationRepository;
import com.example.fisherman.repository.ModelCatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CatchManagement implements CatchManagementApi {
    @Autowired
    private ModelCatchRepository modelCatchRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private FishermanRepository fishermanRepository;

    @Autowired
    private FishSpeciesRepository fishSpeciesRepository;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return CatchManagementApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<ModelCatchDTO>> catchesGet() {
       // List<LocationDTO> dtoList = s.stream().map(location -> location.toDTO()).collect(Collectors.toList());
        List<ModelCatchDTO> s = modelCatchRepository.findAll().stream().map(model -> model.toDTO()).collect(Collectors.toList());
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> catchesPost(String species, BigDecimal length, BigDecimal weight, BigDecimal quantity, BigDecimal locationId, BigDecimal fishSpeciesId,BigDecimal fishermanId) {
        // Check if the provided location ID exists
        Optional<Location> location = locationRepository.findById(Long.parseLong(locationId.toString()));
        if (!location.isPresent()) {
            return ResponseEntity.badRequest().body("please enter valid location id");
        }

        // Check if the provided fisherman ID exists
        Optional<Fisherman> fisherman = fishermanRepository.findById(Long.parseLong(fishermanId.toString()));
        if (!fisherman.isPresent()) {
            return ResponseEntity.badRequest().body("please enter valid fisherman id");
        }

        // Check if the provided fish species ID exists
        Optional<FishSpecies> fishSpecies = fishSpeciesRepository.findById(Long.parseLong(fishSpeciesId.toString()));
        if (!fishSpecies.isPresent()) {
            return ResponseEntity.badRequest().body("please enter valid fishspecies id");
        }

        // Create a new model catch object
        ModelCatch modelCatch = new ModelCatch();
        modelCatch.setLength(Integer.parseInt(length.toString()));
        modelCatch.setWeight(Double.parseDouble(weight.toString()));
        modelCatch.setQuantity(Integer.parseInt(quantity.toString()));
        modelCatch.setSpecies(species);
        modelCatch.setLocation(location.get());
        modelCatch.setFisherman(fisherman.get());
        modelCatch.setFishSpecies(fishSpecies.get());
        System.out.println(modelCatch.toString());
        // Save the model catch object
        modelCatch = modelCatchRepository.save(modelCatch);

        return ResponseEntity.ok().body("everything was done correctly");
    }
}
