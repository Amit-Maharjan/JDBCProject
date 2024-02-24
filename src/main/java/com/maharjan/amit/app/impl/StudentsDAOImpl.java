package com.maharjan.amit.app.impl;

import com.maharjan.amit.app.dao.StudentsDAO;
import com.maharjan.amit.app.db.core.JdbcTemplate;
import com.maharjan.amit.app.model.Students;

import java.sql.*;
import java.util.List;

public class StudentsDAOImpl implements StudentsDAO {
    private JdbcTemplate<Students> jdbcTemplate = new JdbcTemplate<>();

    @Override
    public List<Students> getAll() throws SQLException {
        String sql = "select * from students";
        return jdbcTemplate.query(sql, rs -> mapData(rs));
    }

    private Students mapData(ResultSet rs) throws SQLException {
        Students student = new Students();
        student.setId(rs.getInt("id"));
        student.setFirstName(rs.getString("first_name"));
        student.setLastName(rs.getString("last_name"));
        student.setAddress(rs.getString("address"));
        student.setCity(rs.getString("city"));
        return student;
    }

    @Override
    public Students getById(Integer id) throws SQLException {
        String sql = "select * from students where id=?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, rs -> mapData(rs));
    }

    @Override
    public Integer insert(Students students) throws SQLException {
        String sql = "INSERT INTO students (`last_name`, `first_name`, `address`, `city`)\n" +
                "VALUES (?,?,?,?);";
        return jdbcTemplate.update(sql, new Object[]{
                students.getLastName(), students.getFirstName(), students.getAddress(), students.getCity()
        });
    }

    @Override
    public Integer update(Students students) throws SQLException {
        String sql = "update students " +
                "set last_name = ?, " +
                "first_name = ?, " +
                "address = ?, " +
                "city = ? " +
                "where id = ?";
        return jdbcTemplate.update(sql, new Object[]{
                students.getLastName(), students.getFirstName(), students.getAddress(), students.getCity(), students.getId()
        });
    }

    @Override
    public Integer deleteById(Integer id) throws SQLException {
        String sql = "delete from students " +
                "where id = ?";
        return jdbcTemplate.update(sql, new Object[]{ id });
    }
}
