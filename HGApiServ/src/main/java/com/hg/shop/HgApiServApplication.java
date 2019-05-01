package com.hg.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HgApiServApplication {

	public static void main(String[] args) {
		SpringApplication.run(HgApiServApplication.class, args);
	}
}
