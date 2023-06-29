package com.example.spring_boot_2_rest_api.repository;

import com.example.spring_boot_2_rest_api.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, String> {
}