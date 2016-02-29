package me.cikai.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import me.cikai.dto.FormDto;
import me.cikai.dto.ListDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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
        sql.append("payment, ");
        sql.append("time ");
        sql.append(") ");
        sql.append("VALUES ");
        sql.append("( ");
        sql.append(":name, ");
        sql.append(":food, ");
        sql.append(":count, ");
        sql.append(":payment, ");
        sql.append("NOW() ");
        sql.append(") ");

        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("name", formDto.getName());
        paramMap.addValue("food", formDto.getFood());
        paramMap.addValue("count", formDto.getCount());
        paramMap.addValue("payment", formDto.getPayment());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql.toString(), paramMap, keyHolder);

    }

    @Override
    public List<ListDto> select() {
        MapSqlParameterSource paramMap = new MapSqlParameterSource();

        StringBuilder sql = new StringBuilder();
        sql.append(" select ");
        sql.append(" * ");
        sql.append(" from ");
        sql.append(" order_form ");
        sql.append(" where ");
        sql.append(" 1=1 ");

        List<ListDto> list = jdbcTemplate.query(sql.toString(), paramMap, new ListRowMapper());
        return list;
    }

    protected class ListRowMapper implements RowMapper<ListDto> {
        @Override
        public ListDto mapRow(ResultSet rs, int arg1) throws SQLException {

            ListDto listDto = new ListDto();
            listDto.setName(rs.getString("name"));
            listDto.setFood(rs.getInt("food"));
            listDto.setCount(rs.getInt("count"));
            listDto.setPayment(rs.getInt("payment"));
            listDto.setTime(rs.getTimestamp("time"));
            return listDto;
        }
    }

}
