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
@Table(name = "furniture_types")
public class Furniture_types {
    @Id
    private Long furniture_type_id;

    @Column(nullable = false)
    private String furniture_type;

}
