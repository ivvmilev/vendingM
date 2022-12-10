package com.example.vendingm.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {

        super(String.format("Product with Id %d not found", id));
    }
}