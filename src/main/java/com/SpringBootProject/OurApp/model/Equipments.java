package com.SpringBootProject.OurApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "equipments")
public class Equipments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "suppliers_generator")
    @SequenceGenerator(name = "suppliers_generator",sequenceName = "suppliers_seq" ,allocationSize = 25,initialValue = 25)
    private String mark;

    @ElementCollection(targetClass = Equipment_types.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "equipment_type", joinColumns = @JoinColumn(name = "mark_id"))
    @Enumerated(EnumType.STRING)
    private Set<Equipment_types> equipment_type;


    @Column(nullable = true)
    private String description =null;

}
