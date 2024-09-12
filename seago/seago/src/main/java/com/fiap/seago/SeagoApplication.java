package com.fiap.seago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class SeagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeagoApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home(){
		return "Bem Vindo à API SeaGO!";
	}
}
