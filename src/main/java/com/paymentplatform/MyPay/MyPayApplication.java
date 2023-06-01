package com.paymentplatform.MyPay;

import com.paymentplatform.MyPay.model.Customer;
import com.paymentplatform.MyPay.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyPayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MyPayApplication.class, args);
	}
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer();
		customer.setPhoneNo(Integer.parseInt("0714360072"));
		customer.setNicNo("97040028");
		customer.setFirstname("malindu");
		customer.setLastname("darshana");
		customer.setAddress("matara");
		customer.setPassword("1234");
		customerRepo.save(customer);

	}
}
