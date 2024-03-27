package com.selva7378.librarymanagement.model;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;

public class User {

    private String name;
    private int id;
    private String phoneNo;
    private String emailId;
    private String address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public User(String name, String phoneNo, String emailId, String address) {
        this.name = name;
        this.id = LibraryDatabase.getInstance().userListSize()+1;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

