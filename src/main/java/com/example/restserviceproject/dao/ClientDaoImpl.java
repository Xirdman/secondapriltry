package com.example.restserviceproject.dao;

import com.example.restserviceproject.entity.Client;
import com.example.restserviceproject.mapper.ClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ClientDaoImpl implements ClientDao {

    private NamedParameterJdbcTemplate template;

    public ClientDaoImpl(@Autowired NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public Optional<List<Client>> findAll() {
        List<Client> result = null;
        try {
            result = template.query("select * from clients", new ClientRowMapper());
        } catch (EmptyResultDataAccessException e) {
        }
        return Optional.ofNullable(result);
    }

    @Override
    public int insertClient(String fName, String lName, String sName) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "INSERT INTO clients (firstname,lastname,surname) VALUES (:firstname,:lastname,:surname)";
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("firstname", fName)
                .addValue("lastname", lName)
                .addValue("surname", sName);
        template.update(sql, param, keyHolder);
        return (int) keyHolder.getKey();
    }

    @Override
    public Boolean deleteClient(int id) {
        final String sql = "DELETE FROM clients where id=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        return template.execute(sql, map, preparedStatement -> preparedStatement.executeUpdate() > 0);
    }

    @Override
    public Optional<Client> findByID(int id) {
        final String sql = "SELECT * FROM clients WHERE id =:id";
        SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
        Client client = null;
        try {
            client = template.queryForObject(sql, param, new ClientRowMapper());
        } catch (EmptyResultDataAccessException e) {
        }
        return Optional.ofNullable(client);
    }

    @Override
    public Boolean updateClient(int id, String fName, String lName, String sName) {
        final String sql = "UPDATE clients SET" +
                " firstname=:firstname," +
                " lastname=:lastname," +
                " surname=:surname" +
                " WHERE clients.id=:id";
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("firstname", fName);
        map.put("lastname", lName);
        map.put("surname", sName);
        return template.execute(sql, map, preparedStatement -> preparedStatement.executeUpdate() > 0);

    }

}
