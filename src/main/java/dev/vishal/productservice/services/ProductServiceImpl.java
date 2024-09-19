package dev.vishal.productservice.services;

import dev.vishal.productservice.dtos.ProductDTO;
import dev.vishal.productservice.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public Product addNewProduct(ProductDTO product) {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product){
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;

    }

    @Override
    public Product replaceProduct(Long productId, ProductDTO product) {
        return null;
    }
}
