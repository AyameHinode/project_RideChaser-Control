package com.api.ridechasercontrol.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RidechaserSpotDto {

    @NotBlank
    private String ridechaserSpotNumber;

    @NotBlank
    @Size(max=7)
    private String identifier;

    @NotBlank
    private String ridechaserModel;

    @NotBlank
    private String color;

    @NotBlank
    private String responsibleName;

    @NotBlank
    private String sector;


}
