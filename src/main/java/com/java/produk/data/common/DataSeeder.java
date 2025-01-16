package com.java.produk.data.common;

import com.java.produk.data.constant.Group;
import com.java.produk.data.model.Product;
import com.java.produk.data.model.Role;
import com.java.produk.data.model.User;
import com.java.produk.data.repository.ProductRepository;
import com.java.produk.data.repository.RoleRepository;
import com.java.produk.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ProductRepository produkRepository;

    @Override
    public void run(String... args) throws Exception {

        Role roleAdm = new Role();
        roleAdm.setRole(Group.ROLE_ADMIN);
        roleAdm.setDescription("");
        roleRepository.save(roleAdm);

        Role roleUser = new Role();
        roleUser.setRole(Group.ROLE_USER);
        roleUser.setDescription("");
        roleRepository.save(roleUser);


        Set<Role> roles = new HashSet<>();
        roles.add(roleAdm);

        User admin = new User();
        admin.setUserName("admin");
        admin.setPassword("adminpass");
        admin.setStatus(true);
        admin.setRoles(roles);
        userRepository.save(admin);

        Set<Role> roleU = new HashSet<>();
        roleU.add(roleUser);

        User user = new User();
        user.setUserName("user");
        user.setPassword("userpass");
        user.setStatus(true);
        user.setRoles(roleU);
        userRepository.save(admin);

        Product produk = new Product();
        produk.setName("Produk A");
        produk.setDescription("Deskripsi Produk A");
        produk.setPrice(100.0);
        produkRepository.save(produk);
    }
}
