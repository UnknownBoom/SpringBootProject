package com.SpringBootProject.OurApp.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="specification_furniture")
public class Specification_furniture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "specification_furniture_gen")
    @SequenceGenerator(name = "specification_furniture_gen",sequenceName = "specification_furniture_seq" ,allocationSize = 25,initialValue = 25)
    private Long id;

    @NaturalId(mutable = true)
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private Product_types product_type;

    @NaturalId(mutable = true)
    @CollectionTable(name = "furniture_type", joinColumns = @JoinColumn(name = "furniture_article"))
    @Enumerated(EnumType.STRING)
    private Furniture_types furniture;

    @Column(nullable = false)
    private Long amount;

}
