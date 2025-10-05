package com.sebastian.cruddependencies.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public class DependencyRequest {
    @NotBlank(message = "Name is required.")
    @Size(min = 3, message = "Must be at least 3 characters")
    @Size(max = 150, message = "Maximum 150 characters")
    private String name;

    @NotBlank(message = "Address is required.")
    @Size(min = 3, message = "Must be at least 3 characters")
    @Size(max = 250, message = "Maximum 250 characters")
    private String address;

    @jakarta.validation.constraints.Email(message = "Invalid email format.")
    @Size(max = 100, message = "Maximum 150 characters")
    @NotBlank(message = "Email is required.")
    private String email;

    @NotBlank(message = "Telephone is required.")
    @Pattern(regexp = "\\d{10}", message = "Telephone must be exactly 10 digits")
    private String telephone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
