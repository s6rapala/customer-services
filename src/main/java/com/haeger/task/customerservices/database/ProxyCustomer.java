package com.haeger.task.customerservices.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Customer")
public class ProxyCustomer {
	
	@Id
	@GeneratedValue
	private Long key;
	
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String organization;
	
	private String contactedDate;
	
	private String fromTime;
	
	private String endTime;
	
	private String fee;
	
	public ProxyCustomer() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getContactedDate() {
		return contactedDate;
	}
	public void setContactedDate(String contactedDate) {
		this.contactedDate = contactedDate;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}

}
