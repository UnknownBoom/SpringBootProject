package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="operations")
public class Operations {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "suppliers_generator")
    @SequenceGenerator(name = "suppliers_generator",sequenceName = "suppliers_seq" ,allocationSize = 25,initialValue = 25)
    private Long operation_id;

    @Column(nullable = false)
    private String operation_name;
}
