package dev.sahil.productservices.controllers;

import dev.sahil.productservices.dtos.GenericProductDto;
import dev.sahil.productservices.exceptions.NotFoundException;
import dev.sahil.productservices.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public List<GenericProductDto> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable Long id) throws NotFoundException {

        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(@PathVariable Long id)
    {

    }

    @PutMapping("{id}")
    public void updateProductById(@PathVariable Long id){

    }

    @PostMapping()
    public void createProduct(){

    }

}
