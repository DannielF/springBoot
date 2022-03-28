package com.springboot;

import com.springboot.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	/**
	 * Dependency injection
	 */
	private ComponentDependency componentDependency;

	public Application(@Qualifier("componentToImplement") ComponentDependency componentDependency) {
		this.componentDependency = componentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Run dependency from another object
	 * @param args String
	 * @throws Exception exception
	 */
	@Override
	public void run(String... args) throws Exception {
		componentDependency.greetings();
	}
}
