package com.example.vendingm.exceptions;

public class ProductNotEnoughException extends RuntimeException {

    public ProductNotEnoughException(String productName) {
        super(String.format("Product with name %s is not enough. Please add more products!", productName));
    }
}

