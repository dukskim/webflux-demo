package com.example.webfluxdemo.api.router;

import com.example.webfluxdemo.api.handler.DemoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
@RequiredArgsConstructor
public class DemoRouter {

    private final DemoHandler demoHandler;

    @Bean
    public RouterFunction route() {
        return RouterFunctions.route()
                .GET("/api/v1/demo/data", demoHandler::demoData)
                .build();
    }
}
