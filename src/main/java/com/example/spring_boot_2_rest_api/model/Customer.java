package com.example.spring_boot_2_rest_api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "phoneNumber", "name", "email", "gender", "address"})
public class Customer {
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("email")
    private String email;
}
