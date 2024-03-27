package com.selva7378.librarymanagement.login;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.Admin;
import com.selva7378.librarymanagement.regexvalidate.RegexValidate;

class LoginModel {

    private LoginView loginView;

    LoginModel(LoginView loginView) {
        this.loginView = loginView;
    }

    public void validateUser(String userName, String password) {
        if (isValidUserName(userName)) {
            if (isValidPassword(userName,password)) {
                loginView.onSuccess();
            } else {
                loginView.onLoginFailed("Invalid password");
            }
        } else {
            loginView.onLoginFailed("Invalid User Name");
        }
    }

    private boolean isValidUserName(String userName) {
        return userName.equals(LibraryDatabase.getInstance().getAdmin().getName());
    }

    public void addAdmin(Admin admin){
        LibraryDatabase.getInstance().addAdmin(admin);
    }


    private boolean isValidPassword(String userName, String password) {
        return (userName.equals(LibraryDatabase.getInstance().getAdmin().getName())
                && password.equals(LibraryDatabase.getInstance().getAdmin().getPassword()));
    }
}