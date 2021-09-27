package com.vta.shop.book.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Book> getById(Long id) {

        return bookRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAll() {

        return bookRepository.findAll();
    }

    @Override
    public List<Book> create(List<Book> books) {

        return bookRepository.saveAll(books);
    }

    @Override
    public void delete(Long id) {

        this.bookRepository.deleteById(id);
    }

    @Override
    public Book update(Book updated) {

        Book book = this.bookRepository.findById(updated.getId()).map(persisted -> {
            persisted.setTitle(updated.getTitle());
            persisted.setPrice(updated.getPrice());
            persisted.setDescription(updated.getDescription());
            persisted.setCount(updated.getCount());
            return persisted;
        }).orElseThrow(() -> new NotFoundException(updated.getId()));

        return this.bookRepository.save(book);
    }
}
