package com.example.webfluxdemo.service;

import com.example.webfluxdemo.core.domain.DemoData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class DemoDataService {

    public Mono<DemoData> findDemoData() {
        return Mono.just(DemoData.builder().aaa("a").bbb("b").build());
    }
}
