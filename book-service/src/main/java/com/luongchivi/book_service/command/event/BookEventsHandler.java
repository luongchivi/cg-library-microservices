package com.luongchivi.book_service.command.event;

import com.luongchivi.book_service.command.data.Book;
import com.luongchivi.book_service.command.data.BookRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookEventsHandler {
    @Autowired
    BookRepository bookRepository;

    @EventHandler
    public void on(BookCreateEvent event) {
        Book book = new Book();
        BeanUtils.copyProperties(event, book);
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookUpdateEvent event) {
        Book book = bookRepository.getReferenceById(event.getBookId());
        book.setAuthor(event.getAuthor());
        book.setName(event.getName());
        book.setReady(event.getReady());
        bookRepository.save(book);
    }

    @EventHandler
    public void on(BookDeleteEvent event) {
        bookRepository.deleteById(event.getBookId());
    }
}
