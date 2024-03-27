package com.selva7378.librarymanagement.datalayer;

import com.selva7378.librarymanagement.model.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {

    private static LibraryDatabase libraryDatabase;
    private static final String FILE_PATH = "/Users/selvaganesh/Downloads/zoho/zoho_tasks/consoleApplication/LibraryManagement/src/com/selva7378/librarymanagement/datalayer/data.json";
    private static Gson gson = new Gson();
    private Library library;

    private Admin admin;
    private List<Book> bookList = new ArrayList<Book>();
    private List<IssueBook> issuedBookList = new ArrayList<IssueBook>();
    private List<User> userList = new ArrayList<User>();

    public static LibraryDatabase getInstance() {

        if (libraryDatabase == null) {
            libraryDatabase = new LibraryDatabase();
        }
        return libraryDatabase;
    }

    public void saveData() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean loadData() {
        File file=new File(FILE_PATH);
        if (file.length()==0)
            return false;
        try (FileReader reader = new FileReader(FILE_PATH)) {
            LibraryDatabase database = gson.fromJson(reader, LibraryDatabase.class);
//			System.out.println("Data loaded successfully.");
            library = database.library;
            admin = database.admin;
            bookList = database.bookList;
            issuedBookList = database.issuedBookList;
            userList = database.userList;
        } catch (IOException e) {
            e.printStackTrace();
//			System.err.println("Failed to load data: " + e.getMessage());
        }
        return false;
    }
    public Library getLibrary() {
        return library;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void addAdmin(Admin admin){
        this.admin = admin;
    }

    public Library insertLibrary(Library library) {
        this.library = library;
        return this.library;
    }

    public List<Book> getAllBooks() {
        if(bookList.size() == 0){
            return null;
        }else
        return bookList;
    }

    public int bookListSize(){
        return bookList.size();
    }

    public int userListSize(){
        return userList.size();
    }
    public List<User> getAllUsers() {
        if(userList.size() == 0) return  null;
        else return userList;
    }

    public User getUser(int userId){
        User issuedUser = null;
        for(User user: userList){
            if(user.getId() == userId){
                issuedUser = user;
                break;
            }
        }
        return issuedUser;
    }

    public Book getBook(int bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Book searchBooksById(int bookId) {
        for (Book book : bookList) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public User searchUserById(int userId) {
        for (User user : userList) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public boolean insertBook(Book book) {
            bookList.add(book);
            return true;
    }

    public Book removeBook(int id){
        Book removedBook = null;
        for(Book book: bookList){
            if(book.getId() == id){
                removedBook = book;
                bookList.remove(book);
                break;
            }
        }
        return removedBook;
    }



    public boolean insertUser(User user) {
            userList.add(user);
            return true;
    }

    public User removeUser(int id){
        User removedUser = null;
        for(User user: userList){
            if(user.getId() == id){
                removedUser = user;

                userList.remove(user);
                break;
            }
        }
        return removedUser;
    }

    public boolean isValidUser(int userId){
        boolean validUser = false;
        for(User user: userList){
            if(user.getId() == userId){
                validUser = true;
                break;
            }
        }
        return validUser;
    }

    public boolean isValidBook(int bookId){
        boolean validBook = false;
        for(Book book: bookList){
            if(book.getId() == bookId){
                validBook = true;
                break;
            }
        }
        return validBook;
    }

    public void addIssueBook(IssueBook issueBook){
        issuedBookList.add(issueBook);
    }

    public IssueBook validateUserBookIdIssuedBook(int userId,int bookId){
        IssueBook issuedBookr = null;
        for(IssueBook issueBook: issuedBookList){
            if(issueBook.getBookId() == bookId && issueBook.getUserId() == userId){
                issuedBookr = issueBook;
            }
        }
        return issuedBookr;
    }

    public void removeIssuedBook(int userId, int bookId){
        for(IssueBook issueBook: issuedBookList){
            if(issueBook.getBookId() == bookId && issueBook.getUserId() == userId){
                issuedBookList.remove(issueBook);
                break;
            }
        }
        for(Book book: bookList){
            if(bookId == book.getId()){
                book.setAvailableCount(book.getAvailableCount()+1);
                break;
            }
        }
    }
}
