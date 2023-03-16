package com.peguycode.demo.jsonplaceholder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonPlaceHolderConfiguration {

   /* @Bean("jsonplaceholder")
    CommandLineRunner runner(JsonPlaceholderClient jsonplaceholderclient){
        return args -> {
            System.out.println("https://jsonplaceholder.typicode.com/");
            System.out.println(jsonplaceholderclient
                    .getPosts()
                    .stream()
                    .count());



        };
    }*/
}
