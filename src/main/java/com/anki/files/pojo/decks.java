package com.anki.files.pojo;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;
@Data
public class decks implements Serializable {
	private int id;
	private int user_id;
	private String  word;
	private String meaning;
	private String deck_name;
	private int status;

}
