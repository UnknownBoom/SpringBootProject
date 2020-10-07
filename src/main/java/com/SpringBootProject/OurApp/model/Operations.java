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
@Table(name="operations")
public class Operations {
    @Id
    private Long operation_id;

    @Column(nullable = false)
    private String operation_name;
}
