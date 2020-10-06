package com.SpringBootProject.OurApp.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name="specification_furniture")
public class Specification_furniture implements Serializable {

    @Id
    @OneToOne
    @JoinColumn
    private Product_types product_type;

    @Id
    @OneToOne
    @JoinColumn
    private Furniture_types furniture;

    @Column(nullable = false)
    private Long amount;

}
