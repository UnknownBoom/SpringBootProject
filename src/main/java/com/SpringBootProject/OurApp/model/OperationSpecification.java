package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="operation_specification")
public class OperationSpecification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "OperationSpecification_gen")
    @SequenceGenerator(name = "OperationSpecification_gen",sequenceName = "OperationSpecification_seq" ,allocationSize = 25,initialValue = 25)
    private Long operation_specification_id;

    @NaturalId
    @ManyToOne
    @JoinColumn(nullable = false,name = "product_type_id")
    private Product_types product_type;

    @ElementCollection(targetClass = Operations.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "operation_type", joinColumns = @JoinColumn(name = "operation_id",nullable = true))
    @Enumerated(EnumType.STRING)
    private Set<Operations> operation;

    @ElementCollection(targetClass = Equipment_types.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "equipment_type_1", joinColumns = @JoinColumn(name = "operation_specification_id"))
    @Enumerated(EnumType.STRING)
    private Set<Equipment_types> equipment_type =null;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date operation_time;

}
