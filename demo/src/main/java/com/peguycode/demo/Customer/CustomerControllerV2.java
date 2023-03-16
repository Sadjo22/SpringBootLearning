package com.peguycode.demo.Customer;


import com.peguycode.demo.exception.ApiRequestException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

@RequestMapping(path = "api/v2/customers")
@RestController
public class CustomerControllerV2 {
    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("{customerId}")
    public customer getCustomer(@PathVariable("customerId") Long id){
        return customerService.getCustomer(id);
    }

    /*@GetMapping("{customerId}")
    public List<customer> getCustomersOrderByName(@PathVariable("customerId") Long id){
        return customerService.getCustomersOrdersByName(id);
    }*/

    @GetMapping("{customerId}/exception")
    public customer getCustomerException(@PathVariable("customerId") Long id){
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    record NewCustomer(Long id, String name,  String password, String email){};
    @PostMapping()
    public void addCustomer(@Validated @RequestBody  NewCustomer newCustomer){
        customer custo = new customer(newCustomer.id(),newCustomer.name(),newCustomer.password(),newCustomer.email());
        System.out.println("create a new customer");
        System.out.println(custo.getName()+' '+custo.getId());
    }

    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id){
        System.out.println("deleting a customer");
    }

    @PutMapping()
    public void updateCustomer(@RequestBody NewCustomer newCustomer){
        customer custo = new customer(newCustomer.id(),newCustomer.name(),newCustomer.password(),newCustomer.email());
        System.out.println("updating a customer");

    }
}
