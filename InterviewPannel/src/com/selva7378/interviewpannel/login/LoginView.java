package com.selva7378.interviewpannel.login;

import com.selva7378.interviewpannel.InterviewPannel;
import com.selva7378.interviewpannel.receptionistsetup.ReceptionistView;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;

    public LoginView(){
        loginModel = new LoginModel(this);
    }

    public void init(){
        System.out.println(InterviewPannel.getInstance().getAppName() + "\nversion :"
                + InterviewPannel.getInstance().getAppVersion() );
        proceedLogin();
    }

    public void onLoginFailed(String txt){
        System.out.println(txt);
        checkLogin();;

    }

    private void checkLogin(){
        System.out.println("Do yoou try again? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("yes")){
            proceedLogin();
        }else if(choice.equalsIgnoreCase("no")){
            System.out.println("\n ----- Thank You -----");
        }else{
            System.out.println("\nInvalid choice, Please enter valid choice. \n");
            checkLogin();
        }
    }

    public void onLoginSuccess(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("your logined");
        new ReceptionistView().init();
    }
    private void proceedLogin(){
        loginModel.addAdmin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user name :");
        String userName = scanner.nextLine();
        System.out.println("Enter the password :");
        String passWord = scanner.nextLine();
        loginModel.validateUser(userName, passWord);
    }

}
