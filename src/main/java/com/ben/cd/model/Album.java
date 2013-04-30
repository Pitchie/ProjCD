package com.ben.cd.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.validator.constraints.Length;

import com.ben.cd.CDObject;

public class Album extends CDObject{
private static final int FIELD_LENGTH = 255;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = FIELD_LENGTH)
	@NotNull(message = "Le titre est obligatoire. ")
	@Length(min = 1, message = "Le titre doit contenir au moins 1 caract�re. ")
	private String titre;

	@Override
	@XmlElement
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

