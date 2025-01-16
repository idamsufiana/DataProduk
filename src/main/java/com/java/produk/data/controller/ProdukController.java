package com.java.produk.data.controller;

import com.java.produk.data.exception.VascommException;
import com.java.produk.data.model.Product;
import com.java.produk.data.model.dto.ProductDto;
import com.java.produk.data.service.ProductService;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/Product")
public class ProdukController extends BaseController{

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public Object Get(@PathVariable UUID id) throws Throwable {
        Optional<Product> product = productService.get(id);
        if(product.isPresent()){
            return success(productService.get(id).get());
        }else {
            throw new VascommException("no data found");
        }

    }

    @PostMapping("/update/{id}")
    public Object Update(@PathVariable UUID id, @RequestBody ProductDto dto) throws Throwable {
        return success(productService.update(id, dto));

    }

    @PostMapping("/add")
    public Object add(@RequestBody ProductDto dto) throws Throwable {
        return success(productService.createFromDto(dto));
    }

    @DeleteMapping("/delete/{id}")
    public Object add(@PathVariable UUID id) throws Throwable {
        return success(productService.delete(id));
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getProducts(
            @RequestParam(value = "take", defaultValue = "10") int take,
            @RequestParam(value = "skip", defaultValue = "0") int skip,
            @RequestParam(value = "search", required = false) String search
    ) {
        return ResponseEntity.ok(productService.getProducts(take, skip, search));
    }

}