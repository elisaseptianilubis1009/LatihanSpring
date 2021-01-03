package com.springboot.elisa.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {
	
	private Long ID;
	private String NAME;
	private Date BIRTH_DATE;
	private Position position;
	private Integer ID_NUMBER;
	private Integer GENDER;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public Date getBIRTH_DATE() {
		return BIRTH_DATE;
	}
	public void setBIRTH_DATE(Date bIRTH_DATE) {
		BIRTH_DATE = bIRTH_DATE;
	}
	

	@ManyToOne
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	@Column(nullable = false, unique = true)
	public Integer getID_NUMBER() {
		return ID_NUMBER;
	}
	public void setID_NUMBER(Integer iD_NUMBER) {
		ID_NUMBER = iD_NUMBER;
	}
	public Integer getGENDER() {
		return GENDER;
	}
	public void setGENDER(Integer gENDER) {
		GENDER = gENDER;
	}
	
	

}
