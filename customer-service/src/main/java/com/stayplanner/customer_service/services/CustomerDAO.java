package com.stayplanner.customer_service.services;

import com.stayplanner.customer_service.exception.CustomerIdDoesNotExist;
import com.stayplanner.customer_service.model.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer addCustomer(Customer customer) ;
    List<Customer> viewAllCustomers() ;
    Customer updateCustomer(int customerId , Customer customer) throws CustomerIdDoesNotExist ;
    void deleteCustomer(int customerId) throws CustomerIdDoesNotExist;
}
