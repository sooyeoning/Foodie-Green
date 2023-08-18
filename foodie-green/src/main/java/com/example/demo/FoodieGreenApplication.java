package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "user")
@ComponentScan(basePackages = {"recipes"})
@ComponentScan(basePackages = {"store"})
@MapperScan(basePackages = {"user"})
public class FoodieGreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodieGreenApplication.class, args);
	}

}
