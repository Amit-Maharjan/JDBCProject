package com.maharjan.amit.app.impl;

import com.maharjan.amit.app.dao.PersonsDAO;
import com.maharjan.amit.app.model.Persons;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonsDAOImpl implements PersonsDAO {
    private Connection conn;

    private void connect() throws SQLException {
        String hostUrl = "jdbc:mysql://localhost/example?useSSL=false";
        String username = "root";
        String password = "root";
        conn = DriverManager.getConnection(hostUrl, username, password);
    }

    @Override
    public List<Persons> getAll() throws SQLException {
        List<Persons> persons = new ArrayList<>();
        connect();
        String sql = "select * from persons;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            persons.add(mapData(rs));
        }
        conn.close();
        return persons;
    }

    private Persons mapData(ResultSet rs) throws SQLException {
        Persons person = new Persons();
        person.setPersonID(rs.getInt("PersonID"));
        person.setFirstName(rs.getString("FirstName"));
        person.setLastName(rs.getString("LastName"));
        person.setAddress(rs.getString("Address"));
        person.setCity(rs.getString("City"));
        return person;
    }

    @Override
    public Persons getById(Integer id) throws SQLException {
        Persons person = null;
        connect();
        String sql = "select * from persons where PersonID=?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            person = mapData(rs);
        }
        conn.close();
        return person;
    }

    @Override
    public Integer insert(Persons persons) throws SQLException {
        String sql = "INSERT INTO persons (`PersonID`, `LastName`, `FirstName`, `Address`, `City`)\n" +
                "VALUES (?,?,?,?,?);";
        connect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, persons.getPersonID());
        stmt.setString(2, persons.getLastName());
        stmt.setString(3, persons.getFirstName());
        stmt.setString(4, persons.getAddress());
        stmt.setString(5, persons.getCity());
        Integer result = stmt.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public Integer update(Persons persons) throws SQLException {
        String sql = "update persons " +
                "set LastName = ?, " +
                "FirstName = ?, " +
                "Address = ?, " +
                "City = ? " +
                "where PersonID = ?";
        connect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, persons.getLastName());
        stmt.setString(2, persons.getFirstName());
        stmt.setString(3, persons.getAddress());
        stmt.setString(4, persons.getCity());
        stmt.setInt(5, persons.getPersonID());
        Integer result = stmt.executeUpdate();
        conn.close();
        return result;
    }

    @Override
    public Integer deleteById(Integer id) throws SQLException {
        String sql = "delete from persons " +
                "where PersonID = ?";
        connect();
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        Integer result = stmt.executeUpdate();
        conn.close();
        return result;
    }
}
