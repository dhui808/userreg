package com.userreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UserregApplication {

	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = configuration(new SpringApplicationBuilder());
		SpringApplication app = builder.build();
		Environment env = app.run(args).getEnvironment();
		System.out.println("appversion=" + env.getProperty("appversion"));
		System.out.println("port=" + env.getProperty("server.port"));
	}
	
	private static SpringApplicationBuilder configuration(SpringApplicationBuilder builder) {
        return builder.sources(UserregApplication.class);
    }
}
