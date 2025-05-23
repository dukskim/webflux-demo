package com.example.webfluxdemo.repository;

import com.example.webfluxdemo.entity.DemoTest;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface DemoTestRepository extends R2dbcRepository<DemoTest, String > {

    Mono<DemoTest> findByAaa(String aaa);
}
