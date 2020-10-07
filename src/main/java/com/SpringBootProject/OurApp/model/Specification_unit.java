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
    @OneToOne
    @JoinColumn
    private Product_types product_type;

    @Id
    @OneToOne
    @JoinColumn
    private Product_types product_unit;

    @Column(nullable = false)
    private Integer amount;

}
