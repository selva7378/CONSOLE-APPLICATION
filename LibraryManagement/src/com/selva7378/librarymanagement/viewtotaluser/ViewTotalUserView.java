package com.selva7378.librarymanagement.viewtotaluser;

import com.selva7378.librarymanagement.model.Book;
import com.selva7378.librarymanagement.model.User;

import java.util.List;

public class ViewTotalUserView {
    private ViewTotalUserModel viewTotalUserModel;

    public ViewTotalUserView(){
        viewTotalUserModel = new ViewTotalUserModel(this);
    }

    public void init(){
        viewTotalUserModel.totalViewUser();
    }

    public void onSuccess(List<User> totalUserList){
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s",
                "name", "id", "phone no", "email id", "address");

        System.out.println();
        for(User user: totalUserList){
            System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s",
                    user.getName(), user.getId(), user.getPhoneNo(),
                    user.getEmailId(), user.getAddress());
            System.out.println();
        }
    }

    public void onFailure(){
        System.out.println("Sorry No user data available in the library.");
    }
}
