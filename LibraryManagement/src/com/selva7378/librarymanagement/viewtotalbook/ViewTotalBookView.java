package com.selva7378.librarymanagement.viewtotalbook;

import com.selva7378.librarymanagement.model.Book;

import java.util.List;

public class ViewTotalBookView {
    private ViewTotalBookModel viewTotalBookModel;

    public ViewTotalBookView(){
        viewTotalBookModel = new ViewTotalBookModel(this);
    }

    public void init(){
        viewTotalBookModel.totalViewBook();
    }

    public void onSuccess(List<Book> totalBookList){
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                          "name", "id", "author", "publication", "edition",
                          "genre", "available count", "volume");
        System.out.println();
        for(Book book: totalBookList){
            System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s|%-20d|%-20d",
                              book.getName(), book.getId(), book.getAuthor(),
                              book.getPublication(), book.getEdition(), book.getGenre(),
                              book.getAvailableCount(), book.getVolume());
            System.out.println();
        }
    }

    public void onFailure(){
        System.out.println("Sorry No books available in the library.");
    }
}
