package com.SpringBootProject.OurApp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders implements Serializable {
     @Id
     private Long order_id;

     private Date order_date;

     private String order_name;

     @ManyToOne
     @JoinColumn(name = "product_type_id")
     private Product_types product_type;

     @ManyToOne
     @JoinColumn(name = "customer_id",nullable = false)
     private Users customer;

     @ManyToOne
     @JoinColumn(name = "manager_id",nullable = true)
     private Users manager = null;

     @Column(nullable = true)
     private java.math.BigDecimal price =null;

     @Column(nullable = true)
     private Date planed_date_end =null;

     @Column(nullable = true)
     @Lob
     private byte[] order_schemes =null;
}
