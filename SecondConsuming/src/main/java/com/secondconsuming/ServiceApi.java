package com.secondconsuming;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceApi {
    private WebClient webClient;
    private DataRepository dataRepository;

    @Autowired
    public ServiceApi(WebClient webClient, DataRepository dataRepository) {
        this.webClient = webClient;
        this.dataRepository = dataRepository;
    }

    public Mono<OuterStatus> callApi() {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("api/v1/employees").build())
                .retrieve()
                .bodyToMono(OuterStatus.class)
                .map(outerStatus -> {
                   List<Value> updatedEmployeeDataList = outerStatus.getData().stream().
                    map(
                            value -> {
                                if(value.getEmployee_salary() > 100000) {
                                    value.setEligibleForLoan(true);
                                }
                                return value;
                            }
                    ).

                      collect(Collectors.toList());

                    outerStatus.setData(updatedEmployeeDataList);

                    return outerStatus;
                });
//                .flatMap(outerStatus ->
//                        dataRepository
//                                .saveAll(
//                                        outerStatus
//                                                .getData()
//                                                .stream()
//                                                .map(Employee::from).collect(Collectors.toList()))
//                                .then(Mono.just(outerStatus))
//                );




//        return webClient
//                .get()
//                .uri("/api/v1/employees")
//                .retrieve()
//                .bodyToMono(OuterStatus.class)
//                .flatMap(outerStatusList->outerStatusList.stream().map(outerStatus -> dataRepository.save(outerStatus.getData()));
//
//



//        Mono<List<OuterStatus>> response = webClient.get().uri("/api/v1/employees")
//                .accept(MediaType.APPLICATION_JSON)
//                .retrieve()
//                .bodyToMono(new ParameterizedTypeReference<List<OuterStatus>>() {});
//        List<OuterStatus> outerStatus = response.block();
//
//        return outerStatus.stream()
//                .map(OuterStatus:getData());
//                .collect(Collectors.toList());







    }
}