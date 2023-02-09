package com.example.redisdemo.controller;

import com.example.redisdemo.service.RedisCacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisCacheController {
    int sayac = 0;

    private final RedisCacheService redisCacheService;

    public RedisCacheController(RedisCacheService redisCacheService) {
        this.redisCacheService = redisCacheService;
    }

    @GetMapping("/control")
    public String cacheControl() throws InterruptedException {
        if(sayac == 5){
            redisCacheService.clearCache();
            sayac = 0;
        }
        sayac++;
        return redisCacheService.longRunningMethod();
    }
}
