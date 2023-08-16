package com.api.ridechasercontrol.services;

import com.api.ridechasercontrol.models.RidechaserSpotModel;
import com.api.ridechasercontrol.repositories.RidechaserSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
}
