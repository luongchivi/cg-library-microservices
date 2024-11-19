package com.luongchivi.book_service.command.data;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private String bookId;
    private String name;
    private String author;
    private boolean isReady;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }
}
