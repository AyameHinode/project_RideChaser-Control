package com.api.ridechasercontrol.services;

import com.api.ridechasercontrol.models.RidechaserSpotModel;
import com.api.ridechasercontrol.repositories.RidechaserSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RidechaserSpotService {

    final RidechaserSpotRepository ridechaserSpotRepository;

    public RidechaserSpotService(RidechaserSpotRepository ridechaserSpotRepository){
        this.ridechaserSpotRepository = ridechaserSpotRepository;
    }

    @Transactional
    public RidechaserSpotModel save(RidechaserSpotModel ridechaserSpotModel) {
        return ridechaserSpotRepository.save(ridechaserSpotModel);
    }

    public boolean existsByIdentifier(String identifier) {
        return ridechaserSpotRepository.existsByIdentifier(identifier);
    }

    public boolean existsByRidechaserSpotNumber(String ridechaserSpotNumber) {
        return ridechaserSpotRepository.existsByRidechaserSpotNumber(ridechaserSpotNumber);
    }

    public List<RidechaserSpotModel> findAll(){
        return ridechaserSpotRepository.findAll();
    }

    public Optional<RidechaserSpotModel> findById(UUID id){
        return  ridechaserSpotRepository.findById(id);
    }

}
