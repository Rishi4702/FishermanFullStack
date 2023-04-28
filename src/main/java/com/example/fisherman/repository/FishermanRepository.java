package com.example.fisherman.repository;

import com.example.fisherman.model.Fisherman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FishermanRepository extends JpaRepository<Fisherman,Long> {
    List<Fisherman> findByName(String name);
}
