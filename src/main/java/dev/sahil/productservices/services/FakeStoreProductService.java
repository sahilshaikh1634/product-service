package dev.sahil.productservices.services;

import dev.sahil.productservices.dtos.FakeStoreProductDto;
import dev.sahil.productservices.dtos.GenericProductDto;
import dev.sahil.productservices.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    String forProductsUrl = "https://fakestoreapi.com/products";
    String forProductByIdUrl = "https://fakestoreapi.com/products/{id}";

    public GenericProductDto fakeStoreProductDtoTOGenericProductDto(FakeStoreProductDto fakeStoreProduct){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProduct.getId());
        genericProductDto.setTitle(fakeStoreProduct.getTitle());
        genericProductDto.setCategory(fakeStoreProduct.getCategory());
        genericProductDto.setPrice(fakeStoreProduct.getPrice());
        genericProductDto.setDescription(fakeStoreProduct.getDescription());
        genericProductDto.setImage(fakeStoreProduct.getImage());

        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(forProductByIdUrl, FakeStoreProductDto.class,id);
        FakeStoreProductDto fakestoreProduct = response.getBody();

        if(fakestoreProduct == null){
            throw new NotFoundException("Product with id:"+id+" is not found..");
        }

        return fakeStoreProductDtoTOGenericProductDto(fakestoreProduct);
    }

    @Override
    public List<GenericProductDto> getProducts() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(forProductsUrl, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProduct = response.getBody();
        List<GenericProductDto> genericProductDtoList = new ArrayList<>();

        for (FakeStoreProductDto fakestoreProductDto : fakeStoreProduct){
            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto = fakeStoreProductDtoTOGenericProductDto(fakestoreProductDto);
            genericProductDtoList.add(genericProductDto);
        }
        return genericProductDtoList;
    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void updateProductById() {

    }

    @Override
    public void createProduct() {

    }
}
