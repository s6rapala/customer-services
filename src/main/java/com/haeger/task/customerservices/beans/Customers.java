package com.haeger.task.customerservices.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
public class Customers {

	private List<Customer> customerList;

	public List<Customer> getCustomerList() {
		return customerList;
	}

    @XmlElement(name = "customer")
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
	
}
