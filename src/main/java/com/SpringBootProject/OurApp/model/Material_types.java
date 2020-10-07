package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="material_types")
public class Material_types {
    @Id
    private Long material_type_id;

    @Column(nullable = false)
    private String material_type;

}
