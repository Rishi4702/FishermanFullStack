package com.example.fisherman.service;

import com.example.fisherman.model.FishSpecies;
import com.example.fisherman.repository.FishSpeciesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FishSpeciesServiceImpl implements FishSpeciesService{
    @Autowired
    private FishSpeciesRepository fr;
    @Override
    public FishSpecies getFishSpeciesById(Long id) {
//        return fr.findById(id).get();
        Optional<FishSpecies> fs =fr.findById(id);
        if(fs.isPresent()){
            return fs.get();
        }
        return null;
    }

    @Override
    public List<FishSpecies> getAllFishSpecies() {
        return fr.findAll();
    }

    @Override
    public FishSpecies addFishSpecies(FishSpecies fishSpecies) {
        return fr.save(fishSpecies);
    }

    @Override
    public FishSpecies deleteFishSpeciesById(Long id) {
        Optional<FishSpecies> fs =fr.findById(id);
        if(fs.isPresent()){
            fr.deleteById(id);
            System.out.println("deleted"+id);
            return fs.get();
        }
        System.out.println("null");
       return null;
    }

    @Override
    public FishSpecies updateFishSpecies(Long id,FishSpecies fishSpecies) {
        Optional<FishSpecies> c = fr.findById(id);
        if (!c.isPresent()) {
            System.out.println("value was not present");
            return null;
        }else{
            System.out.println(c.get().toString());
        }
        FishSpecies personToUpdate = c.get();
        if (fishSpecies.getName() != null) {
            personToUpdate.setName(fishSpecies.getName());
        }
        if (fishSpecies.getDescription() != null) {
            personToUpdate.setDescription(fishSpecies.getDescription());
        }
        personToUpdate.setProtected(fishSpecies.isProtected());

        return fr.save(personToUpdate);
    }
}
