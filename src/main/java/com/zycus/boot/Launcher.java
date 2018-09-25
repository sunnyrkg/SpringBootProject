package com.zycus.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={
		"com.zycus.boot.controllers",
		"com.zycus.boot.services"
})
@EnableJpaRepositories(basePackages="com.zycus.boot.repositories")
@EntityScan(basePackages="com.zycus.boot.entities")
@EnableCaching
public class Launcher {
	public static void main(String...arg)
	{	
		SpringApplication.run(Launcher.class, arg);
		
	}
}

