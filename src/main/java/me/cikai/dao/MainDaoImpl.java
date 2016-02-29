package me.cikai.dao;

import javax.sql.DataSource;

import me.cikai.dto.FormDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class MainDaoImpl implements MainDao {

    private NamedParameterJdbcTemplate jdbcTemplate = null;

    @Autowired
    public void setDatasource(DataSource ds) {
        jdbcTemplate = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public void insert(FormDto formDto) {
        final StringBuilder sql = new StringBuilder();
        sql.append("INSERT ");
        sql.append("INTO ");
        sql.append("order_form ");
        sql.append("( ");
        sql.append("name, ");
        sql.append("food, ");
        sql.append("count, ");
        sql.append("payment ");
        sql.append(") ");
        sql.append("VALUES ");
        sql.append("( ");
        sql.append(":name, ");
        sql.append(":food, ");
        sql.append(":count, ");
        sql.append(":payment ");
        sql.append(") ");

        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("name", formDto.getName());
        paramMap.addValue("food", formDto.getFood());
        paramMap.addValue("count", formDto.getCount());
        paramMap.addValue("payment", formDto.getPayment());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql.toString(), paramMap, keyHolder);

    }

}
