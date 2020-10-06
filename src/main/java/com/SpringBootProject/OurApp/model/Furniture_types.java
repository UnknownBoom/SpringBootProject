package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String furniture_type;

}
