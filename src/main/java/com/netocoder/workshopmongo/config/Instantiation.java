package com.netocoder.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.netocoder.workshopmongo.domain.Post;
import com.netocoder.workshopmongo.domain.User;
import com.netocoder.workshopmongo.dto.AuthorDTO;
import com.netocoder.workshopmongo.repository.PostRepository;
import com.netocoder.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User u1 = new User(null,"NetoCoder","netocoder@hotmail.com");
		User u2 = new User(null, "TatiCoder", "tati@coder");
		User u3 = new User(null, "John of the Night", "jotn@coder.com");
		
		userRepository.deleteAll();//limpar o mongodb
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
		Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u2));
		
		postRepository.deleteAll();
		postRepository.saveAll(Arrays.asList(p1,p2));
				
	}
	
}
