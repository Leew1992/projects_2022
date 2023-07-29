package org.example.service;

public interface HystrixService {

    String sleep(Integer time);

    String breaker(Integer id);
}
