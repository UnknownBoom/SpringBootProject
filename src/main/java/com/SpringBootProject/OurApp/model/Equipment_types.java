package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "equipment_types")
public class Equipment_types {
    @Id
    private Long equipment_type_id;


    private String equipment_type;

}
