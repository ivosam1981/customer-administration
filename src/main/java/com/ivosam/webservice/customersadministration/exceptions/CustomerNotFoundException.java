package com.ivosam.webservice.customersadministration.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode= FaultCode.CLIENT)
public class CustomerNotFoundException extends RuntimeException{
    public static final long serialVersionUID = 1l;

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
