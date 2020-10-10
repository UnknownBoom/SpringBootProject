package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "equipments")
public class Equipments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "suppliers_generator")
    @SequenceGenerator(name = "suppliers_generator",sequenceName = "suppliers_seq" ,allocationSize = 25,initialValue = 25)
    private String mark;

    @ManyToOne
    @JoinColumn(nullable = false,name = "equipment_type_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Equipment_types equipment_type;

    @Column(nullable = true)
    private String description =null;

}
