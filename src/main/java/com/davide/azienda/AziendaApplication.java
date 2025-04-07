package com.davide.azienda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AziendaApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AziendaApplication.class);

	public static void main(String[] args) {
	    try {
	        SpringApplication.run(AziendaApplication.class, args);
	    } catch (Throwable e) {
	        if(e.getClass().getName().contains("SilentExitException")) {
	            LOGGER.debug("Spring is restarting the main thread - See spring-boot-devtools");
	        } else {
	            LOGGER.error("Application crashed!", e);
	        }
	    }
	}

}
