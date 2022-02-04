package com.example.convertor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info = @Info(title = "Convertor API", version = "2.0", description = "Convertor API Information"))
public class ConvertorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertorApplication.class, args);
	}

}
