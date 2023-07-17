package com.anki.files.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Users implements Serializable{
	private int id;
	private String user_name;
	private String email;
	private String password;
	private String verification;
	private int count;
}
