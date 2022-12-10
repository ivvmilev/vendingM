package com.example.vendingm.exceptions;

public class CoinsNotEnoughException extends RuntimeException {

    public CoinsNotEnoughException(String productName, int coins) {
        super(String.format("Coins for product %s is not enough. Please insert %d more coins", productName, coins));
    }
}
