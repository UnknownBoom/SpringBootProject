package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends JpaRepository<Users,Long> {
    Iterable<Users> findUsersById(Long id);
    Users findByUsername(String username);

}
