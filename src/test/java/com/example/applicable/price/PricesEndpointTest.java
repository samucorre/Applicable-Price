package com.example.applicable.price;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests the "/api/prices" REST endpoint to ensure that the request works correctly.
 */

@SpringBootTest
@AutoConfigureMockMvc
class PricesEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Test for a request with application date: 10:00 AM on June 14th, 2020, for the product with ID 35455 and brand ID 1.
     */
    @Test
    void test1() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 10:00:00"))
                .andExpect(status().isOk())
                .andReturn();  // Captura la respuesta completa

        // Convertimos JSON a formato legible
        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String prettyJson = writer.writeValueAsString(mapper.readTree(jsonResponse));

        System.out.println("Endpoint response for the Test 1:\n" + prettyJson);
    }

    /**
     * Test for request with application date: 16:00 on June 14, 2020, for product with id 35455 and brand 1.
     */
    @Test
    void test2() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 16:00:00"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String prettyJson = writer.writeValueAsString(mapper.readTree(jsonResponse));

        System.out.println("Endpoint response for the Test 2:\n" + prettyJson);
    }

    /**
     * Test for request with application date: 21:00 on June 14, 2020, for product with id 35455 and brand 1.
     */
    @Test
    void test3() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 21:00:00"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String prettyJson = writer.writeValueAsString(mapper.readTree(jsonResponse));

        System.out.println("Endpoint response for the Test 3:\n" + prettyJson);
    }

    /**
     * Test for request with application date: 10:00 on June 15, 2020, for product with id 35455 and brand 1.
     */
    @Test
    void test4() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15 10:00:00"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String prettyJson = writer.writeValueAsString(mapper.readTree(jsonResponse));

        System.out.println("Endpoint response for the Test 4:\n" + prettyJson);
    }

    /**
     * Test for request with application date: 21:00 on June 16, 2020, for product with id 35455 and brand 1.
     */
    @Test
    void test5() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16 21:00:00"))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
        String prettyJson = writer.writeValueAsString(mapper.readTree(jsonResponse));

        System.out.println("Endpoint response for the Test 5:\n" + prettyJson);
    }
}
