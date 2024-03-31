package com.example.invoicemgtsystembackend.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetails {
    private String name;
    private Integer price ;
    private Integer quantity ;
}
