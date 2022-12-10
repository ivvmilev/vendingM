package com.example.vendingm.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotNull
    @Length(message = "Name should not be more than 250 symbols")
    private String name;

    @NotNull
    @Min(value = 0, message = "Price should not be less than 0")
    @Max(value = 1000, message = "Price should not be greater than 1000")
    private int price;


    @Min(value = 0, message = "Quantity should not be less than 0")
    @Max(value = 10, message = "Quantity should not be greater than 10")
    private int quantity;
}
