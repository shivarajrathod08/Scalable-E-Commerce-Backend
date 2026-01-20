package org.ecommerce.service;

import org.ecommerce.model.Product;
import org.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;

    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public List<Product> getProductByCategory(Long categoryId){
        return productRepository.findByCategoryId(categoryId);
    }

}
