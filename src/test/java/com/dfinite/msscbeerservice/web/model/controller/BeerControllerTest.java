package com.dfinite.msscbeerservice.web.model.controller;

import com.dfinite.model.BeerDto;
import com.dfinite.msscbeerservice.web.controller.BeerController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest{

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        }

    @Test
    void savedBeerDto() throws Exception {

        BeerDto beerDto = BeerDto.builder().build();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform((MockMvcRequestBuilders.post("/api/v1/beer/"))
                .contentType(MediaType.APPLICATION_JSON).content(beerToJson)).andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {

        BeerDto beerDto = BeerDto.builder().build();
        String beerToJson = objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON).content(beerToJson)).andExpect(status().isNoContent());
    }
}