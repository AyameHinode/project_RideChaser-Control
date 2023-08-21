package com.api.ridechasercontrol.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TB_RIDECHASER_SPOT")
public class RidechaserSpotModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String ridechaserSpotNumber;

    @Column(nullable = false, unique = true, length = 7)
    private String identifier;

    @Column(nullable = false, length = 70)
    private String ridechaserModel;

    @Column(nullable = false, length = 70)
    private String color;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String sector;

    @Column(nullable = false, length = 200)
    private String authorization;

}
