package com.ivosam.webservice.customersadministration.service;

import com.ivosam.webservice.customersadministration.bean.Customer;
import com.ivosam.webservice.customersadministration.enums.Status;
import com.ivosam.webservice.customersadministration.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomDetailService {

    private static List<Customer> customers = new ArrayList<>();

    @Autowired
    private CustomerRepository customerRepository;


    public Customer findById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }
        return null;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Status deleteById(Integer id) {
        try {
            customerRepository.deleteById(id);
            return Status.SUCCESS;
        } catch (Exception e) {
            return Status.FAILURE;
        }
    }

    public Status insert(Customer customer) {
        try {
            customerRepository.save(customer);
            return Status.SUCCESS;
        } catch (Exception e) {
            return Status.FAILURE;
        }
    }
}
