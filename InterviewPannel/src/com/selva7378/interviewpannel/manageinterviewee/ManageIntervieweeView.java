package com.selva7378.interviewpannel.manageinterviewee;

import com.selva7378.interviewpannel.model.Interviewee;
import com.google.gson.Gson;

import java.util.Scanner;

public class ManageIntervieweeView {

    private ManageIntervieweeModel manageIntervieweeModel;

    public ManageIntervieweeView(){
        manageIntervieweeModel = new ManageIntervieweeModel(this);
    }
    public void init(){
        addIntervieweeMenu();
    }

    public void onIntervieweeAdded(Interviewee interviewee) {
        System.out.println("\n------- Interviewee " + interviewee.getName() + "' added successfully ------- \n");
        checkForAddNewInterviewee();
    }

    public void onIntervieweeExist(Interviewee interviewee) {
        System.out.println("\n------- Interviewee " + interviewee.getName() + "' already exist -------\n");
        checkForAddNewInterviewee();
    }

    private void checkForAddNewInterviewee() {
        System.out.println("\nDo you want to add more interviewee's? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            init();
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n Thanks for adding interviewee's");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewInterviewee();
        }
    }

    private void addIntervieweeMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the interviewee name : ");
        String name = scanner.nextLine();
        if(!manageIntervieweeModel.isValidateName(name)){
            System.out.println("please enter valid name.");
            return;
        }
        System.out.println("Enter the interviewee phone no : ");
        String phoneNo = scanner.nextLine();
        if(!manageIntervieweeModel.isValidatePhoneNumber(phoneNo)){
            System.out.println("please enter valid phone number.");
            return;
        }
        System.out.println("Enter the interviewee email id : ");
        String email = scanner.nextLine();
        if(!manageIntervieweeModel.isValidateEmailId(email)){
            System.out.println("please enter valid email.");
            return;
        }
        System.out.println("Enter the interviewee address : ");
        String address = scanner.nextLine();
        manageIntervieweeModel.addInterviewee(new Interviewee(name, phoneNo, email, address));
    }




}
