package br.com.example.testemodelmapper.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {

    private final MockMvc mockMvc;

    @Autowired
    TestControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("Deve retornar 200 ao converter uma conta corrente")
    void deveRetornar200AoConverterUmaContaCorrente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/conta/corrente")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    @DisplayName("Deve retornar 200 ao converter uma conta pagamento")
    void deveRetornar200AoConverterUmaContaPagamento() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/conta/corrente")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

}