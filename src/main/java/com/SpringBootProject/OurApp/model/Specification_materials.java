package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name="specification_materials")
public class Specification_materials implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "specification_materials_gen")
    @SequenceGenerator(name = "specification_materials_gen",sequenceName = "specification_materials_sqe" ,allocationSize = 25,initialValue = 25)
    private Long id;

    @NaturalId
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private Product_types product_type;

    @NaturalId
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Materials material;

    @Column(nullable = false)
    private Integer amount;
}
