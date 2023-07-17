package com.anki.files.pojo;

import java.util.ArrayList;
import java.util.Map;

import lombok.Data;

@Data
public class Results {
	private ArrayList<String>rightAnswers;
	private ArrayList<String>wrongAnswers;
	private ArrayList<String> rightMeaning;
	private ArrayList<String> wrongMeaning;
}
