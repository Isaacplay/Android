package com.example.a300box.domain;

import java.io.Serializable;

public class id implements Serializable {
	private Integer id;
	private String name;


	public id(String name) {
		this.name = name;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
