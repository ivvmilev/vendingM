package com.example.vendingm.controllers;

import com.example.vendingm.models.Product;
import com.example.vendingm.models.ProductDto;
import com.example.vendingm.services.VendingMachineCrudService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendingCrudController {

    private final VendingMachineCrudService vendingMachineCrudService;

    public VendingCrudController(VendingMachineCrudService vendingMachineCrudService) {
        this.vendingMachineCrudService = vendingMachineCrudService;
    }

    @GetMapping("/product")
    public List<Product> getProducts() {
        return vendingMachineCrudService.getProducts();
    }

    @PutMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(vendingMachineCrudService.addProduct(productDto), HttpStatus.CREATED);
    }

    @PostMapping("/examples")
    public void createInitialProducts() {
        vendingMachineCrudService.createInitialProducts();
    }

    @PostMapping("/product/{id}")
    public Product updateProduct(@PathVariable long id, @Valid @RequestBody ProductDto productDto) {
        return vendingMachineCrudService.update(id, productDto);
    }

    @DeleteMapping("/product")
    public void deleteProduct(long id) {
        vendingMachineCrudService.removeProduct(id);
    }

}
