package com.self.vehicleregistration.service;


import com.self.vehicleregistration.model.dto.VehicleDto;
import com.self.vehicleregistration.model.dto.Vehicles;
import com.self.vehicleregistration.model.entity.Vehicle;
import com.self.vehicleregistration.model.enums.Manufacturer;
import com.self.vehicleregistration.model.mapper.VehicleMapper;
import com.self.vehicleregistration.repository.VehicleRegistrationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class VehicleRegistrationServiceTest {

 @Mock
 private VehicleRegistrationRepository vehicleRegistrationRepository;

 @Mock
 private VehicleMapper vehicleMapper;

 @InjectMocks
 private VehicleRegistrationService vehicleRegistrationService;

 @Test
 void testSaveVehicles() {
  var vehicle = new Vehicle();
  vehicle.setBayNumber(1);
  vehicle.setManufacturer(Manufacturer.FORD);
  vehicle.setVin("12");
  var vehicleEntities = List.of(vehicle);

  var vehicleDto = new VehicleDto();
  vehicleDto.setVin("12");
  vehicleDto.setManufacturer(Manufacturer.FORD.name());
  vehicleDto.setBayNumber(1);

  var vehicles = new Vehicles();
  vehicles.setVehicles(List.of(vehicleDto));
  Mockito.when(vehicleMapper.toEntity(Mockito.any())).thenReturn(vehicle);
  Mockito.when(vehicleRegistrationRepository.saveAll(vehicleEntities)).thenReturn(vehicleEntities);
  Mockito.when(vehicleMapper.toDto(vehicle)).thenReturn(vehicleDto);

  var response = vehicleRegistrationService.saveVehicles(vehicles);

  Assertions.assertEquals(response, vehicles.getVehicles());
 }
}
