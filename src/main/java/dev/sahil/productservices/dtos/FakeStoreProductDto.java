package dev.sahil.productservices.dtos;

import lombok.Getter;

@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;
}
