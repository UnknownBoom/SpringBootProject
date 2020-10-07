package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="operation_specification")
public class Operation_specification implements Serializable {

    @Id
    private Long operation_id;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Product_types product_type;

    @Id
    @ManyToOne
    @JoinColumn(nullable = false)
    private Operations operation;

    @ManyToOne
    @JoinColumn(nullable = true)
    private  Equipment_types equipment_type;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date operation_time;

}
