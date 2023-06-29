package com.example.spring_boot_2_rest_api.controller;


import com.example.spring_boot_2_rest_api.model.Customer;
import com.example.spring_boot_2_rest_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/insertcustomer",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> insertCustomer(@RequestBody Customer customer) {
        Customer customer1=customerService.insertCustomer(customer);
        if(Objects.nonNull(customer1)){
            return ResponseEntity.ok(customer1);
        }else {
            return (ResponseEntity<Customer>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/getcustomer/phone/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomer(@PathVariable("phone") String phoneNumber ){
        return ResponseEntity.ok(customerService.getCustomer(phoneNumber));
    }

    @PutMapping(path = "/updatecustomer",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
        Customer customer1=customerService.updateCustomer(customer);
        if(Objects.nonNull(customer1)){
            return ResponseEntity.ok(customer1);
        }else {
            return (ResponseEntity<Customer>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/deletecustomer",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer>deleteCustomer(@RequestBody Customer customer){
        Customer customer1=customerService.deleteCustomer(customer);
        if(Objects.nonNull(customer1)){
            return ResponseEntity.ok(customer1);
        }else {
            return (ResponseEntity<Customer>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }
}
