package org.ecommerce.config;

import org.ecommerce.model.Category;
import org.ecommerce.model.Product;
import org.ecommerce.repository.CategoryRepository;
import org.ecommerce.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
       home.setName("Home and Kitchen");

       categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));

       Product phone = new Product();
       phone.setName("Smart Phone");
       phone.setDescription("Latest smart phone with amazing features.");
       phone.setImageUrl("https://placehold.co/600x400");
       phone.setPrice(690.90);
       phone.setCategories(new HashSet<>(Arrays.asList(electronics)));


        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High Performance laptop for work and play.");
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setPrice(7680.90);
        laptop.setCategories(new HashSet<>(Arrays.asList(electronics)));

     Product jacket  = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm and cozy jacket for winter.");
        jacket.setImageUrl("https://placehold.co/600x400");
        jacket.setPrice(980.90);
        jacket.setCategories(new HashSet<>(Arrays.asList(clothing)));


        Product blender  = new Product();
        blender.setName("Blender");
        blender.setDescription("High-speed blender for smoothies and more.");
        blender.setImageUrl("https://placehold.co/600x400");
        blender.setPrice(98.90);
        blender.setCategories(new HashSet<>(Arrays.asList(home)));
        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));

    }
}

