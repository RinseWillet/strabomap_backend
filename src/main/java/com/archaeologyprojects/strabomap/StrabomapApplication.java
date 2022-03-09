package com.archaeologyprojects.strabomap;

//Spring
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StrabomapApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrabomapApplication.class, args);
		System.out.println("StraboMap App Backend is running");
	}

}
