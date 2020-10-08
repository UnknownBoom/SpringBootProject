package com.SpringBootProject.OurApp.service;

import com.SpringBootProject.OurApp.model.Roles;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private UsersRepo usersRepo;

    private PasswordEncoder passwordEncoder;

    public UserService(UsersRepo usersRepo, PasswordEncoder passwordEncoder) {
        this.usersRepo = usersRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean addUser(Users user){
        Users user_db = usersRepo.findByUsername(user.getUsername());
        if(user_db!=null){
            return false;
        }
        user.setRoles(Collections.singleton(Roles.Customer));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersRepo.save(user);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepo.findByUsername(username);
        if(user!=null){
            return user;
        }else{
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
