package com.selva7378.interviewpannel.receptionistsetup;

import com.selva7378.interviewpannel.datalayer.InterviewPannelDatabase;
import com.selva7378.interviewpannel.model.Interviewee;
import com.selva7378.interviewpannel.model.Receptionist;

import java.util.Queue;

public class ReceptionistModel {
    private ReceptionistView receptionistView;

    ReceptionistModel(ReceptionistView receptionistView){
        this.receptionistView = receptionistView;
    }

    public void init(){

    }
    public void validateUser(String userName, String password){
        if(isValidUserName(userName)){
            if(isValidPassword(password)){
                receptionistView.onLoginSuccess();
            }else{
                receptionistView.onLoginFailed("Invalid password");
            }
        }else{
            receptionistView.onLoginFailed("Invalid User Name");
        }
    }

    private boolean isValidUserName(String userName){
        return userName.equals(InterviewPannelDatabase.getInstance().getReceptionist().getName());
    }

    private boolean isValidPassword(String password){
        return password.equals(InterviewPannelDatabase.getInstance().getReceptionist().getPassword());
    }

    public boolean isIntervieweesListEmpty(){
        return InterviewPannelDatabase.getInstance().isIntervieweesListEmpty();
    }

    public boolean isCompletedIntervieweeslistEmpty(){
        return InterviewPannelDatabase.getInstance().isCompletedIntervieweesListEmpty();
    }

    public Queue<Interviewee> getInterviewees(){
        return InterviewPannelDatabase.getInstance().getInterviewees();
    }

    public Queue<Interviewee> getCompletedInterviewees(){
        return InterviewPannelDatabase.getInstance().getCompletedInterviewees();
    }

    public  boolean intervieweesIsEmpty(){
        return InterviewPannelDatabase.getInstance().isIntervieweesListEmpty();
    }

    public String markOnGoingInterviewCompleted(){
        return InterviewPannelDatabase.getInstance().markOnGoingInterviewCompleted();
    }

    public void addReceptionist(){
        InterviewPannelDatabase.getInstance().addReceptionist(new Receptionist("selva", "ganesh", "9751590041", "selvaganesh7378@gmail.com", "sedapatti"));
    }



}
