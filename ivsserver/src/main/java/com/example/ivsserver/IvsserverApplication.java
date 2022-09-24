package com.example.ivsserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com/example/ivsserver/mapper")
@SpringBootApplication
public class IvsserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(IvsserverApplication.class, args);
	}

}
