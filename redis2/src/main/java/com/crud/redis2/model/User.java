package com.crud.redis2.model;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private Address homeAddress;
    private Address officeAddress;

    public User(String firstName, String lastName, Address homeAddress, Address officeAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.officeAddress = officeAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

}
