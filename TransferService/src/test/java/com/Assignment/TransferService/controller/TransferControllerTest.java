package com.Assignment.TransferService.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.Assignment.TransferService.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TransferController.class)
class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TransferService transferService;

    @InjectMocks
    private TransferController transferController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAccount() throws Exception {
        mockMvc.perform(post("/api/accounts"))
                .andExpect(status().isCreated());
    }

    @Test
    void testTransfer_Successful() throws Exception {
        mockMvc.perform(post("/api/transfer")
                        .param("source", "12345")
                        .param("destination", "67890")
                        .param("amount", "500"))
                .andExpect(status().isOk());
    }

    @Test
    void testTransfer_InvalidAccount() throws Exception {
        mockMvc.perform(post("/api/transfer")
                        .param("source", "invalid")
                        .param("destination", "67890")
                        .param("amount", "500"))
                .andExpect(status().isBadRequest());
    }
}
