package com.educando.course.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyy-MM-dd HH:mm:ss",timezone = "GMT")
	private Instant timestamp;
	private Integer satus;
	private String erro;
	private String message;
	private String path;
	
	public StandardError() {}
	
	public StandardError(Instant timestamp, Integer satus, String erro, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.satus = satus;
		this.erro = erro;
		this.message = message;
		this.path = path;
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getSatus() {
		return satus;
	}
	public void setSatus(Integer satus) {
		this.satus = satus;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
