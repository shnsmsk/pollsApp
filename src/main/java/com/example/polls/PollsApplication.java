package com.example.polls;

import com.example.polls.controller.UserController;
import com.example.polls.payload.UserIdentityAvailability;
import com.example.polls.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.util.TimeZone;


@SpringBootApplication
@EntityScan(basePackageClasses = {
		PollsApplication.class,
		Jsr310JpaConverters.class
})
public class PollsApplication  implements CommandLineRunner {

	@Autowired
	UserController userController;

	@Autowired
	UserRepository userRepository;


	UserIdentityAvailability userIdentityAvailability;

	public PollsApplication(UserController userController) {
		this.userController = userController;
	}

	@PostConstruct
	void init(){
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PollsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}






