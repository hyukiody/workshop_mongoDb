package com.workshopmongo.dto;

import java.io.Serializable;
import java.util.Optional;

import com.workshopmongo.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;

	public UserDTO() {
	}
	public UserDTO(Optional<User> obj) {
        if (obj.isPresent()) {
            User user = obj.get();
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
        } else {
            // Handle the case where the optional is empty
            this.id = null;
            this.name = null;
            this.email = null;
        }
    }
	
	public UserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
