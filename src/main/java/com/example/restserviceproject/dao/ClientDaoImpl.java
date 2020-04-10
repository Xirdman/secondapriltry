package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.Client;
import com.example.restserviceproject.mapper.ClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClientDaoImpl implements ClientDao {
    private NamedParameterJdbcTemplate template;

    public ClientDaoImpl(@Autowired NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public ClientDaoImpl() {

    }


    @Override
    public List<Client> findAll() {
        return template.query("select * from clients", new ClientRowMapper());
    }

    @Override
    public Boolean insertClient(String fName, String lName, String sName) {
        final String sql = "INSERT INTO clients (firstname,lastname,surname) VALUES (:firstname,:lastname,:surname)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("firstname", fName)
                .addValue("lastname", lName)
                .addValue("surname", sName);
        return template.execute(sql, param, preparedStatement -> preparedStatement.executeUpdate() > 0);

    }

    @Override
    public Boolean deleteClient(int id) {
        final String sql = "DELETE FROM clients where id=:id";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        return template.execute(sql, map, preparedStatement -> preparedStatement.executeUpdate() > 0);
    }

    @Override
    public Boolean updateClient(Client client) {
        final String sql = "UPDATE clients SET" +
                " firstname=:firstname," +
                " lastname=:lastname," +
                " surname=:surname" +
                " WHERE clients.id=:id";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", client.getId());
        map.put("firstname", client.getFirstName());
        map.put("lastname", client.getLastName());
        map.put("surname", client.getSurName());
        return template.execute(sql, map, preparedStatement -> preparedStatement.executeUpdate() > 0);

    }

    @Override
    public Client findById(int id) {
        final String sql = "SELECT * FROM clients WHERE id=:id";
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        return template.queryForObject(sql, map, new ClientRowMapper());
    }

}
