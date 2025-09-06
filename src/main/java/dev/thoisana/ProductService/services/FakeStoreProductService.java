package dev.thoisana.ProductService.services;

import dev.thoisana.ProductService.dtos.FakeStoreProductDto;
import dev.thoisana.ProductService.model.Category;
import dev.thoisana.ProductService.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


//@Service, this annotation also we can use, it does the same as component annotation, and also indicates it is service class
//@Component  // THIS ANNOTATION TELLS SPRING CLASS, CREATE AN OBJ OF CLASS(FakeStorePublicService) AND PUT IT INSIDE PRODUCT SERVICE

@Service
public class FakeStoreProductService implements ProductService {
    @Override
    public Product getSingleProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/product/"+id, FakeStoreProductDto.class);

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageUrl(fakeStoreProductDto.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }

}
