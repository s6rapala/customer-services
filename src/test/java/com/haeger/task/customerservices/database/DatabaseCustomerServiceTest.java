package com.haeger.task.customerservices.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.haeger.task.customerservices.beans.Customer;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseCustomerServiceTest {

	@Mock
	private CustomerRepository customerRepository;
	
	@InjectMocks
	private DatabaseCustomerService databaseCustomerService;
	
	@Test
	public void whenDatabaseReturnsResultsThenConvertResults() {
		List<ProxyCustomer> proxyList = getProxyList();
		Mockito.when(customerRepository.findAll()).thenReturn(proxyList);
		List<Customer> customerList = databaseCustomerService.readCustomerData();
		
		assertEquals(1, customerList.size());
		assertEquals("mock", customerList.get(0).getId());
	}
	
	private List<ProxyCustomer> getProxyList() {
		List<ProxyCustomer> proxyList = new ArrayList<ProxyCustomer>();
		ProxyCustomer customer = new ProxyCustomer();
		customer.setId("mock");
		proxyList.add(customer);
		return proxyList;
	}
}
