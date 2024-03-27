package com.selva7378.librarymanagement.model;

public class Admin {
    private static int idIncreamenter = 1;
    private String name;
    private String password;
    private int id;
    private String phoneNo;
    private String emailId;
    private String address;

    public String getPassword() {
        return password;
    }

    public Admin(String name, String password, String phoneNo, String emailId, String address) {
        this.name = name;
        this.password = password;
        this.id = idIncreamenter++;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
