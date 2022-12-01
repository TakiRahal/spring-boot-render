package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@RestController
public class DemoApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("fetch-user")
	public String fetchUsers(){
		Optional<User> userOptional = userRepository.findById(1L);
		if( userOptional.isPresent() ){
			return userOptional.get().getFirstName() +" "+userOptional.get().getLastName();
		}
		return "Not found";
	}

	@GetMapping("add-user")
	public String addUser(){
		User user = new User();
		user.setFirstName("Render");
		user.setLastName("Spring Boot");
		userRepository.save(user);
		return "User added successfully";
	}

}
