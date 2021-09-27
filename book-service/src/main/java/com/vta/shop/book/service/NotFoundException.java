package com.vta.shop.book.service;

public class NotFoundException extends RuntimeException {


    public NotFoundException(long id) {

        super(String.format("Book with id '%s' not found!", id));
    }
}
