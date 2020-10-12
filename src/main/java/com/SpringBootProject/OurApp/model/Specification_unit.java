package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;
import org.thymeleaf.expression.Ids;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Data
@NoArgsConstructor
@Table(name="specification_unit")
public class Specification_unit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "specification_unit_gen")
    @SequenceGenerator(name = "specification_unit_gen",sequenceName = "specification_unit_seq" ,allocationSize = 25,initialValue = 25)
    private Long id;


    @NaturalId
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private Product_types product_type;

    @NaturalId
    @ManyToOne
    @JoinColumn(name = "product_unit_id")
    private Product_types product_unit;

    @Column(nullable = false)
    private Integer amount;

}
