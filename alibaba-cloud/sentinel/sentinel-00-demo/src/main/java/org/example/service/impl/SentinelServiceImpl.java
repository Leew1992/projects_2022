package org.example.service.impl;

import org.example.service.SentinelService;
import org.springframework.stereotype.Service;

@Service
public class SentinelServiceImpl implements SentinelService {

    @Override
    public String test(Integer id) {
        return "test: " + id;
    }
}
