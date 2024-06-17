package com.self.vehicleregistration.model.entity;

import com.self.vehicleregistration.model.enums.Manufacturer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "VEHICLE")
@Getter
@Setter
public class Vehicle {

    @Id
    @Column(name = "vin")
    private String vin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "manufacturer")
    private Manufacturer manufacturer;

    @Column(name = "bay_number")
    private Integer bayNumber;
}
