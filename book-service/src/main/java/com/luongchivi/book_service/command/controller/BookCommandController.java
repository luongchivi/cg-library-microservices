package com.luongchivi.book_service.command.controller;

import com.luongchivi.book_service.command.command.CreateBookCommand;
import com.luongchivi.book_service.command.command.DeleteBookCommand;
import com.luongchivi.book_service.command.command.UpdateBookCommand;
import com.luongchivi.book_service.command.model.BookRequestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookCommandController {
    @Autowired
    private CommandGateway commandGateway;

    @PostMapping()
    public String addBook(@RequestBody BookRequestModel model){
        String uuid = UUID.randomUUID().toString();
        CreateBookCommand command = new CreateBookCommand(
                uuid,
                model.getName(),
                model.getAuthor(),
                true
        );
        System.out.println(uuid);
        commandGateway.sendAndWait(command);
        return "added book successfully";
    }

    @PutMapping()
    public String updateBook(@RequestBody BookRequestModel model){
        UpdateBookCommand command = new UpdateBookCommand(
                model.getBookId(),
                model.getName(),
                model.getAuthor(),
                model.getReady()
        );

        commandGateway.sendAndWait(command);
        return "update book successfully";
    }

    @DeleteMapping("/{bookId}")
    public String deleteBook(@PathVariable String bookId){
        DeleteBookCommand command = new DeleteBookCommand(bookId);
        commandGateway.sendAndWait(command);
        return "delete book successfully";
    }
}
