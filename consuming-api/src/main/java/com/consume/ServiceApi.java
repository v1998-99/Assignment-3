package com.consume;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceApi {

    //private final ObjectMapper mapper = new ObjectMapper();
    private WebClient webClient;
    private DataRepository dataRepository;
    @Autowired
    public ServiceApi(WebClient webClient,DataRepository dataRepository){
        super();
        this.webClient=webClient;
        this.dataRepository=dataRepository;
    }
    public Mono<OuterStatus> callApi(){


        return webClient
                .get()
                .uri("/api/v1/employee/1")
                .retrieve()
                .bodyToMono(OuterStatus.class)
                .flatMap(outerStatus->dataRepository.save(outerStatus.getData()).then(Mono.just(outerStatus)));



//
//        OuterStatus outerStatus = webClientBuilder.build()
//                .get()
//                .uri("api/v1/employee/1")
//                .retrieve()
//                .bodyToMono(OuterStatus.class)
//                .block();
//
//        Value value= outerStatus.getData();
//        dataRepository.save(value);
//    return outerStatus;
    }
}
