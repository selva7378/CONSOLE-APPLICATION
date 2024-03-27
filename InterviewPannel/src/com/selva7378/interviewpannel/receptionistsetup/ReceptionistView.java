package com.selva7378.interviewpannel.receptionistsetup;

import com.selva7378.interviewpannel.datalayer.InterviewPannelDatabase;
import com.selva7378.interviewpannel.login.LoginView;
import com.selva7378.interviewpannel.manageinterviewee.ManageIntervieweeView;
import com.selva7378.interviewpannel.model.Interviewee;

import java.util.Scanner;

public class ReceptionistView {
    private ReceptionistModel receptionistModel;

    public ReceptionistView(){
        receptionistModel = new ReceptionistModel(this);
    }

    public void init(){
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
        mainMenu();
    }
    private void proceedLogin(){
        receptionistModel.addReceptionist();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the receptionist name :");
        String userName = scanner.nextLine();
        System.out.println("Enter the receptionist password :");
        String passWord = scanner.nextLine();
        receptionistModel.validateUser(userName, passWord);
    }

    private void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        l1: do{
            System.out.println("1. add interviewee :");
            System.out.println("2. Interviewee status :");
            System.out.println("3. Completed Candidates :");
            System.out.println("4. Finish the current interview :");
            System.out.println("5. Total Candidates :");
            System.out.println("6. Log out :");
            System.out.println("7. exit : ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    new ManageIntervieweeView().init();
                    break;
                case 2:
                    intervieweeStatus();
                    break;
                case 3:
                    completedCandidates();
                    break;
                case 4:
                    finishInterview();
                    break;
                case 5:
                    totalCandidates();
                    break;
                case 6:
                    new LoginView().init();
                case 7:
                    InterviewPannelDatabase.getInstance().saveData();
                    System.out.println("Application closed");
                    break l1;
            }
        }while(true);
    }

    public void totalCandidates(){
        int number = 1;
        if(receptionistModel.isIntervieweesListEmpty() && receptionistModel.isCompletedIntervieweeslistEmpty()){
            System.out.println("still interview not started.");
        }else{
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                    "name", "id", "phone no", "email id", "address", "interview status");
            if(!receptionistModel.isIntervieweesListEmpty()){

                for(Interviewee interviewee: receptionistModel.getInterviewees()){
                    if(number++ == 1){

                        System.out.println();

                        System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s",
                                interviewee.getName(), interviewee.getId(), interviewee.getPhoneNo(),
                                interviewee.getEmailId(), interviewee.getAddress(), "Interview Going");
                    }else{
                        System.out.println();

                        System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s",
                                interviewee.getName(), interviewee.getId(), interviewee.getPhoneNo(),
                                interviewee.getEmailId(), interviewee.getAddress(), "Waiting");
                    }
                }
            }

            if(!receptionistModel.isCompletedIntervieweeslistEmpty()){
                System.out.println();
                for(Interviewee interviewee: receptionistModel.getCompletedInterviewees()){

                    System.out.println();

                    System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s",
                            interviewee.getName(), interviewee.getId(), interviewee.getPhoneNo(),
                            interviewee.getEmailId(), interviewee.getAddress(), "completed");
                }
            }
            System.out.println();
        }

    }

    public void intervieweeStatus(){
        int number = 1;
        if(receptionistModel.isIntervieweesListEmpty() && receptionistModel.isCompletedIntervieweeslistEmpty()){
            System.out.println("still interview not started.");
        }
        if(receptionistModel.isIntervieweesListEmpty() && !receptionistModel.isCompletedIntervieweeslistEmpty()){
            System.out.println("Waiting for next candidate.");
        }

        if(!receptionistModel.isIntervieweesListEmpty()){
            for(Interviewee interviewee: receptionistModel.getInterviewees()){
                if(number++ == 1){
//                    System.out.print(number++ + ". " + interviewee.getName() + "(interview going)" + " ");
                    System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                            "name", "id", "phone no", "email id", "address", "interview status");

                    System.out.println();

                    System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s",
                            interviewee.getName(), interviewee.getId(), interviewee.getPhoneNo(),
                            interviewee.getEmailId(), interviewee.getAddress(), "Interview Going");
                }else{
                    // System.out.print(number++ + ". " + interviewee.getName() + "(waiting)" + " ");
                    System.out.println();

                    System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s",
                            interviewee.getName(), interviewee.getId(), interviewee.getPhoneNo(),
                            interviewee.getEmailId(), interviewee.getAddress(), "Waiting");
                }

            }
            System.out.println();
        }
    }

    public void finishInterview(){
        if(receptionistModel.isIntervieweesListEmpty()){
            System.out.println("no interview is ongoing.");
        }else{
            System.out.println( "Interview is over for " + receptionistModel.markOnGoingInterviewCompleted());
        }
    }

    public void completedCandidates(){
        int number = 1;
        if(!receptionistModel.isCompletedIntervieweeslistEmpty()){
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                    "name", "id", "phone no", "email id", "address", "interview status");
            for(Interviewee interviewee: receptionistModel.getCompletedInterviewees()){
//                System.out.println(number++ + ". " + interviewee.getName() + "(completed)" + " ");

                System.out.println();

                System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s",
                        interviewee.getName(), interviewee.getId(), interviewee.getPhoneNo(),
                        interviewee.getEmailId(), interviewee.getAddress(), "completed");
            }
        }else{
            System.out.println("Interview not completed for any one.");
        }
        System.out.println();
    }
}
