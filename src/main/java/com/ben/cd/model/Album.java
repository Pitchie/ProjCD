package com.ben.cd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;

import com.ben.cd.CDObject;

@Entity
@XmlRootElement
public class Album extends CDObject{
private static final int FIELD_LENGTH = 255;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = FIELD_LENGTH)
	@Length(min = 1, message = "Le titre doit contenir au moins 1 caractère. ")
	private String titre;
	
	@ManyToOne
	Categorie categorie;

	@Override
	@XmlElement
	public Long getId() {
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}

