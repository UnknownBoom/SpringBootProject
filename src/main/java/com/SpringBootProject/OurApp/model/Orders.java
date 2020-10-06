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

     @OneToOne(mappedBy = "")
     private Product_types product_type;

     @OneToOne(cascade = CascadeType.ALL)
     private Users customer;

     @OneToOne(cascade = CascadeType.ALL)
     private Users manager;

     private java.math.BigDecimal price;

     private Date planed_date_end;

     @Lob
     private byte[] order_schemes;
}
