package com.stayplanner.customer_service.controller;

import com.stayplanner.customer_service.exception.CustomerIdDoesNotExist;
import com.stayplanner.customer_service.model.Customer;
import com.stayplanner.customer_service.services.CustomerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    CustomerServiceImplementation service;

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(service.addCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/viewAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        return new ResponseEntity<List<Customer>>(service.viewAllCustomers(), HttpStatus.OK);
    }

    @PutMapping("/updateCustomer/{customerId}")
    public ResponseEntity<?> updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        try {
            Customer updatedCustomer = service.updateCustomer(customerId, customer);
            return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.OK);
        } catch (CustomerIdDoesNotExist e) {
            return new ResponseEntity<String>("Customer not found with id: " + customerId, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int customerId) {
        try {
            service.deleteCustomer(customerId);
            return new ResponseEntity<String>("Customer deleted successfully.", HttpStatus.OK);
        } catch (CustomerIdDoesNotExist e) {
            return new ResponseEntity<String>("Customer not found with id: " + customerId, HttpStatus.NOT_FOUND);
        }
    }

}
