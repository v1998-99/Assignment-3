package com.consume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ApiController {

    private ServiceApi serviceApi;
    @Autowired
    public ApiController(ServiceApi serviceApi){
        this.serviceApi=serviceApi;
    }
    @GetMapping("/callapi")
    public Mono<OuterStatus> savecallApi(){
        return serviceApi.callApi();

    }
}
