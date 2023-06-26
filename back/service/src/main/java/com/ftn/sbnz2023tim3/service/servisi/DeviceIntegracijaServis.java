package com.ftn.sbnz2023tim3.service.servisi;

import com.ftn.sbnz2023tim3.model.modeli.dto.TextResponse;
import com.ftn.sbnz2023tim3.service.izuzeci.IntegrationException;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class DeviceIntegracijaServis {

    private static final String DEVICE_APP_URL = "http://localhost:8086";

    public void sendToDeviceApp(Object body, String endpoint, HttpMethod method) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.exchange(getUrl(endpoint), method, getRequest(body), TextResponse.class);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            throw new IntegrationException(e.getLocalizedMessage());
        }
    }

    private HttpEntity<?> getRequest(Object body) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(body, headers);
    }

    private String getUrl(String endpoint) {
        return DEVICE_APP_URL + endpoint;
    }

}
