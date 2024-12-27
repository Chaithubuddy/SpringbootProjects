package com.chaithu.entity;

import jakarta.persistence.Entity;

@Entity
public class users {
	
	
	private Integer id;
	private String userName;
	private String password;
	private Authorities authorities;

}
