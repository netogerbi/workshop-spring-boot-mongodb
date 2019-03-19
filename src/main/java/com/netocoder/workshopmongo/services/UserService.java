package com.netocoder.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netocoder.workshopmongo.domain.User;
import com.netocoder.workshopmongo.repository.UserRepository;
import com.netocoder.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
		return user;
	}
	
}
