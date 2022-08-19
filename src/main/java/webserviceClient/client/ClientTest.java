package webserviceClient.client;


import webserviceClient.CustomerPort;
import webserviceClient.CustomerPortService;
import webserviceClient.GetCustomerDetailRequest;
import webserviceClient.GetCustomerDetailResponse;

public class ClientTest {

    public static void main(String[] args){
        CustomerPortService service = new CustomerPortService();

        HeaderHandlerResolve handlerResolver = new HeaderHandlerResolve();
        service.setHandlerResolver(handlerResolver);

        CustomerPort port = service.getCustomerPortSoap11();

        GetCustomerDetailRequest customerDetailRequest = new GetCustomerDetailRequest();
        customerDetailRequest.setId(3);

        GetCustomerDetailResponse customerDetailResponse = port.getCustomerDetail(customerDetailRequest);

        System.out.println("id -> " + customerDetailResponse.getCustomerDetail().getId());
        System.out.println("nome -> " + customerDetailResponse.getCustomerDetail().getName());
        System.out.println("email -> " + customerDetailResponse.getCustomerDetail().getEmail());
        System.out.println("phone -> " + customerDetailResponse.getCustomerDetail().getPhone());
    }


}
