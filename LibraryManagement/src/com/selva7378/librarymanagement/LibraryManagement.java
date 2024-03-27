package com.selva7378.librarymanagement;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.login.LoginView;

public class LibraryManagement {

    private static LibraryManagement libraryManagement;
    private String appName = "Library Management System";
    private String appVersion = "0.1.0";
    private LibraryManagement(){

    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    private void create(){
        LibraryDatabase.getInstance().loadData();
        LoginView loginView = new LoginView();
        loginView.init();
    }
    public static LibraryManagement getInstance(){
        if(libraryManagement == null){
            libraryManagement = new LibraryManagement();
        }
        return libraryManagement;
    }
    public static void main(String[] args) {
        LibraryManagement.getInstance().create();
    }
}
