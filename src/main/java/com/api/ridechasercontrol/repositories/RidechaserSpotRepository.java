package com.api.ridechasercontrol.repositories;

import com.api.ridechasercontrol.models.RidechaserSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RidechaserSpotRepository extends JpaRepository<RidechaserSpotModel, UUID> {

    boolean existsByIdentifier(String Identifier);

    boolean existsByRidechaserSpotNumber(String ridechaserSpotNumber);
}
