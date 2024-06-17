package com.self.vehicleregistration.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Vehicles {

    @NotNull(message = "List of vehicles cannot be null")
    @Valid
    private List<VehicleDto> vehicles;
}
