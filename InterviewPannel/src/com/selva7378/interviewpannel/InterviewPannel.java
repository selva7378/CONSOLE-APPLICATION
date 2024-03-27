package com.selva7378.interviewpannel;

import com.selva7378.interviewpannel.datalayer.InterviewPannelDatabase;
import com.selva7378.interviewpannel.login.LoginView;

public class InterviewPannel {
    private static InterviewPannel interviewPannel;

    private String appName = "Interview Pannel";
    private String appVersion = "0.0.1";

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    private InterviewPannel(){

    }

    private void create(){
        InterviewPannelDatabase.getInstance().loadData();
        LoginView loginView = new LoginView();
        loginView.init();
    }

    public static InterviewPannel getInstance(){
        if(interviewPannel == null){
            interviewPannel = new InterviewPannel();
        }
        return interviewPannel;
    }

    public static void main(String[] args) {
        InterviewPannel.getInstance().create();
    }
}
