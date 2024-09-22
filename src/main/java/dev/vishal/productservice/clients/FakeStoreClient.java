package dev.vishal.productservice.clients;

/*
It is recommended to use different package client when we call third party APIs
so we will abstract out all the http calls to fakestore in this
sometimes third party already gives you client like razorpay -- its easy for us to know consumers and provider pojos as they have those pojos in them
 */

import dev.vishal.productservice.dtos.ProductDTO;
import dev.vishal.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public List<FakeStoreProductDTO> getAllProducts(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate
                .getForEntity("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);

        return Arrays.asList(responseEntity.getBody());
    }

    public Optional<FakeStoreProductDTO> getSingleProduct(Long productId){
        return null;
    }

    public FakeStoreProductDTO addNewProduct(ProductDTO product){
        return null;
    }

    public FakeStoreProductDTO updateProduct(Long productId, Product product){
        return null;
    }

    public boolean deleteProduct(Long productId){
        return false;
    }

    public FakeStoreProductDTO replaceProduct(Long productId, ProductDTO product){
        return null;
    }

    public String[] getAllCategories(){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", String[].class);
        return responseEntity.getBody();
    }

    public List<FakeStoreProductDTO> getProductInCategory(String category){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/category/" + category, FakeStoreProductDTO[].class);
        return Arrays.asList(responseEntity.getBody());
    }

}
