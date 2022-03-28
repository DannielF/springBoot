package com.springboot;

import com.springboot.bean.MyBean;
import com.springboot.bean.MyBeanWithDependency;
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
	private final ComponentDependency componentDependency;
	private final MyBean myBean;
	private final MyBeanWithDependency myBeanWithDependency;

	public Application(@Qualifier("componentToImplement") ComponentDependency componentDependency,
					   MyBean myBean,
					   MyBeanWithDependency myBeanWithDependency)
	{
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}

	/**
	 * Run dependency from another object
	 * @param args String
	 */
	@Override
	public void run(String... args) {
		componentDependency.greetings();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
