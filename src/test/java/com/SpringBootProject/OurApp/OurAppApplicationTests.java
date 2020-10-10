package com.SpringBootProject.OurApp;

import com.SpringBootProject.OurApp.model.*;
import com.SpringBootProject.OurApp.repo.*;


import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.*;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class OurAppApplicationTests {
	@Autowired
	OrdersRepo ordersRepo;

	@Autowired
	UsersRepo usersRepo;

	@Autowired
	private FurnituresRepo furnituresRepo;

	@Autowired
	private SuppliersRepo suppliersRepo;

	@Autowired
	private OperationSpecificationRepo operationSpecificationRepo;


	@Autowired
	Product_typesRepo product_typesRepo;

	@Autowired
	MaterialsRepo materialsRepo;


	@Test
	void ainsertUsers(){
		Users users = new Users();
		users.setPassword("qWe1@3");
		users.setUsername("101");
		users.setRoles(Collections.singleton(Roles.Customer));
		usersRepo.save(users);

		Users users1 = new Users();
		users1.setPassword("qWe1@3");
		users1.setUsername("102");
		users1.setRoles(Collections.singleton(Roles.Manager));
		usersRepo.save(users1);
	}

	@Test
	void binsertOrders(){
		Orders orders = new Orders();
		orders.setCustomer(usersRepo.findByUsername("101"));
		orders.setManager(usersRepo.findByUsername("102"));
		orders.setOrder_date(Date.valueOf("2015-12-12"));
		orders.setOrder_schemes(new byte[12]);
		ordersRepo.save(orders);
	}




	@Test
	void dinsertSuppliers(){
		Suppliers suppliers = new Suppliers();
		suppliers.setAddress("LENINA");
		suppliers.setDelivery_period(3);
		suppliers.setSupplier_name("VIKTOR");
		suppliersRepo.save(suppliers);
	}

	@Test
	void einsertFurnitures(){

		Furnitures furnitures = new Furnitures();
		furnitures.setArticle("Tm akk");
		furnitures.setAmount(22);
		furnitures.setFurniture_type(Collections.singleton(Furniture_types.Test));
		furnitures.setProduct_name("test");
		furnitures.setPurchase_price(new BigDecimal(333));
		furnitures.setUnit("ones");
		furnitures.setWeight(100);
		furnitures.setMain_supplier(suppliersRepo.findById(25L).get());
		furnituresRepo.save(furnitures);
	}

	@Test
	void fdeleteusers(){
		Users byUsername = usersRepo.findByUsername("101");
		if(byUsername!=null) usersRepo.delete(byUsername);
		else{
			System.out.println("Is null");
			List<Users> all = usersRepo.findAll();
			all.forEach(t-> System.out.println(t.getSurname()));
		}

	}

	@Test
	void gainsertserecOpp(){
		Product_types product_types = new Product_types();
		product_types.setDimensions(100);
		product_types.setProduct_type_name("Test1");
		product_typesRepo.save(product_types);


	}

	@Test
	void hInsertScpecOpp(){
		OperationSpecification operationSpecification = new OperationSpecification();
		operationSpecification.setEquipment_type(Collections.singleton(Equipment_types.Test));
		operationSpecification.setOperation(Collections.singleton(Operations.TYP1));
		operationSpecification.setOperation_time(Date.valueOf("2015-12-12"));
		operationSpecification.setOperation_specification(25L);
		operationSpecification.setProduct_type(product_typesRepo.findAll().get(0));
		operationSpecificationRepo.save(operationSpecification);

	}
	@Test
	void jInsertmaterials(){
		Materials materials = new Materials();
		materials.setAmount(13);
		materials.setArticle("TM");
		materials.setGost("TMGOST");
		materials.setLength(900);
		materials.setUnit("test");
		materials.setProduct_name("TEst");
		materials.setMaterial_types(Collections.singleton(Material_types.TEst));
		materials.setMain_supplier(suppliersRepo.findAll().get(0));
		materials.setPurchase_price(new BigDecimal(123));
		materialsRepo.save(materials);
	}


	@Test
	void contextLoads() {

	}

}
