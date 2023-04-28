package com.example.fisherman.service;

import com.example.fisherman.model.ModelCatch;
import com.example.fisherman.repository.ModelCatchRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ModelCatchServiceImpl implements ModelCatchService{
@Autowired
    private ModelCatchRepository modelCatchRepository;

    @Override
    public void addModelCatch(ModelCatch modelCatch) {
        modelCatchRepository.save(modelCatch);
    }
}
