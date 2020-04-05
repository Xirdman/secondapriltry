package com.example.restserviceproject.dao;

import com.example.restserviceproject.mapper.ClientRowMapper;
import com.example.restserviceproject.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private NamedParameterJdbcTemplate template;


    @Override
    public List<Client> findAll() {
        return template.query("select * from clients", new ClientRowMapper());
    }

    @Override
    public void insertClient(Client client) {
        final String sql = "INSERT INTO clients (id,firstname,lastname,surname) VALUES (:id,:firstname,:lastname,:surname)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource().addValue("id",client.getId())
                .addValue("firstname",client.getFirstName())
                .addValue("lastname",client.getLastName()).addValue("surname",client.getSurName());
        template.update(sql,param,keyHolder);

    }

    @Override
    public void updateClient(Client client) {
        final String sql = "UPDATE clients  SET firstname =:firstname,lastname =: lastname, surname =: surname";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("lastname",client.getLastName()).addValue("firstname",client.getFirstName())
                .addValue("surname",client.getSurName());
        template.update(sql,param,keyHolder);

    }

    @Override
    public void deleteClient(Client client) {
        final String sql = "DELETE FROM clients where id=:id";
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",client.getId());
        template.execute(sql, map, new PreparedStatementCallback<Object>(){
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement)throws SQLException, DataAccessException {
                return  preparedStatement.executeUpdate();
            }
        });

    }

    @Override
    public void executeUpdateClient(Client client) {
        final String sql = "UPDATE clients SET firstname=:firstname, lastname:=lastname, surname:=surname WHERE id =:id";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",client.getId());
        map.put("firstname",client.getFirstName());
        map.put("lastname",client.getLastName());
        map.put("surname",client.getSurName());
        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException,DataAccessException{
                return preparedStatement.executeUpdate();
            }
        });
    }

}
