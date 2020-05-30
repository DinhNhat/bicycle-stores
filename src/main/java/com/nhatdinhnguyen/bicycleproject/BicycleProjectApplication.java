package com.nhatdinhnguyen.bicycleproject;

import com.nhatdinhnguyen.bicycleproject.db.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BicycleProjectApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StockRepository stockRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(BicycleProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring boot 2 version.");
		System.out.println("***********Original Categories*************");
		this.categoryRepository.findAll().forEach(System.out::println);
		System.out.println("Total number of categories " + categoryRepository.count());
		System.out.println("***********Original order items*************");
		System.out.println("Total number of order items " + orderItemRepository.count());
//		String myOrderDate = "2016-01-01";
//		Date orderDate = DateUtils.createDateFormatString(myOrderDate);
//		System.out.println("My order date is: " + orderDate);
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd").format();

//		System.out.println("***********Original Customers*************");
//		this.customerRepository.findAll().forEach(System.out::println);
//		System.out.println("Total number of customers " + customerRepository.count());

//		System.out.println("***********Original Staffs*************");
//		this.staffRepository.findAll().forEach(System.out::println);
//		System.out.println("Total number of staffs " + staffRepository.count());
//
//		System.out.println("Total row in finding products by category id and category name: " +
//				this.productRepository.findByCategory_IdAndCategory_Name(6, "Mountain Bikes").size());
//
//		System.out.println("***********Original Stocks*************");
//		this.stockRepository.findAll().forEach(System.out::println);
//		System.out.println("Total number of stocks " + stockRepository.count());
	}
}
