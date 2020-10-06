package com.SpringBootProject.OurApp.model;


import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NaturalId
    private String username;
    @NaturalId
    private String password;

    private String  surname ;

    private String name_patronymic;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> role;

    @Lob
    @Column(nullable = true)
    private byte[] photo;

}
