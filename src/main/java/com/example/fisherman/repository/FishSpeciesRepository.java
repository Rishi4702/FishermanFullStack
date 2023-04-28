package com.example.fisherman.repository;
import com.example.fisherman.model.FishSpecies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishSpeciesRepository extends JpaRepository<FishSpecies, Long> {
}
