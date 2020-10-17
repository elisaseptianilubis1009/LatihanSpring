package com.springboot.elisa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jurusan {
	
	
	private Long id;
	
	private String nama;
	private Fakultas fakultas;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	
	@ManyToOne
	public Fakultas getFakultas() {
		return fakultas;
	}
	public void setFakultas(Fakultas fakultas) {
		this.fakultas = fakultas;
	}
	
	
	
	
	
	

}
