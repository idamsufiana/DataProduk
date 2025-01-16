package com.java.produk.data.service;

import com.java.produk.data.exception.VascommException;
import com.java.produk.data.model.Product;
import com.java.produk.data.model.User;
import com.java.produk.data.model.dto.UserDto;
import com.java.produk.data.repository.UserRepository;
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
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createFromDto(UserDto dto) throws Throwable {
        try {
            User entity = new User();
            BeanUtils.copyProperties(dto, entity);
            entity.setCreatedDate(new Date());
            entity.setStatus(true);
            userRepository.save(entity);
            return entity;
        } catch (Throwable var5) {
            Throwable $ex = var5;
            throw $ex;
        }
    }

    public Optional<User> get(UUID id) throws Throwable {
        try {
            return userRepository.findById(id);
        } catch (Throwable var3) {
            Throwable $ex = var3;
            throw $ex;
        }
    }

    public User update(UUID id, UserDto dto) throws Throwable {
        try {
            User entity = new User();
            if(get(id).isPresent()){
                entity = userRepository.findById(id).get();
                BeanUtils.copyProperties(dto, entity);
                entity.setUpdatedDate(new Date());
                return userRepository.save(entity);
            }else{
                throw new VascommException("not found");
            }
        } catch (Throwable var5) {
            Throwable $ex = var5;
            throw $ex;
        }
    }

    public User delete(UUID id) throws Throwable {
        try {
            User entity = new User();
            if(get(id).isPresent()) {
                entity = userRepository.findById(id).get();
                entity.setStatus(false);
                userRepository.save(entity);
                return entity;
            }else {
                throw new VascommException("data not found");
            }

        } catch (Throwable var3) {
            Throwable $ex = var3;
            throw $ex;
        }
    }

    public Page<User> getUsers(int page, int limit, String search){
        int offset = (page - 1) * limit;
        Pageable pageable = PageRequest.of(page - 1, limit);
        return userRepository.findByUserNameContainingIgnoreCase(search, pageable);
    }

}