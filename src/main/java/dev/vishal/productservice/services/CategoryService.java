package dev.vishal.productservice.services;

import dev.vishal.productservice.clients.FakeStoreCategoryDTO;
import dev.vishal.productservice.clients.FakeStoreProductDTO;
import dev.vishal.productservice.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {
    String[] getAllCategories();

    List<Product> getProductsInCategory(String category);
}
