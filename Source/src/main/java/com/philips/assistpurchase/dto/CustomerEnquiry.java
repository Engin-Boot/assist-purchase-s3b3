package com.philips.assistpurchase.dto;

public class CustomerEnquiry {
	
	private String name;
	private String email ;
	private String mobile;
	private String monitorDevice;
	private String message;
	
	public CustomerEnquiry(String name, String email, String mobile, String monitorDevice, String message) {
		
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.monitorDevice = monitorDevice;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMonitorDevice() {
		return monitorDevice;
	}

	public void setMonitorDevice(String monitorDevice) {
		this.monitorDevice = monitorDevice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
