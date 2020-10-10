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
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Suppliers main_supplier = null;

    @ElementCollection(targetClass = Furniture_types.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "furniture_type", joinColumns = @JoinColumn(name = "furniture_article"))
    @Enumerated(EnumType.STRING)
    private Set<Furniture_types> furniture_type;

    @Column(nullable = false)
    private BigDecimal purchase_price;

    @Column(nullable = false)
    private Integer weight;

    @Lob
    @Column(nullable = true)
    private byte[] image =null;
}
