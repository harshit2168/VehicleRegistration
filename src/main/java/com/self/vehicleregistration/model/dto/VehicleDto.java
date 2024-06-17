package com.self.vehicleregistration.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.self.vehicleregistration.model.enums.Manufacturer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDto {

    @NotBlank(message = "VIN cannot be blank")
    @JsonProperty(value = "VIN")
    private String vin;

    @JsonProperty
    @NotNull(message = "Manufacturer cannot be blank")
    private Manufacturer manufacturer;

    @JsonProperty("bay_number")
    private Integer bayNumber;

}
