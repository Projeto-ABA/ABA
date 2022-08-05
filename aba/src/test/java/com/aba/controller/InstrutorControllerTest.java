package com.aba.controller;

import com.aba.interfaces.InstrutorService;
import com.aba.model.Instrutor;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.aba.repository.InstrutorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

//@SpringBootTest
@WebMvcTest(InstrutorAPIController.class)
@AutoConfigureMockMvc(addFilters = false)
//@ComponentScan
public class InstrutorControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private InstrutorService instrutorService;

    @MockBean
    private InstrutorRepository instrutorRepository;

    private Instrutor instrutor;


    @Test
    public void testPostInstrutor() throws Exception {

        this.mockMvc.perform(post("/api/instrutores")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(this.instrutor))
                .characterEncoding("utf-8"))
                .andExpect(status().isOk());
//              .andExpect(jsonPath("$.id", is(this.instrutor.getId().intValue())));

//        given(this.instrutorRepository.save(this.instrutor)).willReturn(this.instrutor);
//
//        this.mockMvc.perform(post("/api/instrutores")
//                                .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"id\": 1, \"name\": \"" + this.instrutor.getNome()
//                                + "\", \"idade\": \"" + this.instrutor.getIdade() + "\", \"email\": \"" + this.instrutor.getEmail() + "\"}")
//                .characterEncoding("utf-8")).andExpect(status().isOk())
//                .andExpect(jsonPath("$.id", is(this.instrutor.getId().intValue())));
    }

    @Test
    public void testGetInstrutor() throws Exception {



    }
}
