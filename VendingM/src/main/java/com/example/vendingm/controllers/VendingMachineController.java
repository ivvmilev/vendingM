package com.example.vendingm.controllers;

import com.example.vendingm.models.CoinBundle;
import com.example.vendingm.models.Product;
import com.example.vendingm.services.VendingMachineService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class VendingMachineController {
    private final VendingMachineService vendingMachineService;

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    @PostMapping("/vending/buy/{id}")
    public Product addProduct(@PathVariable long id) {
        return vendingMachineService.buyProduct(id);
    }

    @PostMapping("/vending/insertCoin")
    public void insertCoin(@RequestBody CoinBundle coinBundle) {
        vendingMachineService.insertCoin(coinBundle);

    }

    @DeleteMapping("/vending/reset")
    public void resetCoins() {
        vendingMachineService.reset();
    }
}
