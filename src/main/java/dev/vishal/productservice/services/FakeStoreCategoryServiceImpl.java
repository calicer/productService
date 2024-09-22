package dev.vishal.productservice.services;

import dev.vishal.productservice.clients.FakeStoreCategoryDTO;
import dev.vishal.productservice.clients.FakeStoreClient;
import dev.vishal.productservice.clients.FakeStoreProductDTO;
import dev.vishal.productservice.models.Category;
import dev.vishal.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImpl implements CategoryService{

    private FakeStoreClient fakeStoreClient;

    public FakeStoreCategoryServiceImpl(FakeStoreClient fakeStoreClient){
        this.fakeStoreClient = fakeStoreClient;
    }
    @Override
    public String[] getAllCategories() {
        return fakeStoreClient.getAllCategories();
    }

    @Override
    public List<Product> getProductsInCategory(String category) {

        List<Product> list = new ArrayList<>();
        for(FakeStoreProductDTO productDTO : fakeStoreClient.getProductInCategory(category)) {
            Product product = convertFakeStoreProductDTOToProduct(productDTO);
            list.add(product);
        }
        return list;
    }

    private Product convertFakeStoreProductDTOToProduct(FakeStoreProductDTO productDTO) {
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setImageUrl(productDTO.getImage());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        Category category = new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);
        return product;

    }
}
