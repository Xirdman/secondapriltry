package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("/applicationtest.properties")
public class ClientDaoImplTest {

    @Autowired
    NamedParameterJdbcTemplate template;
    @Autowired
    ClientDaoImpl testDao;

    @Test
    void addClientTest() {
    }

    @Test
    void updateClientTest() {
        testDao = new ClientDaoImpl(template);
        List<Client> list = testDao.findAll();
        Client cl = list.get(0);
        cl.setLastName("ОбновленнаяФамилия");
        assertThat(testDao.updateClient(cl)).isTrue();
    }

    @Test
    void insertThreeClientsTest() {
        testDao = new ClientDaoImpl(template);

    }
    @Test
    void findByIdTest(){
        testDao = new ClientDaoImpl(template);
    }
    @Test
    void deleteByIdTest(){
        testDao = new ClientDaoImpl(template);
        assertThat(testDao.deleteClient(5)).isTrue();
    }
}