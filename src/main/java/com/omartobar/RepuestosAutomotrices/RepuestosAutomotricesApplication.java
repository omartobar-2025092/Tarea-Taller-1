package com.omartobar.RepuestosAutomotrices;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepuestosAutomotricesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RepuestosAutomotricesApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("API Funcionando");
    }
}
