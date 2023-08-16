package com.api.ridechasercontrol.controller;


import com.api.ridechasercontrol.dto.RidechaserSpotDto;
import com.api.ridechasercontrol.models.RidechaserSpotModel;
import com.api.ridechasercontrol.services.RidechaserSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/ridechaser-spot")
public class RidechaserSpotController {

    final RidechaserSpotService ridechaserSpotService;

    public RidechaserSpotController(RidechaserSpotService ridechaserSpotService){
        this.ridechaserSpotService = ridechaserSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveRidechaserSpot(@RequestBody @Valid RidechaserSpotDto ridechaserSpotDto){

        if(ridechaserSpotService.existsByIdentifier(ridechaserSpotDto.getIdentifier())){
            return ResponseEntity.status(HttpStatus.CONFLICT.body("Conflict: Identifier is already in use!"))
        }

        if(ridechaserSpotService.existsByRidechaserSpotNumber(ridechaserSpotDto.getRidechaserSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT.body("Conflict: Spot is already in use!"))
        }

        var ridechaserSpotModel = new RidechaserSpotModel();
        BeanUtils.copyProperties(ridechaserSpotDto, ridechaserSpotModel);
        ridechaserSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(ridechaserSpotService.save(ridechaserSpotModel))
    } 

}
