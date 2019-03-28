package com.netocoder.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netocoder.workshopmongo.domain.Post;
import com.netocoder.workshopmongo.repository.PostRepository;
import com.netocoder.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Post obj = postRepository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado!"));
		return obj;
	}
	
	public List<Post> finByTitle(String text) {
		return postRepository.searchTitle(text);
	}
	
}
