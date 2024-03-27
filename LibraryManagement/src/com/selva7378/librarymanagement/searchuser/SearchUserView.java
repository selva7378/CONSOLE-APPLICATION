package com.selva7378.librarymanagement.searchuser;

import com.selva7378.librarymanagement.model.Book;
import com.selva7378.librarymanagement.model.User;

import java.util.List;
import java.util.Scanner;

public class SearchUserView {
    private SearchUserModel searchUserModel;
    public SearchUserView(){
        searchUserModel = new SearchUserModel(this);
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user id : ");
        int userId = scanner.nextInt();
        searchUserModel.searchUserById(userId);
    }


    public void onSuccessByName(User user){
        if(user == null){
            System.out.println("Book not found.");
        }else{
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s",
                    "name", "id", "phone no", "email id", "address");

            System.out.println();

            System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s",
                    user.getName(), user.getId(), user.getPhoneNo(),
                    user.getEmailId(), user.getAddress());
        }


    }

    public void onFailByName(){

    }

}
