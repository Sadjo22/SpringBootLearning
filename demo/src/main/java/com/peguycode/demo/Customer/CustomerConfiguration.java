package com.peguycode.demo.Customer;

import com.peguycode.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(InfoApp.class)
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;
    @Value("${info.company.name}")
    private String companyName;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp app){
        return args -> {
            System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
            System.out.println("info.company.name = " + companyName);
            System.out.println("infoApp = " + app);
        };
    }
    @Bean
    CustomerRepo customerRepo(){
      return new CustomerFakeRepository();
    }
}
