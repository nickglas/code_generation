package com.nickglas.gc.Code.generation;

import com.nickglas.gc.Code.generation.models.Transaction;
import com.nickglas.gc.Code.generation.models.TransactionType;
import com.nickglas.gc.Code.generation.services.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class CodeGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGenerationApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(TransactionService transactionService){
		return args -> {
			Transaction Trans1 = transactionService.createTransaction(new Transaction("IBNA_000_FROM", "IBNA_001_TO", TransactionType.transaction));
			Transaction Trans2 = transactionService.createTransaction(new Transaction("IBNA_001_TO", "IBNA_001_TO", TransactionType.deposit));
			Transaction Trans3 = transactionService.createTransaction(new Transaction("IBNA_004_FROM", "IBNA_004_FROM", TransactionType.withdraw));
			log.info("Created test transaction {}" , Trans1.toString());
			log.info("Created test transaction {}" , Trans2.toString());
			log.info("Created test transaction {}" , Trans3.toString());
			//transactionService.createTransaction(new TransactionTransfer("ibanfrom", "ibanto", TransactionType.transaction));
		};
	}

}
