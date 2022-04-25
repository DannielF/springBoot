package com.springboot;

import com.springboot.bean.MyBean;
import com.springboot.bean.MyBeanWithDependency;
import com.springboot.component.ComponentDependency;
import com.springboot.entity.User;
import com.springboot.pojo.UserPojo;
import com.springboot.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(Application.class);

	/**
	 * Dependency injection
	 */
	private final ComponentDependency componentDependency;
	private final MyBean myBean;
	private final UserPojo userPojo;
	private final MyBeanWithDependency myBeanWithDependency;
	private final UserRepository userRepository;

	public Application(@Qualifier("componentToImplement") ComponentDependency componentDependency,
					   UserPojo userPojo,
					   MyBean myBean,
					   MyBeanWithDependency myBeanWithDependency,
					   UserRepository userRepository)
	{
		this.componentDependency = componentDependency;
		this.userPojo = userPojo;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.userRepository = userRepository;
	}

	/**
	 * Run dependency from another object
	 * @param args String
	 */
	@Override
	public void run(String... args) {

	}

	private void getInfoJPQLFromUser() {
		LOGGER.info(userRepository.findByUserEmail("juan@mail.com")
					.orElseThrow(()-> new RuntimeException("No se encontro el usuario")));

		userRepository.findAndSort("a", Sort.by("id").descending())
				.forEach(LOGGER::info);
	}

	private void saveUserDataBase() {
		User user1 = new User("Juan","juan@mail.com", LocalDate.of(2021,10,6));
		User user2 = new User("maria","maria@mail.com", LocalDate.of(2021,8,4));

		List<User> userList = Arrays.asList(user1, user2);
		userList.forEach(userRepository::save);
	}


	public void previousExamples() {
		componentDependency.greetings();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		LOGGER.error("Error from Logger");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
