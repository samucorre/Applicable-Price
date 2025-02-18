package com.example.applicable.price;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 10:00:00"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0].price").value(35.5)).andReturn();
    }

    /**
     * Test for request with application date: 16:00 on June 14, 2020, for product with id 35455 and brand 1.
     */
    @Test
    void test2() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 16:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(2))
                .andExpect(jsonPath("$[0].price").value(25.45))
                .andExpect(jsonPath("$[1].id").value(1))
                .andExpect(jsonPath("$[1].price").value(35.5));
    }

    /**
     * Test for request with application date: 21:00 on June 14, 2020, for product with id 35455 and brand 1.
     */
    @Test
    void test3() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-14 21:00:00"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0].price").value(35.5)).andReturn();
    }

    /**
     * Test for request with application date: 10:00 on June 15, 2020, for product with id 35455 and brand 1.
     */
    @Test
    void test4() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-15 10:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(3))
                .andExpect(jsonPath("$[0].price").value(30.5))
                .andExpect(jsonPath("$[1].id").value(1))
                .andExpect(jsonPath("$[1].price").value(35.5));
    }

    /**
     * Test for request with application date: 21:00 on June 16, 2020, for product with id 35455 and brand 1.
     */
    @Test
    void test5() throws Exception {
        mockMvc.perform(get("/api/prices")
                        .param("brandId", "1")
                        .param("productId", "35455")
                        .param("applicationDate", "2020-06-16 21:00:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(4))
                .andExpect(jsonPath("$[0].price").value(38.95))
                .andExpect(jsonPath("$[1].id").value(1))
                .andExpect(jsonPath("$[1].price").value(35.5));
    }
}