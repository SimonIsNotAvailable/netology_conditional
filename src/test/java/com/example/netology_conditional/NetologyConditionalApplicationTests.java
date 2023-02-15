package com.example.netology_conditional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NetologyConditionalApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    @Container
    private static final GenericContainer<?> devCunt = new GenericContainer<>("devapp");
    @Container
    private static final GenericContainer<?> prodCunt = new GenericContainer<>("prodapp");


    @Test
    void contextLoadsDevTest() {
        Integer myAppDev = devCunt.getMappedPort(8080);
        ResponseEntity<String> forEntity1 = restTemplate.getForEntity("http://localhost:" + myAppDev + "/profile", String.class);
        Assertions.assertEquals(forEntity1.getBody(), "Current profile is Dev");
    }

    @Test
    void contextLoadsProdTest() {
        Integer myAppProd = prodCunt.getMappedPort(8081);
        ResponseEntity<String> forEntity2 = restTemplate.getForEntity("http://localhost:" + myAppProd + "/profile", String.class);
        Assertions.assertEquals(forEntity2.getBody(), "Current profile is Prod");
    }
}
