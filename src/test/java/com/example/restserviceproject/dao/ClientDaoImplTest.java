package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.Client;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource("/applicationtest.properties")
public class ClientDaoImplTest {

    @Autowired
    NamedParameterJdbcTemplate template;
    @Autowired
    ClientDaoImpl testDao;

    @BeforeEach
    void beforeEach() {
        template.execute("DELETE FROM clients", preparedStatement -> preparedStatement.execute());
    }

    @Test
    void addClientTest() {
        testDao.insertClient("insertTestFName", "insertTestLName", "insertTestSName");
    }

    @Test
    void updateClientTest() {
        int i = testDao.insertClient("updateTestFName", "updateLastName", "updateSurName");
        testDao.updateClient(i, "updatedFName", "updatedLName", "updatedSName");
    }

    @Test
    void findByIdTest() {
        int i = testDao.insertClient("findTestFName", "findLastName", "findSurName");
        Optional<Client> client = testDao.findByID(i);
        if (!client.isPresent()) {
        }
    }

    @Test
    void deleteByIdTest() {
        int i = testDao.insertClient("deleteTestFName", "deleteLastName", "deleteSurName");
        Assert.isTrue(testDao.deleteClient(i), "");
        Optional<Client> client = null;
        try {
            client = new ClientDaoImpl(template).findByID(i);
        } catch (EmptyResultDataAccessException e) {
        }
        assertNull(client);
    }

    @Test
    void crudTestInOneMethod() {
        Client testClient = new Client("testFirstName", "testLastName", "testSurName");
        int id = testDao.insertClient(testClient.getFirstName(),
                testClient.getLastName(),
                testClient.getSurName());
        Optional<Client> cl = testDao.findByID(id);
        Client findByIdTestClient = null;
        assertTrue(cl.isPresent(), "optional пустой");
        findByIdTestClient = cl.get();

        MatcherAssert.assertThat(findByIdTestClient.getFirstName(), Matchers.is(testClient.getFirstName()));
        MatcherAssert.assertThat(findByIdTestClient.getLastName(), Matchers.is(testClient.getLastName()));
        MatcherAssert.assertThat(findByIdTestClient.getSurName(), Matchers.is(testClient.getSurName()));

        testClient.setFirstName("ОбновленноеИмя");
        testClient.setLastName("ОбновленнаяФамилия");
        testClient.setSurName("ОбновленноеОтчество");

        testDao.updateClient(id, testClient.getFirstName(), testClient.getLastName(), testClient.getSurName());
        Optional<Client> cl2 = testDao.findByID(id);
        Client updateTestClient = null;
        assertTrue(cl2.isPresent(), "optional пустой");
        if (cl2.isPresent()) {
            updateTestClient = cl2.get();
        }
        MatcherAssert.assertThat(updateTestClient.getFirstName(), Matchers.is(testClient.getFirstName()));
        MatcherAssert.assertThat(updateTestClient.getLastName(), Matchers.is(testClient.getLastName()));
        MatcherAssert.assertThat(updateTestClient.getSurName(), Matchers.is(testClient.getSurName()));

        assertTrue(testDao.deleteClient(id), "Удаление не прошло");

        testDao.insertClient("1", "1", "1");
        testDao.insertClient("2", "2", "2");
        Optional<List<Client>> list = testDao.findAll();
        if(!list.isPresent()){
        }
    }
}