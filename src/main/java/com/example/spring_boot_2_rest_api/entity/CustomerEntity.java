package com.example.spring_boot_2_rest_api.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Column(name = "Name")
    private String name;
    @Column(name = "Address")
    private String address;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Email")
    private String email;
}