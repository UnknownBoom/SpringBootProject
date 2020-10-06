package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="product_Types")
public class Product_types {
    @Id
    private Long Product_type_id;

    @NaturalId
    private String Product_type_name;

    private Integer dimensions;

}
