package com.haeger.task.customerservices.csv;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.stereotype.Service;

import com.haeger.task.customerservices.beans.Customer;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

@Service
public class CSVParsingService {
	
	public List<Customer> parseStream(InputStream in){
		
		HeaderColumnNameMappingStrategy<Customer> ms = new HeaderColumnNameMappingStrategy<>();
		ms.setType(Customer.class);
		
		Reader reader = new InputStreamReader(in);
		// To serialize eight column csv
		CsvToBean<Customer> cb = new CsvToBeanBuilder<Customer>(reader)
			       .withType(Customer.class)
			       .withMappingStrategy(ms)
			       .build();
		List<Customer> customerList = cb.parse();
		return customerList;
	}

}
