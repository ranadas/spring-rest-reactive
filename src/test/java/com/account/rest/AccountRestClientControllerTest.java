package com.account.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//https://dzone.com/articles/build-rest-apis-with-kotlin-spring-5-webflux-and-p
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class AccountRestClientControllerTest {
//    @Autowired
//    private TestRestTemplate restTemplate;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
    }

    @Test
    public void findAllAccountsTest() throws Exception {
        assertThat(applicationContext).isNotNull();
//        assertThat(accountController).isNotNull();
//        assertThat(restTemplate).isNotNull();
        //assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class)).contains("Hello World");

        mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
    }

//    @Test
//    public void streamAllAccountsTest() throws Exception {
//    }

//    @Test
//    public void streamAllAccountsByCurrencyTest() throws Exception {
//    }
}