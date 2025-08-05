package com.project.simple_project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.simple_project.model.dtos.ProductReceivedDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateProduct() throws Exception {

        ProductReceivedDTO productReceivedDTO = getProductReceivedDTO();

        mockMvc.perform(MockMvcRequestBuilders.post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productReceivedDTO)))
                        .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    public ProductReceivedDTO getProductReceivedDTO() {
        ProductReceivedDTO productReceivedDTO = new ProductReceivedDTO();
        productReceivedDTO.setName("is test");
        productReceivedDTO.setPrice(15.3);
        productReceivedDTO.setQuantity(4);
        return productReceivedDTO;
    }
}
