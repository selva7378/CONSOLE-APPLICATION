package com.selva7378.interviewpannel.model;

public class Interviewee {
    private static int idIncreamenter = 1;

    private String name;
    private int id;
    private String phoneNo;
    private String emailId;
    private String address;

    public Interviewee(String name, String phoneNo, String emailId, String address) {
        this.name = name;
        this.id = idIncreamenter++;
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
