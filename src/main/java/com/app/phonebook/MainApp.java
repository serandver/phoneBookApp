package com.app.phonebook;

import com.app.phonebook.service.impl.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MainApp extends SpringBootServletInitializer {

	@Autowired
	private Populator populator;

	@PostConstruct
	private void init(){
		populator.init();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MainApp.class);
	}

	public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
