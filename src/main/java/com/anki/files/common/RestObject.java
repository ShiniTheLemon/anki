package com.anki.files.common;

import lombok.Data;

@Data
public class RestObject {
	private int status;
	private String info;
	private Object data;
	
	public static RestObject Ok(String info, Object data) {
		RestObject object=new RestObject();
		object.setStatus(200);
		object.setInfo(info);
		object.setData(data);
		return object;
	}
	
	public static RestObject Error(String info) {
		RestObject object=new RestObject();
		object.setStatus(400);
		object.setInfo(info);
		object.setData(null);
		return object;
	}
	
}
