package com.sneakers.store.infraestructure.adapter;

import com.sneakers.store.domain.model.BrandsAndGendersResponse;
import com.sneakers.store.domain.model.SneakersResponse;
import com.sneakers.store.domain.port.SneakersPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestOperations;

@Slf4j
public class SneakerAdapter implements SneakersPort {

    private final RestOperations restTemplate;

    private static final String url="https://the-sneaker-database.p.rapidapi.com";

    public SneakerAdapter(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public SneakersResponse getAllSneakers(String url3) {
        ResponseEntity<SneakersResponse> response = null;
        try {
            response = restTemplate.exchange(url+ "/sneakers" + url3, HttpMethod.GET, new HttpEntity<>(getHttpHeaders()), SneakersResponse.class);
        }catch (Exception e){
            log.info("Error al hacer la solicitud",e);
        }
        System.out.println(response);
        return response.getBody();
    }

    @Override
    public BrandsAndGendersResponse getBrandsOrGender(String nameUrl) {
        ResponseEntity<BrandsAndGendersResponse> response = null;
        try {
            response = restTemplate.exchange(url +"/"+nameUrl, HttpMethod.GET, new HttpEntity<>(getHttpHeaders()), BrandsAndGendersResponse.class);
        }catch (Exception e){
            log.info("Error al hacer la solicitud",e);
        }
        System.out.println(response);
        return response.getBody();
    }

    private HttpHeaders getHttpHeaders(){
        final HttpHeaders headers = new HttpHeaders();
        headers.add("x-rapidapi-key","9ad085ceb5mshac62937a5bc7b0bp1a3964jsn69913b2a2704");
        headers.add("x-rapidapi-host","the-sneaker-database.p.rapidapi.com");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
