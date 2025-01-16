package com.java.produk.data.controller;

import com.java.produk.data.exception.VascommException;
import com.java.produk.data.model.Product;
import com.java.produk.data.model.User;
import com.java.produk.data.model.dto.ProductDto;
import com.java.produk.data.model.dto.UserDto;
import com.java.produk.data.service.ProductService;
import com.java.produk.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/User")
public class UserController extends BaseController{
    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Object Get(@PathVariable UUID id) throws Throwable {
        Optional<User> user = userService.get(id);
        if(user.isPresent()){
            return success(userService.get(id).get());
        }else {
            throw new VascommException("no data found");
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/update/{id}")
    public Object Update(@PathVariable UUID id, @RequestBody UserDto dto) throws Throwable {
        return success(userService.update(id, dto));

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public Object add(@RequestBody UserDto dto) throws Throwable {
        return success(userService.createFromDto(dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public Object add(@PathVariable UUID id) throws Throwable {
        return success(userService.delete(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public ResponseEntity<Object> getProducts(
            @RequestParam(value = "take", defaultValue = "10") int take,
            @RequestParam(value = "skip", defaultValue = "0") int skip,
            @RequestParam(value = "search", required = false) String search
    ) {
        return ResponseEntity.ok(userService.getUsers(take, skip, search));
    }

}
