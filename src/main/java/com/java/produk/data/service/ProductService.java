package com.java.produk.data.service;

import com.java.produk.data.exception.VascommException;
import com.java.produk.data.model.Product;
import com.java.produk.data.model.dto.ProductDto;
import com.java.produk.data.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createFromDto(ProductDto dto) throws Throwable {
        try {
            Product entity = new Product();
            BeanUtils.copyProperties(dto, entity);
            entity.setCreatedDate(new Date());
            productRepository.save(entity);
            return entity;
        } catch (Throwable var5) {
            Throwable $ex = var5;
            throw $ex;
        }
    }

    public Optional<Product> get(UUID id) throws Throwable {
        try {
            return productRepository.findById(id);
        } catch (Throwable var3) {
            Throwable $ex = var3;
            throw $ex;
        }
    }

    public Product update(UUID id, ProductDto dto) throws Throwable {
        try {
            Product entity = new Product();
            if(get(id).isPresent()){
                entity = productRepository.findById(id).get();
                BeanUtils.copyProperties(dto, entity);
                entity.setUpdatedDate(new Date());
                return productRepository.save(entity);
            }else{
                throw new VascommException("not found");
            }
        } catch (Throwable var5) {
            Throwable $ex = var5;
            throw $ex;
        }
    }

    public Product delete(UUID id) throws Throwable {
        try {
            Product entity = new Product();
            if(get(id).isPresent()) {
                entity = productRepository.findById(id).get();
                productRepository.delete(entity);
                return entity;
            }else {
                throw new VascommException("data not found");
            }

        } catch (Throwable var3) {
            Throwable $ex = var3;
            throw $ex;
        }
    }
    public Page<Product> getProducts(int page, int limit,String search){
        int offset = (page - 1) * limit;
        Pageable pageable = PageRequest.of(page - 1, limit);
        return productRepository.findByNameContainingIgnoreCase(search, pageable);
    }

}