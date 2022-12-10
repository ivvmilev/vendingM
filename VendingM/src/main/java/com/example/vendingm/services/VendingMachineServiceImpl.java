package com.example.vendingm.services;

import com.example.vendingm.exceptions.CoinsNotEnoughException;
import com.example.vendingm.exceptions.CoinsNotInsertedException;
import com.example.vendingm.exceptions.ProductNotEnoughException;
import com.example.vendingm.exceptions.ProductNotFoundException;
import com.example.vendingm.models.CoinBundle;
import com.example.vendingm.models.Product;
import com.example.vendingm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class VendingMachineServiceImpl implements VendingMachineService {

    private final ProductRepository productRepository;
    private CoinBundle coinBundle;

    public VendingMachineServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void insertCoin(CoinBundle coinBundle) {
        this.coinBundle = coinBundle;
    }

    @Override
    public void reset() {
        coinBundle = null;
    }

    @Override
    public Product buyProduct(long id) {

        if (coinBundle == null) {
            throw new CoinsNotInsertedException();
        }

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        if (product.getQuantity() - 1 < 0) {
            throw new ProductNotEnoughException(product.getName());
        }

        if (coinBundle.getInsertedCoins() >= product.getPrice()) {
            return product;
        }
        throw new CoinsNotEnoughException(product.getName(), coinBundle.getInsertedCoins() - product.getPrice());
    }
}
