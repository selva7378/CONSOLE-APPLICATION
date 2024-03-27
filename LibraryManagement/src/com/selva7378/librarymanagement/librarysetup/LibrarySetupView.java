package com.selva7378.librarymanagement.librarysetup;

import com.selva7378.librarymanagement.LibraryManagement;
import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.issuebook.IssueBookView;
import com.selva7378.librarymanagement.login.LoginView;
import com.selva7378.librarymanagement.managebook.ManageBookView;
import com.selva7378.librarymanagement.manageuser.ManageUserView;
import com.selva7378.librarymanagement.model.IssueBook;
import com.selva7378.librarymanagement.model.Library;
import com.selva7378.librarymanagement.searchbook.SearchBookView;
import com.selva7378.librarymanagement.searchuser.SearchUserView;
import com.selva7378.librarymanagement.submitbook.SubmitBookView;
import com.selva7378.librarymanagement.viewtotalbook.ViewTotalBookView;
import com.selva7378.librarymanagement.viewtotaluser.ViewTotalUserView;

import java.util.Scanner;

public class LibrarySetupView {


    private LibrarySetupModel librarySetupModel;


    public LibrarySetupView() {
        librarySetupModel = new LibrarySetupModel(this);
    }

    public void init() {
        librarySetupModel.startSetup();
    }

    public void onSetupComplete(Library library) {
        System.out.println("\nLibrary setup completed\n");
        System.out.println("\nCurrent Library Name - " + library.getLibraryName());
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\n 1. Book Menu");
            System.out.println("\n 2. User Menu");
            System.out.println("\n 3. Log Out");
            System.out.println("\n 4. Exit");
            int choice = scanner.nextInt();
            if(choice == 1) {
                bookMenu();
            }else if(choice == 2){
                userMenu();
            }else if(choice == 3){
                System.out.println("\n-- You are logged out successfully -- \n\n");
                new LoginView().init();
            }else{
                LibraryDatabase.getInstance().saveData();
                System.out.println("Application Closed");
                System.exit(0);
            }
        }
    }
    
    public void bookMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n 1. Add Book\n 2. Remove Book \n 3. Search Book" +
                            " \n 4. View Total book \n 5. issue book \n 6. submit book" +
                            " \n 0. Exit \n Enter your Choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    new ManageBookView().init(1);
                    break;
                case 2:
                    new ManageBookView().init(2);
                    break;
                case 3:
                    new SearchBookView().initSearch();
                    break;
                case 4:
                    new ViewTotalBookView().init();
                    break;
                case 5:
                     new IssueBookView().init();
                    break;
                case 6:
                    new SubmitBookView().init();
                    break;
                case 0:
                    System.out.println("\n-- Thanks for using " + LibraryManagement.getInstance().getAppName() + " --");
                    return; // Exit from the application
                default:
                    System.out.println("\nPlease Enter valid choice\n");
            }
        }
    }
    
    public void userMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "\n 1. Add user\n 2. Remove user \n 3. Search User" +
                            " \n 4. View Total user \n 0. Exit \n Enter your Choice:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    new ManageUserView().init(1);
                    break;
                case 2:
                    new ManageUserView().init(2);
                    break;
                case 3:
                    new SearchUserView().init();
                    break;
                case 4:
                    new ViewTotalUserView().init();
                    break;
                case 0:
                    System.out.println("\n-- Thanks for using " + LibraryManagement.getInstance().getAppName() + " --");
                    return; // Exit from the application
                default:
                    System.out.println("\nPlease Enter valid choice\n");
            }
        }
    }
    public void showAlert(String alert) {
        System.out.println(alert);
        initiateSetup();
    }

    public void initiateSetup() {
        String libraryName = "", libraryPhoneNo = "", libraryEmail = "", libraryAddress = "";
        boolean run = true;
        do{
            System.out.println("\n\nEnter library details:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nEnter library name:");
            libraryName = scanner.nextLine();
            if(!librarySetupModel.isValidateName(libraryName)){
                System.out.println("please enter proper library name.");
                continue;
            }
            System.out.println("Enter phone no : ");
            libraryPhoneNo = scanner.nextLine();
            if(!librarySetupModel.isValidatePhoneNumber(libraryPhoneNo)){
                System.out.println("please enter valid phone number.");
                continue;
            }
            System.out.println("\nEnter library email:");
            libraryEmail = scanner.nextLine();
            if(!librarySetupModel.isValidateEmailId(libraryEmail)){
                System.out.println("please enter valid email.");
                continue;
            }
            System.out.println("Enter library address:");
            libraryAddress = scanner.nextLine();
//            if(!librarySetupModel.isValidateAddress(libraryAddress)){
//                System.out.println("please enter valid address.");
//                continue;
//            }
            run = false;
        }while(run);

        librarySetupModel.createLibrary(new Library(libraryName, libraryPhoneNo, libraryEmail, libraryAddress));
    }
}
