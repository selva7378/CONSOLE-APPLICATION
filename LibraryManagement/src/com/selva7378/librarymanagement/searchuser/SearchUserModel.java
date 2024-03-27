package com.selva7378.librarymanagement.searchuser;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;

public class SearchUserModel {

    private SearchUserView searchUserView;

    public SearchUserModel(SearchUserView searchUserView){
        this.searchUserView = searchUserView;
    }

    public void searchUserById(int userId){
        searchUserView.onSuccessByName(LibraryDatabase.getInstance().searchUserById(userId));
    }
}
