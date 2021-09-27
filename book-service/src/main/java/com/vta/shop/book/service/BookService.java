package com.vta.shop.book.service;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getById(Long id);
    List<Book> getAll();
    List<Book> create(List<Book> books);
    void delete(Long id);

    Book update(Book book);
}
