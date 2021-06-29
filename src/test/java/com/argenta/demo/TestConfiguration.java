package com.argenta.demo;

import com.argenta.demo.controller.Api;
import com.argenta.demo.service.GateService;
import com.argenta.demo.service.InformationBoardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
/*@EnableWebMvc*/
public class TestConfiguration {

    @Bean
    public InformationBoardService informationBoardService() {
        return new InformationBoardService() {
            @Override
            public boolean hasFreeLot() {
                return true;
            }
        };
    }

    @Bean
    public GateService gateService() {
        return new GateService(informationBoardService());
    }

    @Bean
    public Api api() {
        return new Api(gateService());
    }

}
