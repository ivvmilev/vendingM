package com.example.vendingm.services;

import com.example.vendingm.models.CoinBundle;
import com.example.vendingm.models.Product;

public interface VendingMachineService {
    /**
     * Insert coins to buy products
     *
     * @param coinBundle The coins inserted
     *                   Works with 10, 20, 50, 100, 200 coins
     */
    void insertCoin(CoinBundle coinBundle);

    /**
     * Reset coins
     */
    void reset();

    /**
     * Buy a product
     *
     * @param id id of the product to buy
     * @return Purchased product
     */
    Product buyProduct(long id);
}
