package com.tasif.mongodbpratice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasif.mongodbpratice.dto.VehicleDto;
import com.tasif.mongodbpratice.model.Vehicle;
import com.tasif.mongodbpratice.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping
	public ResponseEntity<String> addVehicle(@RequestBody VehicleDto vehicleDto) {
		String response = vehicleService.addVehicle(vehicleDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PutMapping("/{vehicleId}")
	public ResponseEntity<String> updateVehicle(@PathVariable("vehicleId") String vehicleId,
			@RequestBody VehicleDto vehicleDto) {
		String response = vehicleService.updateVehicle(vehicleId, vehicleDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> allVehicles = vehicleService.getAllVehicle();
		return allVehicles;
	}

	@DeleteMapping("/{vehicleId}")
	public ResponseEntity<String> deleteVehicle(@PathVariable("vehicleId") String vehicleId) {
		String response = vehicleService.deleteVehicle(vehicleId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("/{vehicleId}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("vehicleId") String vehicleId) {
		Vehicle response = vehicleService.getVehicle(vehicleId);
		return new ResponseEntity<Vehicle>(response, HttpStatus.OK);
	}
}