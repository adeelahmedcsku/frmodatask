package com.frmoda.demo.service;


import com.frmoda.demo.model.ResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalService {

    @Value( "${cloud.api}" )
    private String api;
    public ResponseDto getDataRemoteService()
    {
        RestTemplate restTemplate =new RestTemplate();
       return restTemplate.getForObject(api,ResponseDto.class);
    }
}
