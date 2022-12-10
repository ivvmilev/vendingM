package com.example.vendingm.services;

import com.example.vendingm.models.Product;
import com.example.vendingm.models.ProductDto;

import java.util.List;

public interface VendingMachineCrudService {

    /**
     * Add a product
     *
     * @param productDto Product dto with validations
     * @return Added product
     */
    Product addProduct(ProductDto productDto);

    /**
     * @param id         id for product to update
     * @param productDto Update product dto with validations
     * @return updated product
     */
    Product update(long id, ProductDto productDto);

    /**
     * Remove product by id
     *
     * @param id id of the product to remove
     */
    void removeProduct(long id);

    /**
     * create initial product examples
     */
    void createInitialProducts();

    /**
     * Get all products
     *
     * @return List of the products
     */
    List<Product> getProducts();
}
