package com.anki.files;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.anki.files.mapper")
public class AnkiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnkiApplication.class, args);
	}

}
