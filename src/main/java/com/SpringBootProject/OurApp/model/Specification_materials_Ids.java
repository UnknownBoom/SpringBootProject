package com.SpringBootProject.OurApp.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
public class Specification_materials_Ids implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_type_id")

    private Product_types product_type;

    @Id
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Materials material;
}
