package com.uol.productms.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;



public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String name;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String description;
	
	private Double price;
	
	
	//Constructors
	public ProductDTO() {
		
	}


	public ProductDTO(String name, String description, Double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	
	 
	
	
}