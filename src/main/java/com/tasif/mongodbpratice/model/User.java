package com.tasif.mongodbpratice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "user")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String userId;

	private String userName;

	private String userEmail;

	private String mobileNumber;

	@DBRef
	private List<Vehicle> vehicles=new ArrayList<>();

}
