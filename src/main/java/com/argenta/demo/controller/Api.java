package com.argenta.demo.controller;

import com.argenta.demo.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Api {

    private GateService gateService;

    @Autowired
    public Api (GateService gateService) {
        this.gateService = gateService;
    }

    @GetMapping(value = "/enterGateIsOpen")
    public ResponseEntity enterGateIsOpen() {
        return ResponseEntity.ok(gateService.canEnter());
    }

    @GetMapping(value = "/exitGateIsOpen")
    public ResponseEntity canExit() {
        return ResponseEntity.ok(gateService.canExit());
    }

}
