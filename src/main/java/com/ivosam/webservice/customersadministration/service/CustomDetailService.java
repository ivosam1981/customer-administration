package com.ivosam.webservice.customersadministration.service;

import com.ivosam.webservice.customersadministration.bean.Customer;
import com.ivosam.webservice.customersadministration.enums.Status;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomDetailService {

    private static List<Customer> customers = new ArrayList<>();

    static {
        Customer customer1 = new Customer(1, "Joao", "999999999", "joao@gmail.com");
        customers.add(customer1);

        Customer customer2 = new Customer(2, "Maria", "999999998", "maria@gmail.com");
        customers.add(customer2);

        Customer customer3 = new Customer(3, "Jose", "999999997", "jose@gmail.com");
        customers.add(customer3);

        Customer customer4 = new Customer(4, "Marieta", "999999996", "marieta@gmail.com");
        customers.add(customer4);
    }

    public Customer findById(Integer id) {
        Optional<Customer> customerOptional = customers.stream().filter(c -> c.getId() == id).findAny();
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        }
        return null;
    }

    public List<Customer> findAll(){
        return customers;
    }

    public Status deleteById(Integer id){
       Optional<Customer> customerOptional =  customers.stream().filter(c-> c.getId() == id).findAny();
        if(customerOptional.isPresent()){
            customers.remove(customerOptional.get());
            return Status.SUCCESS;
        }
        return Status.FAILURE;
    }
}
