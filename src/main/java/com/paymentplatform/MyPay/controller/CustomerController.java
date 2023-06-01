package com.paymentplatform.MyPay.controller;

import com.paymentplatform.MyPay.exception.ResourceNotFound;
import com.paymentplatform.MyPay.model.Customer;
import com.paymentplatform.MyPay.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping
    public List<Customer> getAllCustomers(){

        return customerRepo.findAll();
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer){
        return customerRepo.save(customer);
    }

    @GetMapping("{id}")

    public ResponseEntity<Customer> getCustomerById(long id){
        Customer customer = customerRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Customer not exist"));
        return ResponseEntity.ok(customer);
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customerDetails){
        Customer updateCustomer = customerRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Customer not exist"));
        updateCustomer.setPhoneNo(customerDetails.getPhoneNo());
        updateCustomer.setNicNo(customerDetails.getNicNo());
        updateCustomer.setFirstname(customerDetails.getFirstname());
        updateCustomer.setLastname(customerDetails.getLastname());
        updateCustomer.setAddress(customerDetails.getAddress());
        updateCustomer.setPassword(customerDetails.getPassword());

        customerRepo.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);
    }
@DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable long id){

        Customer customer = customerRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Customer not exist"));
        customerRepo.delete(customer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
