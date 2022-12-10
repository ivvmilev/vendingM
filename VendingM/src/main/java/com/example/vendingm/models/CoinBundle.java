package com.example.vendingm.models;

public class CoinBundle {
    private static final int TEN_STOTINKI_VALUE = 10;
    private static final int TWENTY_STOTINKI_VALUE = 20;
    private static final int FIFTY_STOTINKI_VALUE = 50;
    private static final int HUNDRED_STOTINKI_VALUE = 100;
    private static final int TWO_HUNDRED_STOTINKI_VALUE = 200;

    private final int tenStotinkiCoins;
    private final int twentyStotinkiCoins;
    private final int fiftyStotinkiCoins;
    private final int hundredStotinkiCoins;
    private final int twoHundredStotinkiCoins;

    public CoinBundle(int... enteredCoins) {
        this.tenStotinkiCoins = enteredCoins[0];
        this.twentyStotinkiCoins = enteredCoins[1];
        this.fiftyStotinkiCoins = enteredCoins[2];
        this.hundredStotinkiCoins = enteredCoins[3];
        this.twoHundredStotinkiCoins = enteredCoins[4];
    }

    public int getInsertedCoins() {
        return (tenStotinkiCoins * TEN_STOTINKI_VALUE)
                + (twentyStotinkiCoins * TWENTY_STOTINKI_VALUE)
                + (fiftyStotinkiCoins * FIFTY_STOTINKI_VALUE)
                + (hundredStotinkiCoins * HUNDRED_STOTINKI_VALUE)
                + (twoHundredStotinkiCoins * TWO_HUNDRED_STOTINKI_VALUE);
    }
}
