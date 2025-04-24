package com.example.webfluxdemo.api.handler;

import com.example.webfluxdemo.core.dto.response.SingleResponse;
import com.example.webfluxdemo.service.DemoDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        return  ServerResponse.ok().body(demoDataService.findDemoData(), SingleResponse.class);
    }

    public Mono<ServerResponse> demoDbData(ServerRequest request) {
        return  ServerResponse.ok().body(demoDataService.findDemoDbData(), SingleResponse.class);
    }
}
