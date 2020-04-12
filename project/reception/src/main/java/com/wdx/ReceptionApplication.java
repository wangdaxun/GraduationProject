package com.wdx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan   //启动器启动时，扫描本目录以及子目录带有的webservlet注解的

@SpringBootApplication
public class ReceptionApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReceptionApplication.class);
	}

}
