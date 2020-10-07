package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Data
@NoArgsConstructor
@Table(name="specification_unit")
public class Specification_unit implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private Product_types product_type;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_unit_id")
    private Product_types product_unit;

    @Column(nullable = false)
    private Integer amount;

}
