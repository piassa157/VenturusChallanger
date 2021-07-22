package com.challanger.venturus.controller;

import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContractControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldNotInsertNewContract() throws Exception {
        URI uri = new URI("/contracts");
        String json = "{\"subName\":\"testContrato\",\"startedDate\":\"2021-05-05\",\"closedDate\":\"2021-08-08\",\"customerDocument\":\"9987667812\",\"providerDocument\":\"9987667813\"}";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(400));
    }

    @Test
    public void shouldCarryInsertNewContract() throws Exception {
        URI uri = new URI("/contracts");
        String json = "{\"subName\":\"testContrato\",\"startedDate\":\"2021-05-05\",\"closedDate\":\"2021-08-08\",\"customerDocument\":\"199987667812\",\"providerDocument\":\"199987667813\"}";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(201));
    }


    @Test
    public void shouldCarryUpdateContrat() throws Exception{
        shouldCarryInsertNewContract();

        URI uri = new URI("/contracts/2");
        String json = "{\"subName\":\"testContratoUpdate\", \"serviceName\": \"testService\"}";
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put(uri)
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200));
    }

    @Test
    public void shouldCarryDeleteContract() throws Exception{
        shouldCarryInsertNewContract();
        URI uri = new URI("/contracts/1");
        mockMvc.perform(MockMvcRequestBuilders.delete(uri));
    }







}
