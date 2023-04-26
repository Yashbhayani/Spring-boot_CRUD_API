package com.blogboot.yash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.blogboot.controller")
public class BlogappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogappApplication.class, args);
		System.out.println("Yash");
	}

}
