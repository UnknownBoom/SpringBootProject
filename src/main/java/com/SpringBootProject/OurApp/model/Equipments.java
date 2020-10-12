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
    private String mark;

    @ElementCollection(targetClass = Equipment_types.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "equipment_type_2", joinColumns = @JoinColumn(name = "mark_id",nullable = true))
    @Enumerated(EnumType.STRING)
    private Set<Equipment_types> equipment_type;


    @Column(nullable = true)
    private String description =null;

}
