package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="product")


public class Monitor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	private boolean isWireless ;
	private boolean isTouchscreen ;
	private boolean isInteroperable ;
	private boolean connectivitywithemr;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public Monitor() {
		
	}
	
	public Monitor(int id,String name, double price,boolean is_Wireless,boolean is_Touchscreen,boolean is_Interoperable,boolean connectivitywith_EMR ) {
	    super();
	    this.id=id;
	    this.name = name;
	    this.price = price;
	    this.isWireless= is_Wireless;
	    this.isTouchscreen=is_Touchscreen;
	    this.isInteroperable= is_Interoperable;
	    this. connectivitywithemr = connectivitywith_EMR ;
	    
	    
	  }
	

}
