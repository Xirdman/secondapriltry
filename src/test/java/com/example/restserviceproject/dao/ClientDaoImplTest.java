package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

//У меня не запускаются тесты с аннотацией DataJdbcTest, пишет не находит контекст,
// хотя выше по пкаеты в SecondapriltryApplicationTests есть аннотация Spring boot test
// и спринг мог бы инициализировать контекст там
@SpringBootTest
@TestPropertySource("/applicationtest.properties")
public class ClientDaoImplTest {

    @Autowired
    NamedParameterJdbcTemplate template;
    @Autowired
    ClientDaoImpl testDao;

    /*
    Пока не придумал им применения
    @BeforeAll
    static void beforeTests(){
    }
    @AfterAll
    static void afterTests(){
    }*/
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
        if (client.isPresent()) {
            Assert.isTrue(true, "");
        }
    }

    @Test
    void deleteByIdTest() {
        int i = testDao.insertClient("deleteTestFName", "deleteLastName", "deleteSurName");
        Assert.isTrue(testDao.deleteClient(i), "");
    }

    @Test
    void crudTestInOneMethod() {
        Client testClient = new Client("testFirstName", "testLastName", "testSurName");
        int id = testDao.insertClient(testClient.getFirstName(),
                testClient.getLastName(),
                testClient.getSurName());
        Optional<Client> cl = testDao.findByID(id);
        Client findByIdTestClient = null;
        if (cl.isPresent()) {
            findByIdTestClient = cl.get();
        } else {
            Assert.isTrue(false, "Optional пустой");
        }
        Assert.isTrue(testClient.getFirstName().equals(findByIdTestClient.getFirstName()), "Имена не равны в добавленном клиенте");
        Assert.isTrue(testClient.getLastName().equals(findByIdTestClient.getLastName()), "не равны " + testClient.getLastName() + " " + findByIdTestClient.getLastName());
        Assert.isTrue(testClient.getSurName().equals(findByIdTestClient.getSurName()), "Отчества не равны в добавленном клиенте");

        testClient.setFirstName("ОбновленноеИмя");
        testClient.setLastName("ОбновленнаяФамилия");
        testClient.setSurName("ОбновленноеОтчество");

        testDao.updateClient(id, testClient.getFirstName(), testClient.getLastName(), testClient.getSurName());
        Optional<Client> cl2 = testDao.findByID(id);
        Client updateTestClient = null;
        if (cl2.isPresent()) {
            updateTestClient = cl2.get();
        } else {
            Assert.isTrue(false, "Optional пустой");
        }

        Assert.isTrue(testClient.getFirstName().equals(updateTestClient.getFirstName()), "Имена не равны в обновленом клиенте");
        Assert.isTrue(testClient.getLastName().equals(updateTestClient.getLastName()), "Фамилии не равны в обновленом клиенте");
        Assert.isTrue(testClient.getSurName().equals(updateTestClient.getSurName()), "Отчества не равны в обновленом клиенте");

        Assert.isTrue(testDao.deleteClient(id), "Удаление не прошло");

        testDao.insertClient("1", "1", "1");
        testDao.insertClient("2", "2", "2");
        List<Client> list = testDao.findAll();
        Assert.noNullElements(list, "Пустые элементы");
    }
}