package com.SpringBootProject.OurApp.model;


import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NaturalId
    private String username;
    @NaturalId
    private String password;

    @Column(nullable = true)
    private String  surname  = null ;

    @Column(nullable = true)
    private String first_name  = null ;

    @Column(nullable = true)
    private String patronymic = null;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

    @Lob
    @Column(nullable = true)
    private byte[] photo  = null ;

}
