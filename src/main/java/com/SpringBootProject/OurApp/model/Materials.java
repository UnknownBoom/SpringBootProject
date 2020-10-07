package com.SpringBootProject.OurApp.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@Table(name="materials")
public class Materials {
    @Id
    private String article;

    @Column(nullable = false)
    private String product_name;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private Integer amount;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Suppliers main_supplier =null;

    @Column(nullable = true)
    @Lob
    private byte[] image =null;

    @JoinColumn(nullable = false)
    @OneToOne
    private Material_types material_types;

    @Column(nullable = false)
    private BigDecimal purchase_price;

    @Column(nullable = true)
    private String gost =null;

    @Column(nullable = true)
    private Integer length =null;

    @Column(nullable = true)
    private String description =null;

}
