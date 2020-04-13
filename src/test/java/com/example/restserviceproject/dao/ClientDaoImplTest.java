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
    ClientDaoImpl testDao;

    @Test
    void addClientTest() {
        testDao = new ClientDaoImpl(template);
        Client addedClient = new Client("Тестовый клиент", "Фамилия", "Имя");
        assertThat(testDao.insertClient(addedClient.getFirstName(),
                addedClient.getLastName(),
                addedClient.getSurName())).isTrue();
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
        Client addedClient1 = new Client("Первый", "Болванчик", "Петрович");
        Client addedClient2 = new Client("Второй", "Болванчик", "Петрович");
        Client addedClient3 = new Client("Третий", "Болванчик", "Петрович");
        assertThat((testDao.insertClient(addedClient1.getFirstName(),
                addedClient1.getLastName(),
                addedClient1.getSurName())) &&
                (testDao.insertClient(addedClient2.getFirstName(),
                        addedClient2.getLastName(),
                        addedClient2.getSurName())) &&
                (testDao.insertClient(addedClient3.getFirstName(),
                        addedClient3.getLastName(),
                        addedClient3.getSurName()))).isTrue();
    }
    @Test
    void findByIdTest(){
        testDao = new ClientDaoImpl(template);
        Client client =  testDao.findById(5);
        assertThat(client).isNotNull();
    }
    @Test
    void deleteByIdTest(){
        testDao = new ClientDaoImpl(template);
        assertThat(testDao.deleteClient(5)).isTrue();
    }


}