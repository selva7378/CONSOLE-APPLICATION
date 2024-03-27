package com.selva7378.librarymanagement.managebook;

import com.selva7378.librarymanagement.model.Book;

import java.util.Scanner;

public class ManageBookView {

    private ManageBookModel manageBookModel;

    public ManageBookView() {
        manageBookModel = new ManageBookModel(this);
    }

    public void init(int n) {
        if(n == 1){
            addBookMenu();
        }else if(n == 2){
            removeBookMenu();
        }
    }

    public void removeBookMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter book id: ");
        int id = scanner.nextInt();
        manageBookModel.removeBook(id);
    }

    public void addBookMenu(){
        System.out.println("\nEnter book details: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter book name:");
        String bookName = scanner.nextLine();
        if(!manageBookModel.isValidateName(bookName)){
            System.out.println("please enter valid book name.");
            return;
        }
        System.out.println("\nEnter book author:");
        String authorName = scanner.nextLine();
        if(!manageBookModel.isValidateName(authorName)){
            System.out.println("please enter valid author name.");
            return;
        }
        System.out.println("Enter book publication in the format : yyyy-mm-dd");
        String publication = scanner.nextLine();
        if(!manageBookModel.isValidatePublication(publication)){
            System.out.println("please enter valid publication.");
            return;
        }
        System.out.println("Enter book edition:");
        int edition = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter book genre:");
        String genre = scanner.nextLine();
        if(!manageBookModel.isValidateName(genre)){
            System.out.println("please enter valid book genre.");
            return;
        }
        System.out.println("Enter available count:");
        int availableCount = scanner.nextInt();
        System.out.println("Enter volume:");
        int volume = scanner.nextInt();
        manageBookModel.addNewBook(new Book(bookName, authorName, publication, edition, genre, availableCount, volume));
    }

    public void showLibraryName(String libraryName) {
        System.out.println("Current Library Name - " + libraryName);
    }

    public void onBookAdded(Book book) {
        System.out.println("\n------- Book '" + book.getName() + "' added successfully ------- \n");
        checkForAddNewBook();
    }

    public void onBookExist(Book book) {
        System.out.println("\n------- Book '" + book.getName() + "' already exist -------\n");
        checkForAddNewBook();
    }

    private void checkForAddNewBook() {
        System.out.println("\nDo you want to add more books? \nType Yes/No");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            init(1);
        } else if (choice.equalsIgnoreCase("no")) {
            System.out.println("\n Thanks for adding books");
        } else {
            System.out.println("\nInvalid choice, Please enter valid choice.\n");
            checkForAddNewBook();
        }
    }

    public void onSuccess(Book book){
        System.out.println("Below book removed : ");
        System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s",
                "name", "id", "author", "publication", "edition",
                "genre", "available count", "volume");

        System.out.println();

        System.out.printf("|%-20s|%-20d|%-20s|%-20s|%-20s|%-20s|%-20d|%-20d",
                book.getName(), book.getId(), book.getAuthor(),
                book.getPublication(), book.getEdition(), book.getGenre(),
                book.getAvailableCount(), book.getVolume());
    }

    public void onFailure(){
        System.out.println("Mentioned book is not available in library.");
    }

}
