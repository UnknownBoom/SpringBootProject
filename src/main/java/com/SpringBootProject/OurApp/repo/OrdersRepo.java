package com.SpringBootProject.OurApp.repo;

import com.SpringBootProject.OurApp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepo extends JpaRepository<Orders,Long> {
    Orders findById(long id);
    @Query(value = "SELECT o.order_id,o.order_date,o.order_name,o.order_schemes,o.planed_date_end,o.price,o.customer_id,o.manager_id,o.product_type_id FROM users u INNER JOIN orders o ON u.id = o.customer_id OR u.id = o.manager_id where u.id = ?1",nativeQuery = true)
    Iterable<Orders> findOrdersByUser_idList(Long id);
    @Query(value = "select  * from orders where order_name = ?1",nativeQuery = true)
    Orders findByOrder_name(String order_name);
}
