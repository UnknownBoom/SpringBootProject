package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

//Not Ended

@Entity
@Data
@NoArgsConstructor
@Table(name="specification_unit")
public class Specification_unit implements Serializable {
    @Id
    @OneToOne
    @JoinColumn
    private Product_types product_type;

 //   unit VARCHAR(50) NOT NULL,

    @Column(nullable = false)
    private Integer amount;

}
