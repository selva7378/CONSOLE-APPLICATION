package com.selva7378.librarymanagement.submitbook;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;
import com.selva7378.librarymanagement.model.Book;
import com.selva7378.librarymanagement.model.IssueBook;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class SubmitBookModel {
    private SubmitBookView submitBookView;

    public SubmitBookModel(SubmitBookView submitBookView){
        this.submitBookView = submitBookView;
    }

    public void validateUserBookIdIssuedBook(int userId, int bookId, LocalDate submitDate){
        IssueBook issueBook = LibraryDatabase.getInstance().validateUserBookIdIssuedBook(userId, bookId);
        if(issueBook == null){
            submitBookView.onFailure();
        }else{
            String submitDateStr = submitDate.toString();
            String issueDateStr = issueBook.getIssuedDate();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            try {
                // Parse the user input string into a LocalDate object
                LocalDate localIssueDate = LocalDate.parse(issueDateStr, formatter);
                long daysBetween = ChronoUnit.DAYS.between(localIssueDate,submitDate);
                submitBookView.onSuccess(userId, bookId, daysBetween );
            } catch (Exception e) {
                System.out.println("Invalid date format. Please enter date in yyyy-MM-dd format.");
            }

        }
    }

    public void removeIssuedBook(int userId, int bookId){
        LibraryDatabase.getInstance().removeIssuedBook(userId,bookId);
    }

    public Book searchBooksById(int bookId){
        return LibraryDatabase.getInstance().searchBooksById(bookId);
    }
}
