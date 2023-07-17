package com.anki.files.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;


@Data
public class DecksInsert implements Serializable{
	private int id;
	private int user_id;
	private ArrayList<String>  word;
	private ArrayList<String> meaning;
	private String deck_name;
	private int status;
  
}
