package com.SpringBootProject.OurApp.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

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
    @JoinColumn(nullable = true,name = "main_supplier_id")

    private Suppliers main_supplier =null;

    @Column(nullable = true)
    @Lob
    private byte[] image =null;

    @ElementCollection(targetClass = Material_types.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "material_type", joinColumns = @JoinColumn(name = "material_article"))
    @Enumerated(EnumType.STRING)
    private Set<Material_types> material_types;

    @Column(nullable = false)
    private BigDecimal purchase_price;

    @Column(nullable = true)
    private String gost =null;

    @Column(nullable = true)
    private Integer length =null;

    @Column(nullable = true)
    private String description =null;

}
