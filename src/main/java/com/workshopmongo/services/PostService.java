package com.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workshopmongo.domain.Post;
import com.workshopmongo.repository.PostRepository;
import com.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
		//the service class is the one responsible of managing the repository interface, providing methods for searching  in it while avoiding inconsistencies
		@Autowired
		private PostRepository repo;
		
		public Optional<Post> findById(String id) {
			Optional<Post> post = repo.findById(id);
			if(post== null) {
				throw new ObjectNotFoundException("Objeto não encontrado");
			}
			return post	;
			
			
		}
		public List<Post> findByTitle(String text){
			return repo.searchTitle(text);
		}
		public List<Post> fullSearch(String text, Date minDate, Date maxDate){
			maxDate = new Date(maxDate.getTime() + 2460*60*1000);
			return repo.fullSearch(text, minDate, maxDate);
		}

}
