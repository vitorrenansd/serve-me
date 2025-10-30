package com.tcc.serveme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tcc.serveme.api.repository.ProductRepository;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

        ProductRepository pr = context.getBean(ProductRepository.class);

		System.out.println("\nfindById() method");
        System.out.println(pr.findById(2L));
		System.out.println("\nfindAll() method");
        System.out.println(pr.findAll());
	}
}