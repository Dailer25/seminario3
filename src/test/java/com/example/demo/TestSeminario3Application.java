package com.example.demo;

import org.springframework.boot.SpringApplication;

public class TestSeminario3Application {

	public static void main(String[] args) {
		SpringApplication.from(Seminario3Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
