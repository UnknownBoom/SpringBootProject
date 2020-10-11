package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class Specification_unit_Ids implements Serializable {

    private Product_types product_type;

    private Product_types product_unit;

    public Specification_unit_Ids(Product_types product_type, Product_types product_unit) {
        this.product_type = product_type;
        this.product_unit = product_unit;
    }
}
