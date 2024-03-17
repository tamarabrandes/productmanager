package com.lexware.productmanager;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Products API", version = "1.0", description = "Productmanagement"))
public class ProductmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductmanagerApplication.class, args);
	}

}
