package com.peguycode.demo.Customer;

import com.peguycode.demo.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@Primary
//@AllArgsConstructor
@Slf4j
public class CustomerService {

   // private final  static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    Optional<String> optionalString = Optional.of("toto");
    private final CustomerRepository customerRepo;
    public CustomerService(CustomerRepository customerRepo){
        this.customerRepo = customerRepo;
    }
    public List<customer> getCustomers(){
        log.info("getCustomers was call");
        return customerRepo.findAll();
    }

    public customer getCustomer(Long id){

        log.info("getCustomer was call");
        return customerRepo
                .findById(id)
                .orElseThrow(()->{
                    NotFoundException notFoundException= new NotFoundException("customer with id " + id +" not found");
                    log.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });

    };

    public customer getCustomerByName(String name){
        return customerRepo.findByName(name);
    };

  /*  public List<customer> getCustomersOrdersByName(Long id){
        return customerRepo.findcustomerByIdOrderByNameDesc(id);
    }*/

}
