package com.tasif.mongodbpratice.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "vehicle")
@Data
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String vehicleId;

	private String vehicleName;

	private String vehicleType;

	private String vehicleBrand;

}
