package com.ilp04.entity;

public class Customer {
	
	private int customerCode;
	private String customerFirstName;
	private String customerLastName;
	private String address;
	private long phnNumber;
	private long aadharNo;
	
	public Customer(int customerCode, String customerFirstName, String customerLastName, String address, long phnNumber,
			long aadharNo) {
		super();
		this.customerCode = customerCode;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.address = address;
		this.phnNumber = phnNumber;
		this.aadharNo = aadharNo;
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhnNumber() {
		return phnNumber;
	}
	public void setPhnNumber(long phnNumber) {
		this.phnNumber = phnNumber;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	
}
