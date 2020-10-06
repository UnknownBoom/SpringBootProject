package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<Users,Long> {
    Iterable<Users> findUsersById(Long id);
     Iterable<Users>  findAll();

}
