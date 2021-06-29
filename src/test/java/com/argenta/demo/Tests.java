package com.argenta.demo;

import com.argenta.demo.controller.Api;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = Api.class)
class Tests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void canEnter() throws Exception {
        this.mockMvc.perform(get("/api/enterGateIsOpen"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void canExit() throws Exception {
        this.mockMvc.perform(get("/api/exitGateIsOpen"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

}
