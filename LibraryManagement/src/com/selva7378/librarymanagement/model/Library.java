package com.selva7378.librarymanagement.model;

public class Library {
    private static int idIncreamenter = 1;
    private String libraryName;
    private int libraryId;
    private String phoneNo;
    private String emailId;
    private String address;

    public Library(String libraryName,String phoneNo, String emailId, String address) {
        this.libraryName = libraryName;
        this.libraryId = idIncreamenter++;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.address = address;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
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
