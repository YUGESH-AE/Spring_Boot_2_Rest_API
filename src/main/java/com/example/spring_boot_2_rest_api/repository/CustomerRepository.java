package com.example.spring_boot_2_rest_api.repository;

import com.example.spring_boot_2_rest_api.entity.CustomerEntity;
import com.example.spring_boot_2_rest_api.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class CustomerRepository {

    @Autowired
    private CustomerEntityRepository customerEntityRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public void insertCustomer(Customer customer){
        if(Objects.nonNull(customer)){

            CustomerEntity customerEntity=objectMapper.convertValue(customer, CustomerEntity.class);
            customerEntityRepository.save(customerEntity);
        }else throw new IllegalStateException("Customer Object is null");
    }

    public Customer getCustomer(String phoneNumber){
        Optional<CustomerEntity> customerEntity=customerEntityRepository.findById(phoneNumber);
        if(customerEntity.isPresent()){
            Customer customer=objectMapper.convertValue(customerEntity.get(), Customer.class);
            return customer;
        }else throw new IllegalStateException("No Such customer exists");
    }

    public void updateCustomer(Customer customer){
        if(Objects.nonNull(customer)){
            CustomerEntity customerEntity=objectMapper.convertValue(customer, CustomerEntity.class);
            Optional<CustomerEntity> getsCustomer=customerEntityRepository.findById(customer.getPhoneNumber());
            if(getsCustomer.isPresent()){
                CustomerEntity customerEntityNew=new CustomerEntity(
                        getsCustomer.get().getPhoneNumber(),
                        getsCustomer.get().getName(),
                        getsCustomer.get().getAddress(),
                        getsCustomer.get().getGender(),
                        getsCustomer.get().getEmail()
                );
                customerEntityRepository.save(customerEntityNew);
            }

        }else throw new IllegalStateException("No Such customer exists");
    }

    public void deleteCustomer(Customer customer){
        CustomerEntity customerEntity=objectMapper.convertValue(customer, CustomerEntity.class);

        Optional<CustomerEntity>optionalCustomerEntity=customerEntityRepository.findById(customerEntity.getPhoneNumber());
        if(optionalCustomerEntity.isPresent()){
            customerEntityRepository.delete(optionalCustomerEntity.get());
        }else throw new IllegalStateException("No such customer exists");
    }
}
