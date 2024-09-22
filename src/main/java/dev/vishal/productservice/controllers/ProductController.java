package dev.vishal.productservice.controllers;

import dev.vishal.productservice.dtos.GetSingleProductResponseDto;
import dev.vishal.productservice.dtos.ProductDTO;
import dev.vishal.productservice.exceptions.NotFoundException;
import dev.vishal.productservice.models.Category;
import dev.vishal.productservice.models.Product;
import dev.vishal.productservice.repositories.ProductRepository;
import dev.vishal.productservice.services.FakeStoreProductServiceImpl;
import dev.vishal.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/*
Controllers work on DTOs
DTOs are for external communication
Controller duty to convert models to DTO
Services can return DTO as the same method can be called at different places
 */

@RestController
@RequestMapping("/products")
public class ProductController {

    private final FakeStoreProductServiceImpl fakeStoreProductServiceImpl;
    private ProductService productService;

    private ProductController(ProductService productService, FakeStoreProductServiceImpl fakeStoreProductServiceImpl) {
        this.productService = productService;
        this.fakeStoreProductServiceImpl = fakeStoreProductServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetSingleProductResponseDto> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        GetSingleProductResponseDto getSingleProductResponseDto = new GetSingleProductResponseDto();
        Optional<Product> product = productService.getSingleProduct(productId);

        if (product.isPresent()) {
            getSingleProductResponseDto.setProduct(product.get());
        }else{
            throw new NotFoundException("No Product with product id: " + productId);
        }

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Accept", "application/json");
        headers.add("authToken", "YouAreGranted");
        ResponseEntity<GetSingleProductResponseDto> responseEntity = new ResponseEntity<>(getSingleProductResponseDto, headers, HttpStatus.OK);

        return responseEntity;
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDTO product) {
        Product newProduct = productService.addNewProduct(product);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        return responseEntity;
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDTO productDTO) {

        Product product = new Product();
        product.setId(productId);
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setTitle(productDTO.getTitle());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());

        Product product1 = fakeStoreProductServiceImpl.updateProduct(productId, product);

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product1, HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "delete pro";

    }



}
