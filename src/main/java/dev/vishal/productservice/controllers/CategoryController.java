package dev.vishal.productservice.controllers;

import dev.vishal.productservice.clients.FakeStoreCategoryDTO;
import dev.vishal.productservice.clients.FakeStoreProductDTO;
import dev.vishal.productservice.models.Product;
import dev.vishal.productservice.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<String[]> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Product>> getProductsInCategory(@PathVariable("category") String category) {
        return new ResponseEntity<>(categoryService.getProductsInCategory(category), HttpStatus.OK);
    }

}
