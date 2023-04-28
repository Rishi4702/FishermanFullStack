package com.example.fisherman.Controller;

import com.example.fisherman.DTO.FishSpeciesDTO;
import com.example.fisherman.api.FishSpeciesApi;
import com.example.fisherman.model.FishSpecies;
import com.example.fisherman.service.FishSpeciesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class FishSpeciesManagement implements FishSpeciesApi {
    FishSpeciesService fs;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return FishSpeciesApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<FishSpeciesDTO>> fishspeciesGet() {
        List<FishSpecies> s = fs.getAllFishSpecies();
        List<FishSpeciesDTO> dtos = s.stream()
                .map(FishSpecies::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FishSpeciesDTO> fishspeciesIdDelete(String id) {
        FishSpecies deletedSpecies = fs.deleteFishSpeciesById(Long.valueOf(id));
        if (deletedSpecies != null) {
            return new ResponseEntity<>(deletedSpecies.toDTO(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }}

    @Override
    public ResponseEntity<FishSpeciesDTO> fishspeciesIdGet(String id) {
        FishSpecies fishSpecies = fs.getFishSpeciesById(Long.valueOf(id));
        FishSpeciesDTO fishSpeciesDTO = fishSpecies != null ? fishSpecies.toDTO() : null;

        if (fishSpeciesDTO != null) {
            System.out.println("not null");
            return new ResponseEntity<>(fishSpeciesDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<FishSpeciesDTO> fishspeciesIdPut(String id, FishSpeciesDTO body) {
        FishSpecies s = fs.updateFishSpecies(Long.valueOf(id),body.toModel());
        if(s != null){
            return new ResponseEntity<>(s.toDTO(),HttpStatus.OK);
        }
        System.out.println("param was retuned");
        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<FishSpeciesDTO> fishspeciesPost(FishSpeciesDTO fishSpeciesDTO) {
        FishSpecies d = fs.addFishSpecies(fishSpeciesDTO.toModel());
        return new ResponseEntity<>(d.toDTO(),HttpStatus.OK);

    }
}
