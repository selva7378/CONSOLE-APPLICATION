package com.selva7378.librarymanagement.issuebook;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.Book;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class IssueBookView {
    private IssueBookModel issueBookModel;

    public IssueBookView(){
        issueBookModel = new IssueBookModel(this);
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user id : ");
        int userId  = scanner.nextInt();
        System.out.println("Enter the book id : ");
        int bookId = scanner.nextInt();
        issueBookModel.validateUserBook(userId, bookId);
    }

    public void print(String str){
        System.out.println(str);
    }

    public void onSuccess(Book book, String userName, String localIssuedDate, String localDueDate){
        System.out.println("Below book is issued to the user " + userName + " on " + localIssuedDate + "   |Due date :" + localDueDate);
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                "name", "id", "author", "publication", "edition",
                "genre", "available count", "volume");
        System.out.println();

        System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s|%-20d|%-20d",
                book.getName(), book.getId(), book.getAuthor(),
                book.getPublication(), book.getEdition(), book.getGenre(),
                book.getAvailableCount(), book.getVolume());
        System.out.println();
    }
}
