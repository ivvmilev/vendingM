package com.example.vendingm.exceptions;

public class CoinsNotInsertedException extends RuntimeException {

    public CoinsNotInsertedException() {

        super("Please insert coins to buy a product!");
    }
}
