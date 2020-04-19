package sone.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sone.spring.demo.config.AppProperties;
import sone.spring.demo.config.MojTest;

@SpringBootApplication
public class SpringBootConfigurationPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigurationPropertiesApplication.class, args);
	}

}
