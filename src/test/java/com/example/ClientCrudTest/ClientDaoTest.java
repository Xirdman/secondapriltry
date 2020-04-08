package com.example.ClientCrudTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest
public class ClientDaoTest {
    @Autowired
    private TestRestTemplate template;

}
