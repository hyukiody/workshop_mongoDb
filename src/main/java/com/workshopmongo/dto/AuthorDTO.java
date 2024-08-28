package com.workshopmongo.dto;

import java.io.Serializable;

import com.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
	//interesting procedure here, where the lecturer uses these DataTransferObjects classes as shells for referencing the original User Classes to be related to the comments and Posts; instead of pointing the the classes themselves, the classes point to the shell classes. He himself says in the lecture that this DTO procedure is interesting because you get to create as many references to the original class as you want, without the risk of messing up with them, and still access them easily since it's these DTO classes that are related to the original classes.
	private static final long serialVersionUID = 1L;

	
	private String id;
	private String name;

	public AuthorDTO() {
	}

	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
