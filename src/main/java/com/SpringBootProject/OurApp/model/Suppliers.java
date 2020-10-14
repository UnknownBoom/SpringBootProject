package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="suppliers")
public class Suppliers {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "suppliers_generator")
    @SequenceGenerator(name = "suppliers_generator",sequenceName = "suppliers_seq" ,allocationSize = 25,initialValue = 25)
    private Long supplier_id;

    @NaturalId
    @Column(name = "supplier_name")
    private String supplier_name;


    @Column(nullable = true)
    private String address =null;

    @Column(nullable = false)
    private Integer delivery_period;
}

