package org.xiwc.semantic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.xiwc.semantic.entity.Sex;
import org.xiwc.semantic.entity.Test;
import org.xiwc.semantic.entity.TestRepository;

@SpringBootApplication
public class Application {

	static Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	TestRepository testRepository;

	@Bean
	public CommandLineRunner initDBRunner() {
		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				logger.info("Do some initial operation.");

				Test test = testRepository.saveAndFlush(new Test("first",
						"last", "name",
						"password", Sex.GIRL, 20D));
				
				testRepository.findAll().forEach(System.out::println);

			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
