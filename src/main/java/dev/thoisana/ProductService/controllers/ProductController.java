package dev.thoisana.ProductService.controllers;

import dev.thoisana.ProductService.model.Product;
import dev.thoisana.ProductService.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // object created through this annotation, this annotation inform spring to create object of this class
public class ProductController {

    // THIS APPROACH IS NOT RECOMMENDED, INSTEAD USE DEPENDENCY INJECTION
    // ProductService productService = new FakeStorePublicService();

    //DEPENDENCY INJECTION
    ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    //let the product controller talk the product service through an interface
    @PostMapping("/product")
    public void createProduct(){

    }

    @GetMapping("/products")
    public void getAllproducts(){

    }

    // jackson library, it is used to convert from java object to json format. our api can return java object, not json.
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable("id") Long id){
//        Product product = new Product();
//        product.getId();
//        product.setTitle("tomba");
        return productService.getSingleProduct(id);
//         return  null;
    }

    public void deleteProductById(Long id){

    }
}
