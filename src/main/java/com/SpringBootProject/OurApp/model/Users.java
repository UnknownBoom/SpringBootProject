package com.SpringBootProject.OurApp.model;


import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "users_generator")
    @SequenceGenerator(name = "users_generator",sequenceName = "users_seq" ,allocationSize = 25,initialValue = 25)
    private Long id;

    @NaturalId
    @NotBlank(message = "Username cannot be empty")
    private String username;

    @NaturalId
    @Column(name = "password")
    @Pattern(regexp = "(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$",message = "Weak password *(Sorry)")
    @NotBlank(message = "Password cannot be empty")
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
}
