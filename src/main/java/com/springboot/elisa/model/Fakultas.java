package com.springboot.elisa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fakultas {

	private Long id;
	private String nama_fakultas;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNama_fakultas() {
		return nama_fakultas;
	}
	public void setNama_fakultas(String nama_fakultas) {
		this.nama_fakultas = nama_fakultas;
	}
	
	
}
