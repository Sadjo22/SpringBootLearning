package com.peguycode.demo.Customer;

import com.peguycode.demo.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.function.Supplier;

@Service
@Primary
public class CustomerService {

    private final CustomerRepository customerRepo;

    @Autowired
    public CustomerService(CustomerRepository customerRepo){
        this.customerRepo = customerRepo;
    }

    List<customer> getCustomers(){
        return customerRepo.findAll();
    }

    public customer getCustomer( Long id){
        return customerRepo
                .findById(id)
                .orElseThrow(()->new NotFoundException("customer with id " + id +" not found"));
       /* return customerRepo.findAll()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new NotFoundException("customer with id " + id +" not found"));*/
    }

  /*  public List<customer> getCustomersOrdersByName(Long id){
        return customerRepo.findcustomerByIdOrderByNameDesc(id);
    }*/

}
