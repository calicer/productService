package dev.vishal.productservice.controllers;

import dev.vishal.productservice.dtos.GetSingleProductResponseDto;
import dev.vishal.productservice.dtos.ProductDTO;
import dev.vishal.productservice.models.Product;
import dev.vishal.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    private ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = productService.getAllProducts();
        ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetSingleProductResponseDto> getSingleProduct(@PathVariable("productId") Long productId) {
        GetSingleProductResponseDto getSingleProductResponseDto = new GetSingleProductResponseDto();
        getSingleProductResponseDto.setProduct(productService.getSingleProduct(productId));

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

    @PutMapping("/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
        return "update pro";
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId) {
        return "delete pro";

    }



}
