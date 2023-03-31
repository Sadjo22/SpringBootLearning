package com.peguycode.demo.Customer;

import com.peguycode.demo.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@EnableConfigurationProperties(InfoApp.class)
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo:false}")
    private Boolean useFakeCustomerRepo;
    @Value("${info.company.name}")
    private String companyName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp){
        return args -> {
            System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
            System.out.println("info.company.name = " + companyName);
            System.out.println("infoApp = " + infoApp);
            System.out.println(environment.getProperty("info.app.version"));
        };
    }
    @Bean
    CustomerRepo customerRepo(){
      return new CustomerFakeRepository();
    }
}
