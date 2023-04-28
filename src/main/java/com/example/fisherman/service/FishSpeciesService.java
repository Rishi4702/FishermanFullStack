package com.example.fisherman.service;

import com.example.fisherman.model.FishSpecies;


import java.util.List;

public interface FishSpeciesService {
  FishSpecies getFishSpeciesById(Long id);
  List<FishSpecies> getAllFishSpecies();
  FishSpecies addFishSpecies(FishSpecies fishSpecies);
  FishSpecies deleteFishSpeciesById(Long id);
  FishSpecies updateFishSpecies(Long id,FishSpecies fishSpecies);
}
