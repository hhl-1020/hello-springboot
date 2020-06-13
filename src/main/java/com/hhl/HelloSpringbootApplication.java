package com.hhl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@RestController
@MapperScan(basePackages = "com.hhl.mapper")
public class HelloSpringbootApplication {
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String sayHello(){
        return "Hello Spring Boot";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloSpringbootApplication.class, args);
    }

}
