package com.anki.files.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Admin implements Serializable{
	int id;
	String password;
	String email;
}
