package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name="specification_materials")
@IdClass(Specification_materials_Ids.class)
public class Specification_materials implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_type_id")

    private Product_types product_type;

    @Id
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Materials material;

    @Column(nullable = false)
    private BigDecimal amount;
}
