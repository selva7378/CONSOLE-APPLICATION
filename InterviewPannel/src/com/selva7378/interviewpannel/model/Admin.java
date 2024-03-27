package com.selva7378.interviewpannel.model;

public class Admin {
    private static int idIncreamenter = 1;

    private String name;
    private int id;
    private String password;
    private String phoneNo;
    private String emailId;
    private String address;

    public Admin(String name, String password, String phoneNo, String emailId, String address) {
        this.id = idIncreamenter++;
        this.name = name;
        this.password = password;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getAddress() {
        return address;
    }
}
