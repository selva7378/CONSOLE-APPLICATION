package com.selva7378.librarymanagement.viewtotalbook;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.Book;

import java.util.List;

public class ViewTotalBookModel {
    private ViewTotalBookView viewTotalBookView;

    public ViewTotalBookModel(ViewTotalBookView viewTotalBookView){
        this.viewTotalBookView = viewTotalBookView;
    }


    public void totalViewBook(){
        List<Book> books = LibraryDatabase.getInstance().getAllBooks();
        if(books != null){
            viewTotalBookView.onSuccess(books);
        }else{
            viewTotalBookView.onFailure();
        }

    }
}
