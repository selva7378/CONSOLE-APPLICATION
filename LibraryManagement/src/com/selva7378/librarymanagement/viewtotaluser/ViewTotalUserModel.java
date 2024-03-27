package com.selva7378.librarymanagement.viewtotaluser;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.User;

import java.util.List;

public class ViewTotalUserModel {
    private ViewTotalUserView viewTotalUserView;

    public ViewTotalUserModel(ViewTotalUserView viewTotalUserView){
        this.viewTotalUserView = viewTotalUserView;
    }


    public void totalViewUser(){
        List<User> users = LibraryDatabase.getInstance().getAllUsers();
        if(users != null){
            viewTotalUserView.onSuccess(users);
        }else{
            viewTotalUserView.onFailure();
        }

    }
}
