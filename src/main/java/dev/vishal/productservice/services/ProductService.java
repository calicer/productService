package dev.vishal.productservice.services;

import dev.vishal.productservice.dtos.ProductDTO;
import dev.vishal.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getSingleProduct(Long productId);

    Product addNewProduct(ProductDTO product);

    Product updateProduct(Long productId, Product product);

    boolean deleteProduct(Long productId);

    Product replaceProduct(Long productId, ProductDTO product);
}
