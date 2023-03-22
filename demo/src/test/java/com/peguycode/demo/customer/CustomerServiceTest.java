package com.peguycode.demo.customer;

import com.peguycode.demo.Customer.CustomerRepository;
import com.peguycode.demo.Customer.CustomerService;
import com.peguycode.demo.Customer.customer;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService underTest;
    @Autowired
    private CustomerRepository customerRepository;
    @BeforeEach
    void setUp(){
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown(){
        customerRepository.deleteAll();
    }

   /* @Test
    void GetCustomers(){
        customer Jamila = new customer(1L,"Jamila","jamitest","jamila@gmail.com");
        customer mila = new customer(2L,"mila","milatest","mila@gmail.com");

        customerRepository.save(Jamila);
        customerRepository.save(mila);

        List<customer> customerList = underTest.getCustomers();
        assertEquals(2,customerList.size());

    }*/

   /* @Test
    void getCustomer(){
        customer Jamila = new customer(1L,"Jamila","jamitest","jamila@gmail.com");

        customerRepository.save(Jamila);

        customer actual = underTest.getCustomer(1L);
        assertEquals(1L,actual.getId());
        assertEquals("Jamila",actual.getName());
        assertEquals("jamitest",actual.getPassword());
        assertEquals("jamila@gmail.com",actual.getEmail());

    }*/
}
