package com.self.vehicleregistration.repository;

import com.self.vehicleregistration.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRegistrationRepository extends JpaRepository<Vehicle, String> {

}
