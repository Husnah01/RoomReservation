
package com.example.hotelreservationsystem.service;

import com.example.hotelreservationsystem.entity.Customer;
import com.example.hotelreservationsystem.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("The customer is not found"));
    }

    public Customer updateCustomer(Long id, Customer details) {
        Customer customer = getCustomerById(id);

        customer.setFullName(details.getFullName());
        customer.setEmail(details.getEmail());
        customer.setPhoneNumber(details.getPhoneNumber());
        customer.setAddress(details.getAddress());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}