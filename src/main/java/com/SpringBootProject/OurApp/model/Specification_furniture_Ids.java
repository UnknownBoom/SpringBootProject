package com.SpringBootProject.OurApp.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class Specification_furniture_Ids  implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private Product_types product_type;

    @Id
    @CollectionTable(name = "furniture_type", joinColumns = @JoinColumn(name = "furniture_article"))
    @Enumerated(EnumType.STRING)
    private Furniture_types furniture;

    public Specification_furniture_Ids(Product_types product_type, Furniture_types furniture) {
        this.product_type = product_type;
        this.furniture = furniture;
    }
}
