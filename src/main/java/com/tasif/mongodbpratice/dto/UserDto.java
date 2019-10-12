package com.tasif.mongodbpratice.dto;

public class UserDto {

	private String userName;

	private String userEmail;

	private String mobileNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", userEmail=" + userEmail + ", mobileNumber=" + mobileNumber + "]";
	}
}
