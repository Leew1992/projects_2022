package org.example.service;

public interface RibbonService {

    String get();

    String sleep(Integer time);

    String breaker(Integer id);
}
