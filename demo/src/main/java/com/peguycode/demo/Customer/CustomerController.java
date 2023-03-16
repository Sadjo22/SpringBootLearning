package com.peguycode.demo.Customer;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Deprecated
@RequestMapping(path = "api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value ="all")
    public List<customer> getCustomer(){
        return customerService.getCustomers();
    }

    record NewCustomer(Long id, String name,  String password, String email){};
    @PostMapping()
    public void addCustomer(@Valid  @RequestBody NewCustomer newCustomer){
        customer custo = new customer(newCustomer.id(),newCustomer.name(),newCustomer.password(),newCustomer.email());
        System.out.println("create a new customer");
        System.out.println(custo.getName()+' '+custo.getId());
    }

   /* @GetMapping("{customerId}")
    public List<customer> getCustomersOrderByName(@PathVariable("customerId") Long id){
        return customerService.getCustomersOrdersByName(id);
    }*/
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
