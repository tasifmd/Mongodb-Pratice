package com.tasif.mongodbpratice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasif.mongodbpratice.dto.VehicleDto;
import com.tasif.mongodbpratice.model.Vehicle;
import com.tasif.mongodbpratice.repository.VehicleRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private ModelMapper modelMapper;

	public String addVehicle(VehicleDto vehicleDto) {
		Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
		vehicleRepository.save(vehicle);
		return "Vehicle added successfully";
	}

	public String updateVehicle(String vehicleId, VehicleDto vehicleDto) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
		vehicle.setVehicleName(vehicleDto.getVehicleName());
		vehicle.setVehicleType(vehicleDto.getVehicleType());
		vehicle.setVehicleBrand(vehicleDto.getVehicleBrand());
		vehicleRepository.save(vehicle);
		return "Vehicle Updated successfully";
	}

	public List<Vehicle> getAllVehicle() {
		List<Vehicle> allVehicles = vehicleRepository.findAll();
		return allVehicles;
	}

	public String deleteVehicle(String vehicleId) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
		vehicleRepository.delete(vehicle);
		return "Vehicle deleted successfully";
	}

	public Vehicle getVehicle(String vehicleId) {
		Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
		return vehicle;
	}

}
