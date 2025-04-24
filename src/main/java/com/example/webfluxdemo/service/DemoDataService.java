package com.example.webfluxdemo.service;

import com.example.webfluxdemo.core.domain.DemoData;
import com.example.webfluxdemo.repository.DemoTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class DemoDataService {

    private final DemoTestRepository demoTestRepository;

    public Mono<DemoData> findDemoData() {
        return Mono.just(DemoData.builder().aaa("a").bbb("b").build());
    }

    public Mono<DemoData> findDemoDbData() {
        return demoTestRepository.findByAaa("aaa01")
            .flatMap(demoTest -> Mono.just(DemoData.builder().aaa(demoTest.getAaa()).bbb(demoTest.getBbb()).build()))
            .switchIfEmpty(Mono.error(new Exception("No Data")));
    }
}
