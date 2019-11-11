package com.satish.wm.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "customer")
public class Customers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1203413598854967813L;
	@Id
	private String customerId;
	private String fname;
	private String lname;
	private String address;
	private String city;
	private String shopName;
	private String mobile;
	public Customers() {
		super();

	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	
	
}
