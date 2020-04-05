package com.example.restserviceproject.mapper;

import com.example.restserviceproject.entity.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper <Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();
        client.setId(resultSet.getInt("id"));
        client.setFirstName(resultSet.getString("firstname"));
        client.setLastName(resultSet.getString("lastname"));
        client.setSurName(resultSet.getString("surname"));
        return client;
    }
}
