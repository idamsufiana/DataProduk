package com.java.produk.data.common;

import com.java.produk.data.model.Product;
import com.java.produk.data.model.User;
import com.java.produk.data.repository.ProductRepository;
import com.java.produk.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository produkRepository;

    @Override
    public void run(String... args) throws Exception {

        User admin = new User();
        admin.setUserName("admin");
        admin.setPassword("adminpass");
        userRepository.save(admin);

        Product produk = new Product();
        produk.setName("Produk A");
        produk.setDescription("Deskripsi Produk A");
        produk.setPrice(100.0);
        produkRepository.save(produk);
    }
}
