package com.ghmaster.shopapi.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {
    @Id
    private String id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Integer stock;

    private String description;

    private String image;

    @ColumnDefault("0")
    private Integer status;


    @ColumnDefault("0")
    private Integer categoryId;

    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date updateTime;

    public ProductInfo() {
    }
}
