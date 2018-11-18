package com.haeger.task.customerservices.database;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<ProxyCustomer, Long> {
	  List<ProxyCustomer> findCustomerDistinctById(String id);
}
