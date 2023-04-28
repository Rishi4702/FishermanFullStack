package com.example.fisherman.service;

import com.example.fisherman.DTO.FishermanDTO;
import com.example.fisherman.model.Fisherman;

import java.util.List;

public interface FishermanService {
    void addFisherman(Fisherman fisherman);
    Fisherman deleteFishermanById(long id);
    Fisherman updateFisherman(Fisherman fisherman,Long id);
    List<FishermanDTO> findFishermenByName(String name);
}
