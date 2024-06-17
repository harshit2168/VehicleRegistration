package com.self.vehicleregistration.service;

import com.self.vehicleregistration.model.dto.VehicleDto;
import com.self.vehicleregistration.model.dto.Vehicles;
import com.self.vehicleregistration.model.entity.Vehicle;
import com.self.vehicleregistration.model.enums.Manufacturer;
import com.self.vehicleregistration.model.mapper.VehicleMapper;
import com.self.vehicleregistration.repository.VehicleRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleRegistrationService {

    private final VehicleRegistrationRepository vehicleRegistrationRepository;

    private final VehicleMapper vehicleMapper;

    /**
     * SaveVehicles takes the Vehicle as a parameter and post it to the Database
     * @param vehicles Vehicle
     * @return List<VehicleDto>
     */
    public List<VehicleDto> saveVehicles(Vehicles vehicles) {
        var vehicleEntities = vehicles.getVehicles()
                .stream()
                .map(vehicleMapper::toEntity)
                .filter(this::filterVehicles)
                .toList();

        var savedVehicles = vehicleRegistrationRepository.saveAll(vehicleEntities);

        return savedVehicles.stream().map(vehicleMapper::toDto).toList();

    }


    /**
     * filterVehicles will take
     * @param vehicle Vehicle
     * @return boolean
     */
    private boolean filterVehicles(Vehicle vehicle) {
        return !vehicle.getManufacturer().equals(Manufacturer.VW)
        && (Objects.isNull(vehicle.getBayNumber()) || (vehicle.getBayNumber() <= 100));
    }
}
