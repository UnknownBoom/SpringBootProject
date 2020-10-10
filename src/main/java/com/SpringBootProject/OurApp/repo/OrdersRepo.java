package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Orders;
import com.SpringBootProject.OurApp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository<Orders,Long> {
    Orders findById(long parseLong);
}
