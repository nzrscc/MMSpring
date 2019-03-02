package it.mastermind.mmspring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MmspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmspringApplication.class, args);
    }

    public static Logger getLogger() {
        return logger;
    }

    private static final Logger logger = LogManager.getLogger(MmspringApplication.class);
}
