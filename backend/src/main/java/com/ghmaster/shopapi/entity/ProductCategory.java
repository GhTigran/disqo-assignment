package com.ghmaster.shopapi.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Date createTime;
    private Date updateTime;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName) {
        this.name = categoryName;
    }
}
