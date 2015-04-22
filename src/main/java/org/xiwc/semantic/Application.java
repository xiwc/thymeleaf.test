package org.xiwc.semantic;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.xiwc.semantic.entity.Test;
import org.xiwc.semantic.entity.TestRepository;

@SpringBootApplication
public class Application {

	@Autowired
	TestRepository testRepository;

	@Bean
	public CommandLineRunner initDBRunner() {
		return new CommandLineRunner() {

			@Override
			public void run(String... arg0) throws Exception {
				Stream.of(new Test("zhang", "san", "zhangsan", "zhangsan", true, 30D),
						new Test("li", "si", "lisi", "lisi", false, 28D),
						new Test("wang", "wu", "wangwu", "wangwu", true, 40D)).forEach(testRepository::save);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
