package com.gjh;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Demo0Application{

	public static void main(String[] args)
		{
			System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(Demo0Application.class, args);
	}


}
