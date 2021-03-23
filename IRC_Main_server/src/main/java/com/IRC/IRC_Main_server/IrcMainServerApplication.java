package com.IRC.IRC_Main_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication()
public class IrcMainServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrcMainServerApplication.class, args);
	}

}
