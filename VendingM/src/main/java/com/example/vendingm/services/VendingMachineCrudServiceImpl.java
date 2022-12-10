package com.example.vendingm.services;

import com.example.vendingm.exceptions.ProductNotFoundException;
import com.example.vendingm.models.Product;
import com.example.vendingm.models.ProductDto;
import com.example.vendingm.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendingMachineCrudServiceImpl implements VendingMachineCrudService {

    private final ProductRepository productRepository;

    public VendingMachineCrudServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(ProductDto productDto) {
        Optional<Product> product = productRepository.findProductByName(productDto.getName());
        return product.orElseGet(() -> productRepository.save(
                new Product(productDto.getName(), productDto.getPrice(), productDto.getQuantity())));

    }

    @Override
    public Product update(long id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        return productRepository.save(product);
    }

    @Override
    public void removeProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void createInitialProducts() {

        Product coke = new Product("Coke", 230, 5);
        Product water = new Product("Water", 230, 10);
        Product snickers = new Product("Snickers", 230, 1);

        List<Product> productList = new ArrayList<>();
        productList.add(coke);
        productList.add(water);
        productList.add(snickers);

        productRepository.saveAll(productList);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
