package com.haeger.task.customerservices;
import java.util.List;

import com.haeger.task.customerservices.beans.Customer;

public interface CustomerService {

	void writeCustomers(List<Customer> customerList);
	
	List<Customer> readCustomerData();
	
	Customer readCustomerData(String customerId);
}
