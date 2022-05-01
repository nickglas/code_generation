package com.nickglas.gc.Code.generation;

import com.nickglas.gc.Code.generation.models.Transaction;
import com.nickglas.gc.Code.generation.models.TransactionType;
import com.nickglas.gc.Code.generation.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Slf4j
public class CodeGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGenerationApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
