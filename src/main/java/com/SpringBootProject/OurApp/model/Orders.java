package com.SpringBootProject.OurApp.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Orders implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Orders_generator")
     @SequenceGenerator(name = "Orders_generator",sequenceName = "Orders_seq" ,allocationSize = 25,initialValue = 25)
     private Long order_id;

     @Column(nullable = false)
     private Date order_date;

     private String order_name;

     @ManyToOne
     @JoinColumn(name = "product_type_id")
     private Product_types product_type;

     @JoinColumn(name = "customer_id",nullable = false)
     @OneToOne
     private Users customer;

     @OneToOne
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
