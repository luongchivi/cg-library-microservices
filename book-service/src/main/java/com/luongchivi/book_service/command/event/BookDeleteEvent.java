package com.luongchivi.book_service.command.event;

public class BookDeleteEvent {
    private String bookId;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
