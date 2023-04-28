package com.example.fisherman.service;
import com.example.fisherman.DTO.FishermanDTO;
import com.example.fisherman.model.Fisherman;
import com.example.fisherman.repository.FishermanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FishermanServiceImpl implements FishermanService{
    @Autowired
    private FishermanRepository fr;
    @Override
    public void addFisherman(Fisherman fisherman) {
        fr.save(fisherman);
    }

    @Override
    public Fisherman deleteFishermanById(long id) {
        Optional<Fisherman> c = fr.findById(id);
        c.ifPresent(course -> fr.deleteById(id));
        return c.get();
    }

    @Override
    public Fisherman updateFisherman(Fisherman fisherman,Long id) {
        Optional<Fisherman> c = fr.findById(id);
        if (!c.isPresent()) {
            System.out.println("value was not present");
            return null;
        }else{
            System.out.println(c.get().toString());
        }
        Fisherman personToUpdate = c.get();
        if (fisherman.getName() != null) {
            personToUpdate.setName(fisherman.getName());
        }
        if (fisherman.getAge() != 0) {
            personToUpdate.setAge(fisherman.getAge());
        }
        if (fisherman.getPassword() != null) {
            personToUpdate.setPassword(fisherman.getPassword());
        }
        if (fisherman.getEmail() != null) {
            personToUpdate.setEmail(fisherman.getEmail());
        }
        if (fisherman.getPhone() != null) {
            personToUpdate.setPhone(fisherman.getPhone());
        }
        Fisherman up = fr.save(personToUpdate);
        return up;
    }

    @Override
    public List<FishermanDTO> findFishermenByName(String name) {
//        List<ModelCatchDTO> s = modelCatchRepository.findAll().stream().map(model -> model.toDTO()).collect(Collectors.toList());
        return fr.findByName(name).stream().map(a->a.toDTO(a)).collect(Collectors.toList());
    }
}
