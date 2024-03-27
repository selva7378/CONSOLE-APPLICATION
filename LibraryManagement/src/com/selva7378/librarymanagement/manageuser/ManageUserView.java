package com.selva7378.librarymanagement.manageuser;

import com.selva7378.librarymanagement.model.User;
import com.selva7378.librarymanagement.regexvalidate.RegexValidate;

import java.util.Scanner;

public class ManageUserView {

    private ManageUserModel manageUserModel;

    public ManageUserView() {
        manageUserModel = new ManageUserModel(this);
    }

    public void init(int n) {
        if(n == 1){
            addUserMenu();
        }else if(n == 2){
            removeUserMenu();
        }
    }

    public void removeUserMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter user id: ");
        int id = scanner.nextInt();
        manageUserModel.removeUser(id);
    }
    public void addUserMenu(){
        System.out.println("Enter the following user Details: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter user name:");
        String name = scanner.nextLine();
        if(!manageUserModel.isValidateName(name)){
            System.out.println("please enter valid name.");
            return;
        }
        System.out.println("\nEnter user phone number : ");
        String phoneNumber = scanner.nextLine();
        if(!manageUserModel.isValidatePhoneNumber(phoneNumber)){
            System.out.println("please enter valid phone number.");
            return;
        }
        System.out.println("\nEnter user email:");
        String email = scanner.nextLine();
        if(!manageUserModel.isValidateEmailId(email)){
            System.out.println("please enter valid email.");
            return;
        }
        System.out.println("\nEnter user address : ");
        String address = scanner.nextLine();
        manageUserModel.addNewUser(new User(name, phoneNumber, email, address));
    }

    public void showLibraryName(String libraryName) {
        System.out.println("Current Library Name - " + libraryName);
    }

    public void onUserAdded(User user) {
        System.out.println("\n------- User '" + user.getName() + "' added successfully ------- \n");
        checkForAddNewUser();
    }

    public void onUserExist(User user) {
        System.out.println("\n------- User '" + user.getName() + "' already exist -------\n");
        checkForAddNewUser();
    }

    private void checkForAddNewUser() {
        System.out.println("Do you want to add more users? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            init(1);
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n Thanks for adding users");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewUser();
        }
    }

    public void onSuccess(User user) {
        System.out.println("Below user removed.");
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s",
                "name", "id", "phone no", "email id", "address");

        System.out.println();
        System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s",
                user.getName(), user.getId(), user.getPhoneNo(),
                user.getEmailId(), user.getAddress());
    }
    public void onFailure(){
        System.out.println("Mentioned user is not available in library.");
    }
}
