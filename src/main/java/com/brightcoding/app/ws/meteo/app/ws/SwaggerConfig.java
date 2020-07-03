package com.brightcoding.app.ws.meteo.app.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.select() //select toutes les routes dans le package principal
				.apis(RequestHandlerSelectors.basePackage("com.brightcoding.app.ws.meteo.app.ws"))
				.build();
		return docket;
	}

}
