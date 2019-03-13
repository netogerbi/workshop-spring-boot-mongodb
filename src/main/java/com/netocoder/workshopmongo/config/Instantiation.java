package com.netocoder.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.netocoder.workshopmongo.domain.User;
import com.netocoder.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null,"NetoCoder","netocoder@hotmail.com");
		User u2 = new User(null, "TatiCoder", "tati@coder");
		User u3 = new User(null, "John of the Night", "jotn@coder.com");
		
		userRepository.deleteAll();//limpar o mongodb
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
	}
	
}
