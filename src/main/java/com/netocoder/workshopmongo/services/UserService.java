package com.netocoder.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netocoder.workshopmongo.domain.User;
import com.netocoder.workshopmongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User fromDto(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
	
}
