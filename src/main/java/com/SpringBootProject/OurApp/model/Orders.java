package com.SpringBootProject.OurApp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "orsers")
public class Orders implements Serializable {
     @Id
     private Long order_id;

     private Date order_date;

     private String order_name;

     private String product_type;

//     @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Users.class,mappedBy = "users")
//     private Users customer;
//
//     @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,targetEntity = Users.class,mappedBy="users")
//     private Users manager;

     private java.math.BigDecimal price;

     private Date planed_date_end;

     @Lob
     private byte[] order_schemes;

//     public Orders(Users customer, Users manager) {
//          this.customer = customer;
//          this.manager = manager;
//     }
}
