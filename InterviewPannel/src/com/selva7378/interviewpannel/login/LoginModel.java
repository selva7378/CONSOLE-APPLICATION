package com.selva7378.interviewpannel.login;

import com.selva7378.interviewpannel.datalayer.InterviewPannelDatabase;
import com.selva7378.interviewpannel.model.Admin;

public class LoginModel {
    private LoginView loginView;

    LoginModel(LoginView loginView){
        this.loginView = loginView;
    }

    public void validateUser(String userName, String password){
        if(isValidUserName(userName)){
            if(isValidPassword(password)){
                loginView.onLoginSuccess();
            }else{
                loginView.onLoginFailed("Invalid password");
            }
        }else{
            loginView.onLoginFailed("Invalid User Name");
        }
    }

    private boolean isValidUserName(String userName){
        return userName.equals(InterviewPannelDatabase.getInstance().getAdmin().getName());
    }

    private boolean isValidPassword(String password){
        return password.equals(InterviewPannelDatabase.getInstance().getAdmin().getPassword());
    }

    public void addAdmin(){
        InterviewPannelDatabase.getInstance().addAdmin(new Admin("selva", "ganesh", "9751590041", "selva@gmail.com", "sedapatti"));
    }


}
