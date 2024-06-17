package com.self.vehicleregistration.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @NotBlank(message = "Manufacturer cannot be blank")
    private String manufacturer;

    @JsonProperty("bay_number")
    private Integer bayNumber;

}
