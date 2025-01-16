package com.java.produk.data.repository;

import com.java.produk.data.model.Product;
import com.java.produk.data.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findFirstByUserName(String name);
    Page<User> findByUserNameContainingIgnoreCase(String name, Pageable pageable);

}
