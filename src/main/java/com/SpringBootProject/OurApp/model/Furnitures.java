package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="furnitures")
public class Furnitures {
    @Id
    private String article;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Integer amount;

    @JoinColumn(nullable = true)
    @OneToOne
    private Suppliers main_supplier = null;

    @OneToMany(mappedBy = "furniture_type")
    private Set<Furniture_types> furniture_type;

    @Column(nullable = false)
    private BigDecimal purchase_price;

    @Column(nullable = false)
    private Integer weight;

    @Lob
    @Column(nullable = true)
    private byte[] image =null;
}
