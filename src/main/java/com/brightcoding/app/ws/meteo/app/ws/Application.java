package com.brightcoding.app.ws.meteo.app.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.brightcoding.app.ws.meteo.app.exceptions.AppExceptionHandler;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
@Bean        
public BCryptPasswordEncoder bCryptPasswordEncoder()
{
  return new BCryptPasswordEncoder();
}

@Bean
public SpringApplicationContext springApplicationContext(){
 return new SpringApplicationContext();
}

@Bean
public AppExceptionHandler appExceptionHandler()
{
  return new AppExceptionHandler();	
}
}

