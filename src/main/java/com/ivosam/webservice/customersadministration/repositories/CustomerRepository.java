package com.ivosam.webservice.customersadministration.repositories;

import com.ivosam.webservice.customersadministration.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {
}
