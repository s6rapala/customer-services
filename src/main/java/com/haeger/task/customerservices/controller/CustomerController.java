package com.haeger.task.customerservices.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.haeger.task.customerservices.CustomerService;
import com.haeger.task.customerservices.beans.Customer;
import com.haeger.task.customerservices.beans.Customers;
import com.haeger.task.customerservices.csv.CSVParsingService;

@RestController
public class CustomerController {
	
	private static final String CUSTOMER_URL = "/customers";
	private static final String UPLOAD = "/upload";
	private static final String RESULTS = "/results";
	
	private CSVParsingService csvParsingService;
	private CustomerService customerService;

	@Autowired
	public CustomerController(CSVParsingService csvParsingService, CustomerService customerService) {
		this.csvParsingService = csvParsingService;
		this.customerService = customerService;
	}
	
	@GetMapping(CUSTOMER_URL + UPLOAD)
	public ModelAndView showUpload(){
		return new ModelAndView("upload");
	}
	
	@PostMapping(CUSTOMER_URL + UPLOAD)
	public ModelAndView fileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
		if(file.isEmpty()){
			return new ModelAndView("status", "message", "Please select a file and try again");			
		}
		try{
			List<Customer> customerList = csvParsingService.parseStream(file.getInputStream());
			customerService.writeCustomers(customerList);
		} catch(IOException e){
			e.printStackTrace();
		}
		
		return new ModelAndView("status", "message", "File Uploaded");
	}
	
	@GetMapping(path=CUSTOMER_URL, produces=MediaType.APPLICATION_XML_VALUE)
	public Customers getCustomers() {
		Customers customers = new Customers();
		customers.setCustomerList(customerService.readCustomerData());
		return customers;
	}
	
	@GetMapping(path=CUSTOMER_URL + "/{id}", produces=MediaType.APPLICATION_XML_VALUE)
	public Customer getCustomerById(@PathVariable("id") String customerId) {
		return customerService.readCustomerData(customerId);
	}
	
	
}
 