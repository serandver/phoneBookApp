package com.app.phonebook;

import com.app.phonebook.service.impl.Populator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MainApp {

	@Autowired
	private Populator populator;

	@PostConstruct
	private void init(){
		populator.init();
	}

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
