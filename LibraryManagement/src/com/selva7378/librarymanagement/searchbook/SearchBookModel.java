package com.selva7378.librarymanagement.searchbook;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;

public class SearchBookModel {

    private SearchBookView searchBookView;

    public SearchBookModel(SearchBookView searchBookView){
        this.searchBookView = searchBookView;
    }

    public void searchBookById(int userId){
        searchBookView.onSuccessByName(LibraryDatabase.getInstance().searchBooksById(userId));
    }
}
