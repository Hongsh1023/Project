package com.bit.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class JavaKing_SpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaKing_SpringApplication.class, args);
	}

}
