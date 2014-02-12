package com.ped.myneightool.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
@Entity
public class Emprunt implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Outil tool;
	private int idEmprunteur;
	private Timestamp dateDebut;
	private Timestamp dateFin;
	
	public Emprunt() { }
	public Emprunt(int id, Outil tool, int idEmprunteur, Timestamp dateDebut,
			Timestamp dateFin) {
		super();
		this.id = id;
		this.tool = tool;
		this.idEmprunteur = idEmprunteur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Outil getTool() {
		return tool;
	}
	public void setTool(Outil tool) {
		this.tool = tool;
	}
	public int getIdEmprunteur() {
		return idEmprunteur;
	}
	public void setIdEmprunteur(int idEmprunteur) {
		this.idEmprunteur = idEmprunteur;
	}
	public Timestamp getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Timestamp getDateFin() {
		return dateFin;
	}
	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}
	
	

}
