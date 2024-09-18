package dev.vishal.productservice.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CategoryServiceImpl implements CategoryService {

    @Override
    public String getAllCategories() {
        return "All categories";
    }

    @Override
    public String getProductsInCategory(Long category) {
        return "All products in category " + category;
    }
}
