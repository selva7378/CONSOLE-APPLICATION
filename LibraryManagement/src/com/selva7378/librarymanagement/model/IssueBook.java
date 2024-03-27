package com.selva7378.librarymanagement.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class IssueBook {
    private int bookId;
    private int userId;
    private String issuedDate;
    private String dueDate;



    public String getIssuedDate() {
        return issuedDate;
    }

    public String getDueDate() {
        return dueDate;
    }



    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public IssueBook(int bookId, int userId){
        this.bookId = bookId;
        this.userId = userId;


        LocalDate localDueDate = LocalDate.now().plusDays(30);
        LocalDate localIssueDate = LocalDate.now();
        issuedDate = localIssueDate.toString();
        dueDate = localDueDate.toString();
    }


}

