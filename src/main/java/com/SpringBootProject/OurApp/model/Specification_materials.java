package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name="specification_materials")
public class Specification_materials implements Serializable {
    @Id
    @JoinColumn
    @OneToOne
    private Product_types product_type;

    @Id
    @OneToOne
    @JoinColumn
    private Materials material;

    @Column(nullable = false)
    private BigDecimal amount;
}
