package com.example.polls;

import com.example.polls.controller.UserController;
import com.example.polls.model.Choice;
import com.example.polls.model.Poll;
import com.example.polls.payload.ChoiceRequest;
import com.example.polls.payload.PollLength;
import com.example.polls.payload.PollRequest;
import com.example.polls.payload.UserIdentityAvailability;
import com.example.polls.repository.PollRepository;
import com.example.polls.repository.UserRepository;
import com.example.polls.security.UserPrincipal;
import com.example.polls.service.PollService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

	PollRequest pollRequest;

	@Autowired
	PollService pollService;

	@Autowired
	PollRepository pollRepository;


	UserIdentityAvailability userIdentityAvailability;


	UserPrincipal userPrincipal;

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
		/***
		  Poll poll=pollRepository.getReferenceById(1L);
		System.out.println(poll.getQuestion());
		poll.setUpdatedBy(8L);
		poll.setCreatedBy(1L);
		pollRepository.save(poll);
		 ***/
	}
}






