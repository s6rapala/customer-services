package com.haeger.task.customerservices.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haeger.task.customerservices.CustomerService;
import com.haeger.task.customerservices.beans.Customer;

@Service
public class DatabaseCustomerService implements CustomerService {

	/*
	 * When spring creates an instance of DatabaseCustomerService, it is going to inject an 
	instance of CustomerRepository to it. 
	 */
	private CustomerRepository customerRepository;

	//Spring looks for and injects CustomerRepository when DatabaseCustomerService is created.
	@Autowired
	public DatabaseCustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	//writing entities in to an in-memory database
	@Override
	public void writeCustomers(List<Customer> customerList) {
		List<ProxyCustomer> proxyCustomerList = new ArrayList<>();
		for (Customer customer : customerList) {
			if (customer.getId() == null || customer.getId().isEmpty()) {
				continue;
			}
			ProxyCustomer proxy = new ProxyCustomer();
			proxy.setContactedDate(customer.getContactedDate());
			proxy.setEndTime(customer.getEndTime());
			proxy.setFee(customer.getFee());
			proxy.setFirstName(customer.getFirstName());
			proxy.setFromTime(customer.getFromTime());
			proxy.setId(customer.getId());
			proxy.setLastName(customer.getLastName());
			proxy.setOrganization(customer.getOrganization());
			proxyCustomerList.add(proxy);
		}
		customerRepository.saveAll(proxyCustomerList);
	}

	// Use case: 1 Reading all customers from the repository
	@Override
	public List<Customer> readCustomerData() {
		// Connect to the database and run query to get all the Customer records.
		List<ProxyCustomer> proxyList = customerRepository.findAll();
		
		List<Customer> customerList = new ArrayList<>();
		for (ProxyCustomer proxyCustomer : proxyList) {
			Customer customer = new Customer();
			customer.setContactedDate(proxyCustomer.getContactedDate());
			customer.setEndTime(proxyCustomer.getEndTime());
			customer.setFee(proxyCustomer.getFee());
			customer.setFirstName(proxyCustomer.getFirstName());
			customer.setFromTime(proxyCustomer.getFromTime());
			customer.setId(proxyCustomer.getId());
			customer.setLastName(proxyCustomer.getLastName());
			customer.setOrganization(proxyCustomer.getOrganization());
			customerList.add(customer);
		}
		return customerList;
	}
	//Use Case 2: Reading customer data using customerId
	@Override
	public Customer readCustomerData(String customerId) {
		List<ProxyCustomer> proxyCustomerList = customerRepository.findCustomerDistinctById(customerId);
		ProxyCustomer proxyCustomer = proxyCustomerList == null || proxyCustomerList.isEmpty() ? null
				: proxyCustomerList.get(0);
		if (proxyCustomer != null) {
			Customer customer = new Customer();
			customer.setContactedDate(proxyCustomer.getContactedDate());
			customer.setEndTime(proxyCustomer.getEndTime());
			customer.setFee(proxyCustomer.getFee());
			customer.setFirstName(proxyCustomer.getFirstName());
			customer.setFromTime(proxyCustomer.getFromTime());
			customer.setId(proxyCustomer.getId());
			customer.setLastName(proxyCustomer.getLastName());
			customer.setOrganization(proxyCustomer.getOrganization());
			return customer;

		} else {
			return null;
		}
	}

}
