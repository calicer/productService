package dev.vishal.productservice.services;

import dev.vishal.productservice.dtos.ProductDTO;
import dev.vishal.productservice.models.Category;
import dev.vishal.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {

       return null;
    }

    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDTO> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", ProductDTO.class, productId);

        ProductDTO productDTO = responseEntity.getBody();
        Product product = new Product();
        //product.setId(productDTO.getId());
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImage());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        Category category = new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);


        return product;
    }

    @Override
    public Product addNewProduct(ProductDTO product) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<ProductDTO> responseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", product, ProductDTO.class);
        ProductDTO productDTO = responseEntity.getBody();
        Product product1 = new Product();
        product1.setId(productDTO.getId());
        product1.setDescription(productDTO.getDescription());
        product1.setImageUrl(productDTO.getImage());
        product1.setTitle(productDTO.getTitle());
        product1.setPrice(productDTO.getPrice());
        Category category = new Category();
        category.setName(productDTO.getCategory());
        product1.setCategory(category);
        return product1;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }
}
