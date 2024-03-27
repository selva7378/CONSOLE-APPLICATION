package com.selva7378.librarymanagement.searchbook;

import com.selva7378.librarymanagement.model.Book;
import com.selva7378.librarymanagement.model.User;

import java.util.List;
import java.util.Scanner;

public class SearchBookView {
    private SearchBookModel searchBookModel;
    public SearchBookView(){
        searchBookModel = new SearchBookModel(this);
    }

    public void initSearch(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book id : ");
        int bookid = scanner.nextInt();
        searchBookModel.searchBookById(bookid);
    }

    public void onSuccessByName(Book book){
        if(book == null){
            System.out.println("Book not found.");
        }else{
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                    "name", "id", "author", "publication", "edition",
                    "genre", "available count", "volume");

            System.out.println();

            System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s|%-20d|%-20d",
                    book.getName(), book.getId(), book.getAuthor(),
                    book.getPublication(), book.getEdition(), book.getGenre(),
                    book.getAvailableCount(), book.getVolume());
        }
    }

}
