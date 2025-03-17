package com.recap.ms2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recap.ms2.dto.NotaFiscalRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
class ControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    private ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void deveRetornarstatus200() throws Exception {
        var request = jsonBuilder(new HashMap<>(){
            {
                put("cnpj", "123456789");
                put("valorTotalnf", 100.0);
            }
        });

        this.mockMvc.perform(post("/rest/v1/notafiscal/processar")
                        .contentType("application/json;charset=UTF-8")
                        .content(request))
                .andExpect(status().isOk());
    }

    private String jsonBuilder(HashMap<String,Object> atributos) throws JsonProcessingException {
        return objectMapper.writeValueAsString(atributos);
    }
}