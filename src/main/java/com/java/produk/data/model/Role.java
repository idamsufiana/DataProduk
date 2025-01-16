package com.java.produk.data.model;

import com.java.produk.data.constant.Group;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role extends CrudEntity{
    private Group role;
    private String description;
}
