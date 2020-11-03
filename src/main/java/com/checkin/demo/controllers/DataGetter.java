package com.checkin.demo.controllers;

import com.checkin.demo.entities.dto.TicketDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class DataGetter {
    private static final String URL = "http://localhost:8084";
    private static final RestTemplate restTemplate = new RestTemplate();
    private static final HttpHeaders headers = new HttpHeaders();
    private static final HttpEntity<Object> headersEntity = new HttpEntity<>(headers);
    Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    @Autowired
    public DataGetter() {
    }

    public TicketDTO getTicket(UUID idTicket) {
        ResponseEntity<String> response = restTemplate.getForEntity(URL + "/getTicket?idTicket="+idTicket, String.class);
        return  gson.fromJson(response.getBody(), TicketDTO.class);
    }


}
