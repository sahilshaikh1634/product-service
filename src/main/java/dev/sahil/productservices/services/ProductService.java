package dev.sahil.productservices.services;

import dev.sahil.productservices.dtos.GenericProductDto;
import dev.sahil.productservices.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    GenericProductDto getProductById(Long id) throws NotFoundException;

    public List<GenericProductDto> getProducts();
    public void deleteProductById();
    public void updateProductById();
    public void createProduct();
}
