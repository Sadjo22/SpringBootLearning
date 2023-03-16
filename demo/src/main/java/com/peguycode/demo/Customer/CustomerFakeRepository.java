package com.peguycode.demo.Customer;

import java.util.Arrays;
import java.util.List;


public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<customer> getCustomer() {
        return Arrays.asList(
                new customer(1L,"James Bond","123","email@gmail.com"),
                new customer(2L,"Jamila Ahmed","333","email@gmail.com")
        );
    }
}
