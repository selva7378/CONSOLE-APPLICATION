package com.selva7378.librarymanagement.managebook;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.Book;
import com.selva7378.librarymanagement.regexvalidate.RegexValidate;

class ManageBookModel {

    private ManageBookView manageBookView;

    ManageBookModel(ManageBookView manageBookView) {
        this.manageBookView = manageBookView;
    }

    public void addNewBook(Book book) {
        if (LibraryDatabase.getInstance().insertBook(book)) {
            manageBookView.onBookAdded(book);
        } else {
            manageBookView.onBookExist(book);
        }
    }

    public void removeBook(int id){
        Book book = LibraryDatabase.getInstance().removeBook(id);
        if(book != null){
            manageBookView.onSuccess(book);
        }else{
            manageBookView.onFailure();
        }
    }

//     ------------------------------below code is for validation---------------------------------------

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

    public boolean isValidatePublication(String publication){
        return RegexValidate.getInstance().validatePublication(publication);
    }
}
