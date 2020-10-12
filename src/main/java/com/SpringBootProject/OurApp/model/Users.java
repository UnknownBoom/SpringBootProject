package com.SpringBootProject.OurApp.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "users_generator")
    @SequenceGenerator(name = "users_generator",sequenceName = "users_seq" ,allocationSize = 25,initialValue = 25)
    private Long id;

    private static final long serialVersionUID = 3486087007312642611L;

    @NaturalId(mutable = true)
    private String username;

    @NaturalId(mutable = true)
    @Column(name = "password")
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


    @Column(nullable = true)
    private String photo_name;

    @Transient
    private List<Orders> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id.equals(users.id) &&
                username.equals(users.username) &&
                password.equals(users.password) &&
                Objects.equals(surname, users.surname) &&
                Objects.equals(first_name, users.first_name) &&
                Objects.equals(patronymic, users.patronymic) &&
                Objects.equals(roles, users.roles) &&
                Objects.equals(photo_name, users.photo_name) &&
                Objects.equals(orders, users.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, surname, first_name, patronymic, roles, photo_name, orders);
    }
}
