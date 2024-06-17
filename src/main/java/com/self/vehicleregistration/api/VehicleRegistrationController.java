package com.self.vehicleregistration.api;

import com.self.vehicleregistration.model.dto.VehicleDto;
import com.self.vehicleregistration.model.dto.Vehicles;
import com.self.vehicleregistration.service.VehicleRegistrationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/vehicles")
@Validated
public class VehicleRegistrationController {

    private final VehicleRegistrationService vehicleRegistrationService;

    @PostMapping
    public ResponseEntity<List<VehicleDto>> saveVehicles(@Valid @RequestBody Vehicles vehicleDtoList) {
        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(vehicleRegistrationService.saveVehicles(vehicleDtoList));
    }

}
