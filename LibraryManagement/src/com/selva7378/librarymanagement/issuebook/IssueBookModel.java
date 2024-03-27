package com.selva7378.librarymanagement.issuebook;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.Book;
import com.selva7378.librarymanagement.model.IssueBook;

public class IssueBookModel {
    private IssueBookView issueBookView;

    public IssueBookModel(IssueBookView issueBookView){
        this.issueBookView = issueBookView;
    }

    public void validateUserBook(int userId, int bookId){
        if(isValidUser(userId) && isValidBook(bookId)){
            addIssueBook(userId, bookId);
        }else if(isValidUser(userId)){
            issueBookView.print("Book id is invalid");
        }else if(isValidBook(bookId)){
            issueBookView.print("User id is invalid");
        }else{
            issueBookView.print("Book id and User id is invalid");
        }
    }

    public void addIssueBook(int userId, int bookId){
        Book book = LibraryDatabase.getInstance().searchBooksById(bookId);
        if(book != null && book.getAvailableCount() != 0){
            book.setAvailableCount(book.getAvailableCount()-1);
            IssueBook issueBook = new IssueBook(userId, bookId);
            LibraryDatabase.getInstance().addIssueBook(issueBook);
            issueBookView.onSuccess(book, LibraryDatabase.getInstance().getUser(userId).getName()
                    ,issueBook.getIssuedDate(), issueBook.getDueDate());
        }else if(book != null && book.getAvailableCount() == 0){
            issueBookView.print("Sorry Book available count is " + book.getAvailableCount());
        }else{
            issueBookView.print("Book not available.");
        }
    }

    public boolean isValidUser(int userId){
        return LibraryDatabase.getInstance().isValidUser(userId);
    }

    public boolean isValidBook(int bookId){
        return LibraryDatabase.getInstance().isValidBook(bookId);
    }
}
