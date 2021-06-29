package com.argenta.demo.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class InformationBoardService {

    private Random random = new Random();

    @SuppressWarnings("WeakerAccess")
    public boolean hasFreeLot() {
        return random.nextBoolean();
    }

}
