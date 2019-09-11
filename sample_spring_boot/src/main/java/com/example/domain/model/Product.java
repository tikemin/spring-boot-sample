package com.example.domain.model;

import java.io.Serializable;

/**
 * 商品(Product) POJO
 */
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String url;
	private String imgsrc;

	private String description;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
