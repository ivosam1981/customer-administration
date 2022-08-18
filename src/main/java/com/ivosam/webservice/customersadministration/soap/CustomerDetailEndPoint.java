package com.ivosam.webservice.customersadministration.soap;

import br.com.ivosam.CustomerDetail;
import br.com.ivosam.GetCustomerDetailRequest;
import br.com.ivosam.GetCustomerDetailResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CustomerDetailEndPoint {

    @PayloadRoot(namespace = "http://ivosam.com.br", localPart = "GetCustomerDetailRequest")
    @ResponsePayload
    public GetCustomerDetailResponse processCustomerDetailRequest(@RequestPayload GetCustomerDetailRequest req){
        GetCustomerDetailResponse response = new GetCustomerDetailResponse();
        CustomerDetail customerDetail= new CustomerDetail();

        customerDetail.setId(1);
        customerDetail.setName("Joao");
        customerDetail.setPhone("999999999");
        customerDetail.setEmail("joaoa@gmail.com");
        response.setCustomerDetail(customerDetail);
        return response;
    }
}
