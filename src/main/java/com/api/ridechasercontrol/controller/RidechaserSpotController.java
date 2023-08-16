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
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<RidechaserSpotModel>> getAllRidechaserSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(ridechaserSpotService.findAll());
    }

    @GetMapping
    public ResponseEntity<Object> getOneRidechaserSpot(@PathVariable(value = "id") UUID id){
        Optional<RidechaserSpotModel> ridechaserSpotModelOptional = ridechaserSpotService.findById(id);
        if(ridechaserSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ridechaser Spot not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ridechaserSpotModelOptional.get()); 
    }

}
