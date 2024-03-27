package com.selva7378.librarymanagement.librarysetup;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.Library;
import com.selva7378.librarymanagement.regexvalidate.RegexValidate;

class LibrarySetupModel {

    // This variable should be private.
    // so that outside of this class cannot access this variable.
    private LibrarySetupView librarySetupView;

    private Library library;

    // Access modifier for this LibrarySetupModel constructor should be default.
    // So that outside of the package this constructor cannot be accessed.
    LibrarySetupModel(LibrarySetupView librarySetupView) {
        this.librarySetupView = librarySetupView;
        library = LibraryDatabase.getInstance().getLibrary();
    }

    public void startSetup() {
        if (library == null || library.getLibraryId() == 0) {
            librarySetupView.initiateSetup();
        } else {
            librarySetupView.onSetupComplete(library);
        }
    }

    public void createLibrary(Library library) {
        // name, email, phone no validation here
        if (library.getLibraryName().length() <3  || library.getLibraryName().length() > 50) {
            librarySetupView.showAlert("Enter valid name");
            return;
        }
        this.library = LibraryDatabase.getInstance().insertLibrary(library);
        librarySetupView.onSetupComplete(library);
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

