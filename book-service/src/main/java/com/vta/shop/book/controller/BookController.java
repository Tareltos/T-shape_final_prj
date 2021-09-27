package com.vta.shop.book.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vta.shop.book.service.Book;
import com.vta.shop.book.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {

        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {

        return bookService.getById(id).orElse(null);
    }

    @GetMapping
    public List<Book> getAll() {

        return bookService.getAll();
    }

    @PostMapping
    public Book create(@Valid @RequestBody Book book) {

        return bookService.create(Collections.singletonList(book)).stream().findFirst().orElse(null);
    }

    @PostMapping("/batch")
    public List<Book> create(@Valid @RequestBody List<Book> books) {

        return bookService.create(books);
    }


    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @Valid @RequestBody Book book) {

        Assert.isTrue(Objects.equals(id, book.getId()), "Object id and path id not matched");
        return bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        bookService.delete(id);
    }


}
