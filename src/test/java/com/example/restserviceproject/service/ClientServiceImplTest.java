package com.example.restserviceproject.service;

import com.example.restserviceproject.dao.ClientDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@TestPropertySource("/applicationtest.properties")
public class ClientServiceImplTest {
    ClientDao clientDao;
    public ClientServiceImplTest(){
    }

    @Test
    public void contextLoads() {
        assertThat(clientDao).isNotNull();
    }


}