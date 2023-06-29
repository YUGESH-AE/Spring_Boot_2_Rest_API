package com.example.spring_boot_2_rest_api.service;

import com.example.spring_boot_2_rest_api.model.Customer;
import com.example.spring_boot_2_rest_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer insertCustomer(Customer customer){
        try {
            customerRepository.insertCustomer(customer);
            return customerRepository.getCustomer(customer.getPhoneNumber());
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        return null;
    }

    public Customer getCustomer(String phoneNumber){

        return customerRepository.getCustomer(phoneNumber);
    }

    public Customer updateCustomer(Customer customer){
        try {
            customerRepository.updateCustomer(customer);

            return customerRepository.getCustomer(customer.getPhoneNumber());
        }
        catch (IllegalArgumentException e){
            System.out.println(e);
        }
        return null;
    }

    public Customer deleteCustomer(Customer customer){
        try {
            customerRepository.deleteCustomer(customer);
            return customer;
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
        return null;
    }
}
