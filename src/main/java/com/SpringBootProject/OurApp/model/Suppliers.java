package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="suppliers")
public class Suppliers {

    @Id
    private Long supplier_id;

    @NaturalId
    private String supplier_name;

    @Column(nullable = true)
    private String address =null;

    @Column(nullable = false)
    private Integer delivery_period;
}

