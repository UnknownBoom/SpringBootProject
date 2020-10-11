package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class Specification_materials_Ids implements Serializable {

    private Product_types product_type;

    private Materials material;

    public Specification_materials_Ids(Product_types product_type, Materials material) {
        this.product_type = product_type;
        this.material = material;
    }
}
