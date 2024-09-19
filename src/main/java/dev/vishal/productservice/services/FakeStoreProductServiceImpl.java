package dev.vishal.productservice.services;

import dev.vishal.productservice.clients.FakeStoreClient;
import dev.vishal.productservice.clients.FakeStoreProductDTO;
import dev.vishal.productservice.dtos.ProductDTO;
import dev.vishal.productservice.models.Category;
import dev.vishal.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FakeStoreProductServiceImpl implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductServiceImpl(RestTemplateBuilder restTemplateBuilder, FakeStoreClient fakeStoreClient) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.fakeStoreClient = fakeStoreClient;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> list = new ArrayList<>();
        for(FakeStoreProductDTO productDTO : fakeStoreClient.getAllProducts()) {
            Product product = convertFakeStoreProductDTOToProduct(productDTO);
            list.add(product);
        }
       return list;
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDTO.class, productId);

        FakeStoreProductDTO productDTO = responseEntity.getBody();
        if(Objects.isNull(productDTO)) {
            return Optional.empty();
        }
        return Optional.of(convertFakeStoreProductDTOToProduct(productDTO));
    }

    @Override
    public Product addNewProduct(ProductDTO product) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.postForEntity("https://fakestoreapi.com/products", product, FakeStoreProductDTO.class);
        FakeStoreProductDTO productDTO = responseEntity.getBody();
        return convertFakeStoreProductDTOToProduct(productDTO);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {

        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setImage(product.getImageUrl());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setTitle(product.getTitle());

        RestTemplate restTemplate = restTemplateBuilder
                .requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());



       ResponseEntity<FakeStoreProductDTO> responseEntity = requestForEntity(
                                                                       HttpMethod.PATCH,
                                                                       "https://fakestoreapi.com/products/{productId}",
                                                                       fakeStoreProductDTO,
                                                                       FakeStoreProductDTO.class,
                                                                       productId

                                                               );

       FakeStoreProductDTO responseEntityBody = responseEntity.getBody();
       return convertFakeStoreProductDTOToProduct(responseEntityBody);
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }

    @Override
    public Product replaceProduct(Long productId, ProductDTO product) {
        RestTemplate restTemplate =restTemplateBuilder.build();
        return null;
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

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return ((ResponseEntity)restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables));
    }
}
