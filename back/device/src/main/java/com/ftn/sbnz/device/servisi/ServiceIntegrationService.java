package com.ftn.sbnz.device.servisi;

import com.ftn.sbnz.device.izuzeci.IntegrationException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceIntegrationService {
    private static final String SERVICE_APP_URL = "http://localhost:8085/sbnz2023tim3";

    public void sendToServiceApp(Object body, String endpoint, HttpMethod method){
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.exchange(getUrl(endpoint), method, getRequest(body), ResponseEntity.class);
        } catch (HttpClientErrorException e){
            e.printStackTrace();
            throw new IntegrationException(e.getLocalizedMessage());
        }
    }

    private HttpEntity<?> getRequest(Object body){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(body, headers);
    }

    private String getUrl(String endpoint){
        return SERVICE_APP_URL + endpoint;
    }
}
