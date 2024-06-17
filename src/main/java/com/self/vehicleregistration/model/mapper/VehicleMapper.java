package com.self.vehicleregistration.model.mapper;

import com.self.vehicleregistration.model.dto.VehicleDto;
import com.self.vehicleregistration.model.entity.Vehicle;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @Mapping(source = "vehicleDto.vin", target = "vin")
    @Mapping(source = "vehicleDto.manufacturer", target = "manufacturer")
    @Mapping(source = "vehicleDto.bayNumber", target = "bayNumber")
    Vehicle toEntity(VehicleDto vehicleDto);

    @Mapping(source = "vehicle.vin", target = "vin")
    @Mapping(source = "vehicle.manufacturer", target = "manufacturer")
    @Mapping(source = "vehicle.bayNumber", target = "bayNumber")
    VehicleDto toDto(Vehicle vehicle);

    @BeforeMapping
    default void convertToUpperCase(@MappingTarget Vehicle vehicle, VehicleDto vehicleDto){
    vehicleDto.setManufacturer(vehicleDto.getManufacturer().toUpperCase());
    }

}
