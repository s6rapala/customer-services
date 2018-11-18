package com.haeger.task.customerservices.beans;

import javax.xml.bind.annotation.XmlRootElement;

import com.opencsv.bean.CsvBindByName;

@XmlRootElement(name="customer")
public class Customer {

	@CsvBindByName(column="V-Id")
	private String id;
	@CsvBindByName(column="FirstName")
	private String firstName;
	@CsvBindByName(column="LastName")
	private String lastName;
	@CsvBindByName(column="Organization")
	private String organization;
	@CsvBindByName(column="ContactedDate")
	private String contactedDate;
	@CsvBindByName(column="FromTime")
	private String fromTime;
	@CsvBindByName(column="EndTime")
	private String endTime;
	@CsvBindByName(column="Fee")
	private String fee;
	public Customer() {
		
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
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", organization="
				+ organization + ", contactedDate=" + contactedDate + ", fromTime=" + fromTime + ", endTime=" + endTime
				+ ", fee=" + fee + "]";
	}
}