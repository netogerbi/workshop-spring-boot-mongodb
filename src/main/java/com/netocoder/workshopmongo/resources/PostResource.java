package com.netocoder.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netocoder.workshopmongo.domain.Post;
import com.netocoder.workshopmongo.resources.util.URL;
import com.netocoder.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<Post> findById(@PathVariable String id) {
 		Post obj = postService.findById(id);
 		return ResponseEntity.ok().body(obj);
 	}
	
	@RequestMapping(value="/title", method=RequestMethod.GET)
 	public ResponseEntity <List<Post>> findByTitle( @RequestParam(value="text", defaultValue="") String s) {
		String text = URL.decodeParam(s);
		List<Post> list = postService.finByTitle(text);
 		return ResponseEntity.ok().body(list);
 	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
 	public ResponseEntity <List<Post>> fullSearch( 
 			@RequestParam(value="text", defaultValue="") String s,
 			@RequestParam(value="minDate", defaultValue="") String min,
 			@RequestParam(value="maxDate", defaultValue="") String max
 			) {
		String text = URL.decodeParam(s);
		Date minDate = URL.convertDate(min, new Date(0L));
		Date maxDate = URL.convertDate(max, new Date());
		List<Post> list = postService.fullSearch(text, minDate, maxDate);
 		return ResponseEntity.ok().body(list);
 	}
	
}
