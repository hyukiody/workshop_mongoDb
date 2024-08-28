package com.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.workshopmongo.domain.Post;
import com.workshopmongo.domain.User;
import com.workshopmongo.dto.AuthorDTO;
import com.workshopmongo.dto.CommentDTO;
import com.workshopmongo.repository.PostRepository;
import com.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		userRepository.deleteAll();
		// higieniza o banco de dados
		// cleans the database

		User maria = new User(null, "maria maria", "maria2@gmail.com");
		User alex = new User(null, "Alex lex", "alex2@gmail.com");
		User bob = new User(null, "Bob bob", "bobob@gmail.com");
		// instantiates the users
		// instancia os usuários

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		// sends them to the repo
		// salva-os no repositorio

		Post post1 = new Post(null, sdf.parse("21/03/2020"), "Partiu viagem!", "Vou viajar pra lá. Valeu falou!",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("24/03/2020"), "Bom dia!", "Acordei pra lá de Bagda!",
				new AuthorDTO(maria));
		// instantiates the posts and their references for the authors
		// instancia os posts e referencia aos usuarios devidos

		CommentDTO c1 = new CommentDTO("Boa viagem, cabron!", sdf.parse("21/03/2020"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Tmj!", sdf.parse("22/03/2020"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Pera tem alguém me ligando", sdf.parse("23/03/2020"), new AuthorDTO(alex));

		// instantiates the comments and their authors

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		// relates the posts to the comments instantiated

		postRepository.saveAll(Arrays.asList(post1, post2));
		// sends them to the repository

		maria.getPosts().addAll(Arrays.asList(post1, post2));

		postRepository.saveAll(Arrays.asList(post1, post2));

		userRepository.save(maria);
		// changes made on the objects must be updated on the database
	}

}