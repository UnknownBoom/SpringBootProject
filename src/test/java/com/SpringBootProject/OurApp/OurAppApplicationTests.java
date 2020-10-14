package com.SpringBootProject.OurApp;

import com.SpringBootProject.OurApp.model.*;
import com.SpringBootProject.OurApp.repo.*;
import com.SpringBootProject.OurApp.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collections;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class OurAppApplicationTests {
	@Autowired
	OrdersRepo ordersRepo;

	@Autowired
	UsersRepo usersRepo;
	@Autowired
	UserService userService;

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

	@Autowired
	Specification_furnitureRepo specification_furnitureRepo;

	@Autowired
	Specification_materialsRepo specification_materialsRepo;

	@Autowired
	Specification_unitRepo specification_unitRepo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	void ainsertUsers(){
		Users users = new Users();
		users.setPassword(passwordEncoder.encode("customer"));
		users.setUsername("Customer");
		users.setRoles(Collections.singleton(Roles.Customer));
		usersRepo.save(users);

		Users users1 = new Users();
		users1.setPassword(passwordEncoder.encode("manager"));
		users1.setUsername("Manager");
		users1.setRoles(Collections.singleton(Roles.Manager));
		usersRepo.save(users1);

		Users users2 = new Users();
		users2.setPassword(passwordEncoder.encode("director"));
		users2.setUsername("Director");
		users2.setRoles(Collections.singleton(Roles.Director));
		usersRepo.save(users2);

		Users users3 = new Users();
		users3.setPassword(passwordEncoder.encode("deputy_director"));
		users3.setUsername("Deputy_director");
		users3.setRoles(Collections.singleton(Roles.Deputy_director));
		usersRepo.save(users3);

		Users users4 = new Users();
		users4.setPassword(passwordEncoder.encode("master"));
		users4.setUsername("Master");
		users4.setRoles(Collections.singleton(Roles.Master));
		usersRepo.save(users4);
	}


	@Test
	void aaainsertOrders(){
		Orders orders = new Orders();
		orders.setCustomer(usersRepo.findByUsername("Customer"));
		orders.setManager(usersRepo.findByUsername("Deputy_director"));
		orders.setOrder_date(Date.valueOf("2015-12-12"));
		ordersRepo.save(orders);

		Orders orders1 = new Orders();
		orders1.setCustomer(usersRepo.findByUsername("Master"));
		orders1.setManager(usersRepo.findByUsername("Customer"));
		orders1.setOrder_date(Date.valueOf("2015-12-13"));
		ordersRepo.save(orders1);

		Orders orders2 = new Orders();
		orders2.setCustomer(usersRepo.findByUsername("Director"));
		orders2.setManager(usersRepo.findByUsername("Master"));
		orders2.setOrder_date(Date.valueOf("2015-12-14"));
		ordersRepo.save(orders2);

		Orders orders3 = new Orders();
		orders3.setCustomer(usersRepo.findByUsername("Master"));
		orders3.setManager(usersRepo.findByUsername("Manager"));
		orders3.setOrder_date(Date.valueOf("2014-10-15"));
		ordersRepo.save(orders3);

		Orders orders4= new Orders();
		orders4.setCustomer(usersRepo.findByUsername("Manager"));
		orders4.setManager(usersRepo.findByUsername("customer"));
		orders4.setOrder_date(Date.valueOf("2012-10-16"));
		ordersRepo.save(orders4);
	}




	@Test
	void aaainsertSuppliers(){
		Suppliers suppliers = new Suppliers();
		suppliers.setAddress("Levina");
		suppliers.setDelivery_period(3);
		suppliers.setSupplier_name("Vika");
		suppliersRepo.save(suppliers);

		Suppliers suppliers1 = new Suppliers();
		suppliers1.setAddress("Samokovskaya");
		suppliers1.setDelivery_period(7);
		suppliers1.setSupplier_name("Dima");
		suppliersRepo.save(suppliers1);

		Suppliers suppliers2 = new Suppliers();
		suppliers2.setAddress("Lenina");
		suppliers2.setDelivery_period(5);
		suppliers2.setSupplier_name("Veniamin");
		suppliersRepo.save(suppliers2);

		Suppliers suppliers3 = new Suppliers();
		suppliers3.setAddress("Ijitskayz");
		suppliers3.setDelivery_period(2);
		suppliers3.setSupplier_name("Vktoria");
		suppliersRepo.save(suppliers3);

		Suppliers suppliers4 = new Suppliers();
		suppliers4.setAddress("Simanovskogo");
		suppliers4.setDelivery_period(4);
		suppliers4.setSupplier_name("Maksim");
		suppliersRepo.save(suppliers4);
	}

	@Test
	void aaaainsertFurnitures(){

//		Furnitures furnitures = new Furnitures();
//		furnitures.setArticle("dda");
//		furnitures.setAmount(23);
//		furnitures.setFurniture_type(Collections.singleton(Furniture_types.Test));
//		furnitures.setProduct_name("test1");
//		furnitures.setPurchase_price(new BigDecimal(334));
//		furnitures.setUnit("oness");
//		furnitures.setWeight(101);
//		furnitures.setMain_supplier(suppliersRepo.findById(25L).get());
//		furnituresRepo.save(furnitures);

		Furnitures furnitures1 = new Furnitures();
		furnitures1.setArticle("pgd");
		furnitures1.setAmount(24);
		furnitures1.setFurniture_type(Collections.singleton(Furniture_types.Test));
		furnitures1.setProduct_name("test2");
		furnitures1.setPurchase_price(new BigDecimal(335));
		furnitures1.setUnit("onesgfa");
		furnitures1.setWeight(100);
		furnitures1.setMain_supplier(suppliersRepo.findById(25L).get());
		furnituresRepo.save(furnitures1);

		Furnitures furnitures2 = new Furnitures();
		furnitures2.setArticle("fsfs");
		furnitures2.setAmount(25);
		furnitures2.setFurniture_type(Collections.singleton(Furniture_types.Test));
		furnitures2.setProduct_name("test3");
		furnitures2.setPurchase_price(new BigDecimal(336));
		furnitures2.setUnit("onesaw");
		furnitures2.setWeight(100);
		furnitures2.setMain_supplier(suppliersRepo.findById(50L).get());
		furnituresRepo.save(furnitures2);

		Furnitures furnitures3 = new Furnitures();
		furnitures3.setArticle("fsfs");
		furnitures3.setAmount(26);
		furnitures3.setFurniture_type(Collections.singleton(Furniture_types.Test));
		furnitures3.setProduct_name("test4");
		furnitures3.setPurchase_price(new BigDecimal(337));
		furnitures3.setUnit("onesq");
		furnitures3.setWeight(100);
		furnitures3.setMain_supplier(suppliersRepo.findBySupplier_name("Maksim"));
		furnituresRepo.save(furnitures3);

		Furnitures furnitures4 = new Furnitures();
		furnitures4.setArticle("sfafs");
		furnitures4.setAmount(27);
		furnitures4.setFurniture_type(Collections.singleton(Furniture_types.Test));
		furnitures4.setProduct_name("test5");
		furnitures4.setPurchase_price(new BigDecimal(338));
		furnitures4.setUnit("oness");
		furnitures4.setWeight(100);
		furnitures4.setMain_supplier(suppliersRepo.findBySupplier_name("Vktoria"));
		furnituresRepo.save(furnitures4);
	}


	@Test
	void aaaaaainsertprod_types(){
		Product_types product_types = new Product_types();
		product_types.setDimensions(12);
		product_types.setProduct_type_name("Self-tapping screw with countersunk cross head");
		product_typesRepo.save(product_types);
	}
	@Test
	void aaaaaaainsertprod_types1(){
		Product_types product_types = new Product_types();
		product_types.setDimensions(6);
		product_types.setProduct_type_name("fsfs");
		product_typesRepo.save(product_types);
	}
	@Test
	void bainsertprod_types2(){
		Product_types product_types = new Product_types();
		product_types.setDimensions(1);
		product_types.setProduct_type_name("Concealed bronze hinge D10, chipboard 16 mm");
		product_typesRepo.save(product_types);
	}
	@Test
	void bbainsertprod_types3(){
		Product_types product_types = new Product_types();
		product_types.setDimensions(3);
		product_types.setProduct_type_name("Self-tapping screw with a semicircular head for a cross");
		product_typesRepo.save(product_types);
	}
	@Test
	void bbbainsertprod_types4(){
		Product_types product_types = new Product_types();
		product_types.setDimensions(2);
		product_types.setProduct_type_name("Set hinges for glass. doors, black");
		product_typesRepo.save(product_types);
	}
	@Test
	void bbbbainsertprod_types5(){
		Product_types product_types = new Product_types();
		product_types.setDimensions(4);
		product_types.setProduct_type_name("Set hinges for glass. doors + handle, matt chrome");
		product_typesRepo.save(product_types);
	}

	@Test
	void bbbbbbInsertScpecOpp(){
		OperationSpecification operationSpecification1 = new OperationSpecification();
		operationSpecification1.setEquipment_type(Collections.singleton(Equipment_types.Test));
		operationSpecification1.setOperation(Collections.singleton(Operations.TYP1));
		operationSpecification1.setOperation_time(Date.valueOf("2015-12-13"));
		operationSpecification1.setProduct_type(product_typesRepo.findAll().get(0));
		operationSpecificationRepo.save(operationSpecification1);

		OperationSpecification operationSpecification2 = new OperationSpecification();
		operationSpecification2.setEquipment_type(Collections.singleton(Equipment_types.Test));
		operationSpecification2.setOperation(Collections.singleton(Operations.TYP1));
		operationSpecification2.setOperation_time(Date.valueOf("2015-12-14"));
		operationSpecification2.setProduct_type(product_typesRepo.findAll().get(1));
		operationSpecificationRepo.save(operationSpecification2);

		OperationSpecification operationSpecification3 = new OperationSpecification();
		operationSpecification3.setEquipment_type(Collections.singleton(Equipment_types.Test));
		operationSpecification3.setOperation(Collections.singleton(Operations.TYP1));
		operationSpecification3.setOperation_time(Date.valueOf("2015-12-15"));
		operationSpecification3.setProduct_type(product_typesRepo.findAll().get(2));
		operationSpecificationRepo.save(operationSpecification3);

		OperationSpecification operationSpecification4 = new OperationSpecification();
		operationSpecification4.setOperation(Collections.singleton(Operations.TYP1));
		operationSpecification4.setOperation_time(Date.valueOf("2015-12-16"));
		operationSpecification4.setProduct_type(product_typesRepo.findAll().get(3));
		operationSpecificationRepo.save(operationSpecification4);

		OperationSpecification operationSpecification5 = new OperationSpecification();
		operationSpecification5.setEquipment_type(Collections.singleton(Equipment_types.Test));
		operationSpecification5.setOperation(Collections.singleton(Operations.TYPE));
		operationSpecification5.setOperation_time(Date.valueOf("2015-12-17"));
		operationSpecification5.setProduct_type(product_typesRepo.findAll().get(4));
		operationSpecificationRepo.save(operationSpecification5);

	}
	@Test
	void cInsertmaterials(){
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
	void ccInsertmaterials1(){
		Materials materials = new Materials();
		materials.setAmount(56);
		materials.setArticle("ARR");
		materials.setGost("TTTGOST");
		materials.setLength(778);
		materials.setUnit("test");
		materials.setProduct_name("BesttEST");
		materials.setMaterial_types(Collections.singleton(Material_types.TEst));
		materials.setMain_supplier(suppliersRepo.findAll().get(1));
		materials.setPurchase_price(new BigDecimal(556));
		materialsRepo.save(materials);
	}
//	@Value("${upload_path_users}")
//	String path;
//	@Test
//	void contextLoads() throws IOException {
//		File file = new File(path);
//		file.createNewFile();
//	}
//	@Test
//	void contextLoads1() throws IOException {
//		Iterable<Orders> ordersById = ordersRepo.findOrdersByUser_idList(25L);
//		ordersById.forEach(t-> System.out.println(t.getCustomer()));
//
//	}

	@Test
	void cccInsertspec_furn(){
		Specification_furniture specification_furniture = new Specification_furniture();
		specification_furniture.setAmount(123);
		specification_furniture.setFurniture(Furniture_types.Test);
		specification_furniture.setProduct_type(product_typesRepo.findAll().get(0));
		specification_furnitureRepo.save(specification_furniture);
	}
	@Test
	void cccaInsertspec_mat(){
		Specification_materials specification_materials = new Specification_materials();
		specification_materials.setMaterial(materialsRepo.findAll().get(1));
		specification_materials.setProduct_type(product_typesRepo.findAll().get(1));
		specification_materials.setAmount(123);
		specification_materialsRepo.save(specification_materials);

	}
	@Test
	void ccccbInsertspec_unit() {
		Specification_unit specification_unit = new Specification_unit();
		specification_unit.setProduct_unit(product_typesRepo.findAll().get(0));
		specification_unit.setAmount(256);
		specification_unitRepo.save(specification_unit);
	}

	@Test
	void cccccInsertspec_furn1(){
		Specification_furniture specification_furniture = new Specification_furniture();
		specification_furniture.setAmount(123);
		specification_furniture.setFurniture(Furniture_types.Test);
		Product_types product_types = product_typesRepo.findAll().get(0);
		specification_furniture.setProduct_type(product_types);
		specification_furnitureRepo.save(specification_furniture);
	}
	@Test
	void cccccaInsertspec_mat1(){
		Specification_materials specification_materials = new Specification_materials();
		specification_materials.setMaterial(materialsRepo.findAll().get(0));
		specification_materials.setProduct_type(product_typesRepo.findAll().get(0));
		specification_materials.setAmount(154);
		specification_materialsRepo.save(specification_materials);

	}
	@Test
	void cccccbInsertspec_unit1() {
		Specification_unit specification_unit = new Specification_unit();
		specification_unit.setProduct_unit(product_typesRepo.findAll().get(0));
		specification_unit.setProduct_type(product_typesRepo.findAll().get(0));
		specification_unit.setAmount(643);
		specification_unitRepo.save(specification_unit);
	}

	@Test
	void kInsertspec_furn2(){
		Specification_furniture specification_furniture = new Specification_furniture();
		specification_furniture.setAmount(125);
		specification_furniture.setFurniture(Furniture_types.Test);
		Product_types product_types = product_typesRepo.findAll().get(0);
		specification_furniture.setProduct_type(product_types);
		specification_furnitureRepo.save(specification_furniture);
	}
	@Test
	void kaInsertspec_mat2(){
		Specification_materials specification_materials = new Specification_materials();
		specification_materials.setMaterial(materialsRepo.findAll().get(0));
		specification_materials.setProduct_type(product_typesRepo.findAll().get(0));
		specification_materials.setAmount(895);
		specification_materialsRepo.save(specification_materials);

	}

	@Test
	void kInsertspec_furn3(){
		Specification_furniture specification_furniture = new Specification_furniture();
		specification_furniture.setAmount(127);
		specification_furniture.setFurniture(Furniture_types.TEst3);
		Product_types product_types = product_typesRepo.findAll().get(0);
		specification_furniture.setProduct_type(product_types);
		specification_furnitureRepo.save(specification_furniture);
	}
	@Test
	void kaInsertspec_mat3(){
		Specification_materials specification_materials = new Specification_materials();
		specification_materials.setMaterial(materialsRepo.findAll().get(0));
		specification_materials.setProduct_type(product_typesRepo.findAll().get(0));
		specification_materials.setAmount(344);
		specification_materialsRepo.save(specification_materials);

	}


	@Test
	void kInsertspec_furn4(){
		Specification_furniture specification_furniture = new Specification_furniture();
		specification_furniture.setAmount(128);
		specification_furniture.setFurniture(Furniture_types.Test);
		Product_types product_types = product_typesRepo.findAll().get(0);
		specification_furniture.setProduct_type(product_types);
		specification_furnitureRepo.save(specification_furniture);
	}
	@Test
	void kaInsertspec_mat4(){
		Specification_materials specification_materials = new Specification_materials();
		specification_materials.setMaterial(materialsRepo.findAll().get(0));
		specification_materials.setProduct_type(product_typesRepo.findAll().get(0));
		specification_materials.setAmount(865);
		specification_materialsRepo.save(specification_materials);

	}
	@Test
	void kbInsertspec_unit4() {
		Specification_unit specification_unit = new Specification_unit();
		specification_unit.setProduct_unit(product_typesRepo.findAll().get(0));
		specification_unit.setProduct_type(product_typesRepo.findAll().get(0));
		specification_unit.setAmount(835);
		specification_unitRepo.save(specification_unit);
	}

	@Test
	void kInsertspec_furn5(){
		Specification_furniture specification_furniture = new Specification_furniture();
		specification_furniture.setAmount(129);
		specification_furniture.setFurniture(Furniture_types.Test);
		Product_types product_types = product_typesRepo.findAll().get(0);
		specification_furniture.setProduct_type(product_types);
		specification_furnitureRepo.save(specification_furniture);
	}
	@Test
	void kaInsertspec_mat5(){
		Specification_materials specification_materials = new Specification_materials();
		specification_materials.setMaterial(materialsRepo.findAll().get(0));
		specification_materials.setProduct_type(product_typesRepo.findAll().get(0));
		specification_materials.setAmount(532);
		specification_materialsRepo.save(specification_materials);

	}
	@Test
	void kbInsertspec_unit5() {
		Specification_unit specification_unit = new Specification_unit();
		specification_unit.setProduct_unit(product_typesRepo.findAll().get(0));
		specification_unit.setProduct_type(product_typesRepo.findAll().get(0));
		specification_unit.setAmount(754);
		specification_unitRepo.save(specification_unit);
	}

	@Test
	void Testt(){
		Suppliers nikita = suppliersRepo.findBySupplier_name("Vika");
		System.out.println(nikita);
	}



}
