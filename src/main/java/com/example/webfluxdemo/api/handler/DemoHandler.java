package com.example.webfluxdemo.api.handler;

import com.example.webfluxdemo.core.dto.request.DemoDataRequest;
import com.example.webfluxdemo.core.dto.response.SingleResponse;
import com.example.webfluxdemo.service.DemoDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class DemoHandler {

    private final DemoDataService demoDataService;

    public Mono<ServerResponse> demoData(ServerRequest request) {
        return ServerResponse.ok().body(demoDataService.findDemoData(), SingleResponse.class);
    }

    public Mono<ServerResponse> demoDbData(ServerRequest request) {
        return request.bodyToMono(DemoDataRequest.class)
                .flatMap(demoDataRequest -> ServerResponse.ok().body(demoDataService.findDemoDbData(demoDataRequest.getAaa()), SingleResponse.class))
                .switchIfEmpty(ServerResponse.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).build());
    }
}
