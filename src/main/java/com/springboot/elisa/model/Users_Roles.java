package com.springboot.elisa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users_Roles {

	private Long id;
	private String id_users;
	private String id_roles;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getId_users() {
		return id_users;
	}
	public void setId_users(String id_users) {
		this.id_users = id_users;
	}
	public String getId_roles() {
		return id_roles;
	}
	public void setId_roles(String id_roles) {
		this.id_roles = id_roles;
	}
	
	

}
