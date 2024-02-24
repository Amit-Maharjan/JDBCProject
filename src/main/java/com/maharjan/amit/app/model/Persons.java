package com.maharjan.amit.app.model;

public class Persons {
    private Integer PersonID;
    private String LastName;
    private String FirstName;
    private String Address;
    private String City;

    public Persons() {
        System.out.println("-----Persons Default Constructor-----");
    }

    public Persons(Integer personID, String lastName, String firstName, String address, String city) {
        PersonID = personID;
        LastName = lastName;
        FirstName = firstName;
        Address = address;
        City = city;
    }

    public Integer getPersonID() {
        return PersonID;
    }

    public void setPersonID(Integer personID) {
        PersonID = personID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
