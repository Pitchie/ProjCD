package com.ben.cd.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.validator.constraints.Length;

import com.ben.cd.CDObject;

public class Categorie extends CDObject{
	private static final int FIELD_LENGTH = 255;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = FIELD_LENGTH)
	@Length(min = 1, message = "Le titre doit contenir au moins 1 caractère. ")
	private String categorie;

	@Override
	@XmlElement
	public Long getId() {
		return null;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

}
