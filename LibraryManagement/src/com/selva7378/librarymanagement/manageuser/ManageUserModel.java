package com.selva7378.librarymanagement.manageuser;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.User;
import com.selva7378.librarymanagement.regexvalidate.RegexValidate;

class ManageUserModel {

    private ManageUserView manageUserView;

    ManageUserModel(ManageUserView manageUserView) {
        this.manageUserView = manageUserView;
    }

    public void addNewUser(User user) {
        if (LibraryDatabase.getInstance().insertUser(user)) {
            manageUserView.onUserAdded(user);
        } else {
            manageUserView.onUserExist(user);
        }
    }

    public void removeUser(int id){
        User user = LibraryDatabase.getInstance().removeUser(id);
        if(user != null){
            manageUserView.onSuccess(user);
        }else{
            manageUserView.onFailure();
        }
    }

    // below code is for validation

    public boolean isValidateName(String name){
        return RegexValidate.getInstance().validateName(name);
    }

    public boolean isValidatePassword(String password){
        return RegexValidate.getInstance().validatePassword(password);
    }

    public boolean isValidatePhoneNumber(String phoneNumber){
        return RegexValidate.getInstance().validatePhoneNumber(phoneNumber);
    }

    public boolean isValidateEmailId(String email){
        return RegexValidate.getInstance().validateEmailId(email);
    }

    public boolean isValidateAddress(String address){
        return RegexValidate.getInstance().validateAddress(address);
    }
}