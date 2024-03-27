package com.selva7378.librarymanagement.login;

import java.util.Scanner;

import com.selva7378.librarymanagement.LibraryManagement;
import com.selva7378.librarymanagement.librarysetup.LibrarySetupView;
import com.selva7378.librarymanagement.model.Admin;

public class LoginView {

    private LoginModel loginModel;

    public LoginView() {
        loginModel = new LoginModel(this);
    }

    public void init() {
        System.out.println("--- " + LibraryManagement.getInstance().getAppName() + " --- \nversion "
                + LibraryManagement.getInstance().getAppVersion());
        System.out.println("\n\nPlease login to proceed.");
        proceedLogin();
    }

    public void onSuccess() {
        System.out.flush();
        System.out.println(
                "\n\nLogin successful...\n\n ---- welcome to " + LibraryManagement.getInstance().getAppName()
                        + " - v" + LibraryManagement.getInstance().getAppVersion() + "----");
        LibrarySetupView librarySetupView = new LibrarySetupView();
        librarySetupView.init();
    }

    public void onLoginFailed(String alertText) {
        System.out.println(alertText);
        checkForLogin();
    }

    private void checkForLogin() {
        System.out.println("Do you try again? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            proceedLogin();
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n ---- Thanks You ----");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForLogin();
        }
    }

    private void proceedLogin() {
        loginModel.addAdmin(new Admin("selva", "ganesh", "9751590041", "ganesh@gmail.com", "sedapatte"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the user name:");
        String userName = scanner.next();
        System.out.println("Enter the password:");
        String password = scanner.next();
        loginModel.validateUser(userName, password);
    }
}