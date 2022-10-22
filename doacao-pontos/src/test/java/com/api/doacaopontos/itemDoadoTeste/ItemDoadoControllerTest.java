package com.api.doacaopontos.itemDoadoTeste;

import com.api.doacaopontos.model.ItemDoado;
import com.api.doacaopontos.repository.ItemDoadoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemDoadoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ItemDoadoRepository itemDoadoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void buscarTodosItens() throws Exception {
        mockMvc.perform(get("/item-doado")).andExpect(status().isOk());
    }
}
