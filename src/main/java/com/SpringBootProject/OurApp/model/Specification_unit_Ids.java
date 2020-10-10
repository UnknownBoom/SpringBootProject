package com.SpringBootProject.OurApp.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
public class Specification_unit_Ids implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_type_id")

    private Product_types product_type;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_unit_id")
    private Product_types product_unit;

    public Specification_unit_Ids(Product_types product_type, Product_types product_unit) {
        this.product_type = product_type;
        this.product_unit = product_unit;
    }
}
