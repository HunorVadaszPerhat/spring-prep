package org.springprep.classicmodelsapi.modules.customers.repository;

import org.springprep.classicmodelsapi.modules.customers.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
