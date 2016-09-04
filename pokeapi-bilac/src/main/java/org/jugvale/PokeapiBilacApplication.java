package org.jugvale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan("org.jugvale.model.entities")
@EnableJpaRepositories("org.juvale.model.repositories")
public class PokeapiBilacApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeapiBilacApplication.class, args);
	}
}
