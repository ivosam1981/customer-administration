package com.ivosam.webservice.customersadministration.soap;

import br.com.ivosam.*;
import com.ivosam.webservice.customersadministration.bean.Customer;
import com.ivosam.webservice.customersadministration.exceptions.CustomerNotFoundException;
import com.ivosam.webservice.customersadministration.service.CustomDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CustomerDetailEndPoint {

    @Autowired
    CustomDetailService service;

    @PayloadRoot(namespace = "http://ivosam.com.br", localPart = "GetCustomerDetailRequest")
    @ResponsePayload
    public GetCustomerDetailResponse processCustomerDetailRequest(@RequestPayload GetCustomerDetailRequest req) throws Exception {
        Customer customer = service.findById(req.getId());
        if (customer == null) {
            throw new CustomerNotFoundException("Invalid Customer id " + req.getId());
        }
        return convertToGetCustomerDetailResponse(customer);
    }

    private GetCustomerDetailResponse convertToGetCustomerDetailResponse(Customer customer) {
        GetCustomerDetailResponse resp = new GetCustomerDetailResponse();
        resp.setCustomerDetail(convertToCustomerDetail(customer));
        return resp;
    }

    private CustomerDetail convertToCustomerDetail(Customer customer) {
        CustomerDetail customerDetail = new CustomerDetail();
        customerDetail.setId(customer.getId());
        customerDetail.setEmail(customer.getEmail());
        customerDetail.setPhone(customer.getPhone());
        customerDetail.setName(customer.getName());
        return customerDetail;

    }

    @PayloadRoot(namespace = "http://ivosam.com.br", localPart = "GetAllCustomerDetailRequest")
    @ResponsePayload
    public GetAllCustomerDetailResponse processCustomerDetailRequest(@RequestPayload GetAllCustomerDetailRequest req) {
        List<Customer> customers = service.findAll();
        return convertToGetAllCustomerDetailResponse(customers);

    }

    private GetAllCustomerDetailResponse convertToGetAllCustomerDetailResponse(List<Customer> customers){
        GetAllCustomerDetailResponse resp = new GetAllCustomerDetailResponse();
        customers.stream().forEach(c-> resp.getCustomerDetail().add(convertToCustomerDetail(c)));
        return resp;
    }


    @PayloadRoot(namespace = "http://ivosam.com.br", localPart = "DeleteCustomerRequest")
    @ResponsePayload
    public DeleteCustomerResponse deleteCustomerRequest(@RequestPayload DeleteCustomerRequest req){
        DeleteCustomerResponse response = new DeleteCustomerResponse();
        response.setStatus(convertStatusSoap(service.deleteById(req.getId())));
        return response;

    }


    private br.com.ivosam.Status convertStatusSoap(
            com.ivosam.webservice.customersadministration.enums.Status statusService){
        if(statusService == com.ivosam.webservice.customersadministration.enums.Status.FAILURE){
            return br.com.ivosam.Status.FAILURE;
        }
        return br.com.ivosam.Status.SUCCESS;
    }
}
