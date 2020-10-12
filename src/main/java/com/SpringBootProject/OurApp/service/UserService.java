package com.SpringBootProject.OurApp.service;

import com.SpringBootProject.OurApp.Validator.UsersValidator;
import com.SpringBootProject.OurApp.model.Roles;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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

    public void editUser( Users user_origin,
                           Long id,
                           String username,
                           String password,
                           String first_name,
                           String surname,
                           String patronymic,
                           Model model){
        user_origin.setUsername(username);
        if(password!=null && !password.isEmpty()){
            if(UsersValidator.validatePassword(password)){
                user_origin.setPassword(passwordEncoder.encode(password));
            }else{
                model.addAttribute("errors","weak password");
                return ;
            }
        }
        user_origin.setFirst_name(first_name);
        user_origin.setSurname(surname);
        user_origin.setPatronymic(patronymic);
        usersRepo.save(user_origin);
    }
}
