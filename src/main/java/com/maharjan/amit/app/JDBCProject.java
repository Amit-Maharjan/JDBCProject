/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.maharjan.amit.app;

import com.maharjan.amit.app.dao.PersonsDAO;
import com.maharjan.amit.app.dao.StudentsDAO;
import com.maharjan.amit.app.impl.PersonsDAOImpl;
import com.maharjan.amit.app.impl.StudentsDAOImpl;
import com.maharjan.amit.app.model.Persons;
import com.maharjan.amit.app.model.Students;

import java.sql.*;

/**
 *
 * @author Student99
 */
public class JDBCProject {

    public static void main(String[] args) {
        try {
            PersonsDAO personsDAO = new PersonsDAOImpl();
            for(Persons persons: personsDAO.getAll()){
                System.out.println(persons.getFirstName() + " " + persons.getLastName());
            }

            System.out.println("----------------");

            int count = 2;
            Integer result = personsDAO.insert(new Persons(count,"Mahatara","Kiran","USA","NY"));
            System.out.println("result = " + result);

            System.out.println("----------------");

            result = personsDAO.update(new Persons(count,"KC","Bishnu","USA","NY"));
            System.out.println("result = " + result);

            System.out.println("----------------");

            Persons persons = personsDAO.getById(count);
            if(persons!=null){
                System.out.println(persons.getFirstName());
            }

            System.out.println("----------------");

            result = personsDAO.deleteById(count);
            System.out.println("result = " + result);

            StudentsDAO studentsDAO = new StudentsDAOImpl();
            studentsDAO.getAll().forEach( std -> System.out.println(std.toString()));

            System.out.println("----------------");

            int studentsResult  = studentsDAO.insert(new Students("LastName", "FirstName", "Address", "City"));
            System.out.println("studentsResult = " + studentsResult);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("ERROR occured in main program");
            ex.printStackTrace();
        }
    }
}
