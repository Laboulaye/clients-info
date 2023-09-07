package com.task.ClientsInfo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Client contacts REST Api", version = "1.0",
		description = "Rest service with CRUD functions"))
@SpringBootApplication
public class ClientsInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsInfoApplication.class, args);
	}

}
