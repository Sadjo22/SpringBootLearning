package com.peguycode.demo.Customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
@Table
public class customer {

    @Id
    private  Long id;
    @NotBlank

    private  String name;
    @NotBlank(message = "password is compulsory")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String password;

    private String email;
    public customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public customer() {

    }

    @JsonProperty("customerId")
    public Long getId() {
        return id;
    }
    @Size(min = 2, max = 10, message = "Name must not be less than 2 characters and greater than 10 ")
    public String getName() {
        return name;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @NotNull(message = "the email is compulsory")
    @Email(message = "Email not valid", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                                                   + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "customer{" +
                "id=" + id +
                ", name='" + name +
                ", password='" + password +
                ", email='" + email + '\'' +
                '}';
    }
}
