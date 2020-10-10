package com.SpringBootProject.OurApp;

import com.SpringBootProject.OurApp.model.Orders;
import com.SpringBootProject.OurApp.model.Roles;
import com.SpringBootProject.OurApp.model.Users;
import com.SpringBootProject.OurApp.repo.OrdersRepo;
import com.SpringBootProject.OurApp.repo.UsersRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
class OurAppApplicationTests {
	@Autowired
	OrdersRepo ordersRepo;

	@Autowired
	UsersRepo usersRepo;
	@Test
	void contextLoads() {
		Users users = new Users();
		users.setPassword("qWe1@3");
		users.setUsername("101");
		users.setRoles(Collections.singleton(Roles.Customer));
//		usersRepo.save(users);

		Users users1 = new Users();
		users1.setPassword("qWe1@3");
		users1.setUsername("102");
		users1.setRoles(Collections.singleton(Roles.Manager));
//		usersRepo.save(users1);
		Orders orders = new Orders();
		orders.setCustomer(usersRepo.findByUsername("101"));
		orders.setManager(usersRepo.findByUsername("102"));
		orders.setOrder_id(1L);
		orders.setOrder_schemes(new byte[12]);
		ordersRepo.save(orders);
	}

}
