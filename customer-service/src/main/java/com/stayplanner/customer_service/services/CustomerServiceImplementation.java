package com.stayplanner.customer_service.services;

import com.stayplanner.customer_service.exception.CustomerIdDoesNotExist;
import com.stayplanner.customer_service.model.Customer;
import com.stayplanner.customer_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerDAO {

    @Autowired
    CustomerRepository repo ;
    @Override
    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public List<Customer> viewAllCustomers() {
        return repo.findAll();
    }

    @Override
    public Customer updateCustomer(int customerId, Customer customer) throws CustomerIdDoesNotExist {
        Optional<Customer> optionalCustomer = repo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();

            // Update the fields of the existing customer with the new customer details
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setGender(customer.getGender());
            existingCustomer.setState(customer.getState());
            existingCustomer.setCity(customer.getCity());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setDescription(customer.getDescription());

            // Save the updated customer details
            return repo.save(existingCustomer);
        } else {
            throw new CustomerIdDoesNotExist("Customer not found with id: " + customerId);
        }
    }


    @Override
    public void deleteCustomer(int customerId) throws CustomerIdDoesNotExist {
        Optional<Customer> optionalCustomer = repo.findById(customerId);
        if (optionalCustomer.isPresent()) {
            repo.deleteById(customerId);
        } else {
            throw new CustomerIdDoesNotExist("Customer not found with id: " + customerId);
        }
    }

}
