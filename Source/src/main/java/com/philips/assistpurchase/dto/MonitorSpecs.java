package com.philips.assistpurchase.dto;

public class MonitorSpecs {

	private boolean isWireless ;
	private boolean isTouchscreen ;
	private boolean isInteroperable ;
	private boolean connectivitywithemr;
	
	public MonitorSpecs(boolean isWireless, boolean isTouchscreen, boolean isInteroperable, boolean connectivitywithemr) {
		
		this.isWireless = isWireless;
		this.isTouchscreen = isTouchscreen;
		this.isInteroperable = isInteroperable;
		this.connectivitywithemr = connectivitywithemr;
	}

	public boolean isWireless() {
		return isWireless;
	}

	public void setWireless(boolean isWireless) {
		this.isWireless = isWireless;
	}

	public boolean isTouchscreen() {
		return isTouchscreen;
	}

	public void setTouchscreen(boolean isTouchscreen) {
		this.isTouchscreen = isTouchscreen;
	}

	public boolean isInteroperable() {
		return isInteroperable;
	}

	public void setInteroperable(boolean isInteroperable) {
		this.isInteroperable = isInteroperable;
	}

	public boolean isConnectivitywithemr() {
		return connectivitywithemr;
	}

	public void setConnectivitywithemr(boolean connectivitywithemr) {
		this.connectivitywithemr = connectivitywithemr;
	}
	
}
