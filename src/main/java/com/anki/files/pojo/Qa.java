package com.anki.files.pojo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Qa implements Serializable{
	private int id;
	private int admin_id;
	private int user_id;
	private String questions;
	private String answers;
}
