package com.selva7378.librarymanagement.model;

import com.selva7378.librarymanagement.datalayer.LibraryDatabase;

public class Book {

    private String name;
    private int id;
    private String author;
    private String publication;
    private int edition;
    private String genre;
    private int availableCount;
    private int volume;

    public Book(String name, String author, String publication, int edition, String genre, int availableCount, int volume) {
        this.name = name;
        this.id = LibraryDatabase.getInstance().bookListSize()+1;
        this.author = author;
        this.publication = publication;
        this.edition = edition;
        this.genre = genre;
        this.availableCount = availableCount;
        this.volume = volume;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }


}

