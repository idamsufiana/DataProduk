package com.java.produk.data.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private Integer stock;
    private Double price;
}