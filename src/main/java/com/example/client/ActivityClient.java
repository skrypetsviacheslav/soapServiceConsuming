package com.example.client;

import com.example.consumingwebservice.wsdl.DeleteActivityRequest;
import com.example.consumingwebservice.wsdl.DeleteActivityResponse;
import com.example.consumingwebservice.wsdl.GetActivityRequest;
import com.example.consumingwebservice.wsdl.GetActivityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class ActivityClient extends WebServiceGatewaySupport {

    public GetActivityResponse getActivity(int id) {
        GetActivityRequest request = new GetActivityRequest();
        request.setId(id);

        GetActivityResponse response = (GetActivityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/activities", request
                        , new SoapActionCallback("http://soapservice.activity"));

        return response;
    }

    public DeleteActivityResponse deleteActivity(int id) {
        DeleteActivityRequest request = new DeleteActivityRequest();
        request.setId(id);

        DeleteActivityResponse response = (DeleteActivityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/activities", request
                        , new SoapActionCallback("http://soapservice.activity"));

        return response;
    }
}
