package com.selva7378.librarymanagement.submitbook;

import com.selva7378.librarymanagement.model.Book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class SubmitBookView {
    private SubmitBookModel submitBookModel;

    public SubmitBookView(){
        submitBookModel = new SubmitBookModel(this);
    }

    public void init(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the user id : ");
        int userId = scanner.nextInt();
        System.out.println("Enter the book id : ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the submission date in the format:" +
                " \"yyyy-MM-dd\" ");
        String dateTime = scanner.nextLine();
        // Define the date format expected from the user
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(dateTime);;
        submitBookModel.validateUserBookIdIssuedBook(userId,bookId, date);
    }

    public void onFailure(){
        System.out.println("Mentioned book is not issued to you.");
    }

    public void onSuccess(int userId, int bookId, long days){
        if(days >= 0 && days <= 30){
            System.out.println("Below book is submited : ");
            submitBookModel.removeIssuedBook(userId,bookId);
            Book book = submitBookModel.searchBooksById(userId);
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                    "name", "id", "author", "publication", "edition",
                    "genre", "available count", "volume");

            System.out.println();

            System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s|%-20d|%-20d",
                    book.getName(), book.getId(), book.getAuthor(),
                    book.getPublication(), book.getEdition(), book.getGenre(),
                    book.getAvailableCount(), book.getVolume());
        } else if (days > 30) {
            System.out.println("Below book is submited but overdued : ");
            submitBookModel.removeIssuedBook(userId,bookId);
            Book book = submitBookModel.searchBooksById(userId);
            System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                    "name", "id", "author", "publication", "edition",
                    "genre", "available count", "volume");

            System.out.println();

            System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s|%-20d|%-20d",
                    book.getName(), book.getId(), book.getAuthor(),
                    book.getPublication(), book.getEdition(), book.getGenre(),
                    book.getAvailableCount(), book.getVolume());
        }else{
            System.out.println("Entered date is wrong.");
        }
    }
}
