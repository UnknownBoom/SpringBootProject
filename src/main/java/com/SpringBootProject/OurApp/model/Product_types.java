package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="product_Types")
public class Product_types {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_Types_generator")
    @SequenceGenerator(name = "product_Types_generator",sequenceName = "product_Types_seq" ,allocationSize = 25,initialValue = 25)
    private Long Product_type_id;

    @NaturalId(mutable = true)
    private String Product_type_name;

    @Column(nullable = false)
    private Integer dimensions;

}
