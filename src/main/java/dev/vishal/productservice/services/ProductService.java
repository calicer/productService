package dev.vishal.productservice.services;

import dev.vishal.productservice.dtos.ProductDTO;
import dev.vishal.productservice.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId);

    Product addNewProduct(ProductDTO product);

    Product updateProduct(Long productId, Product product);

    boolean deleteProduct(Long productId);
}
